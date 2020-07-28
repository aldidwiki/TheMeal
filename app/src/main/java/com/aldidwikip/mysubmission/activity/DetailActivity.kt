package com.aldidwikip.mysubmission.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aldidwikip.mysubmission.R
import com.aldidwikip.mysubmission.adapter.ListIngredientAdapter
import com.aldidwikip.mysubmission.model.DataDetailMealModel
import com.aldidwikip.mysubmission.presenter.DetailPresenter
import com.aldidwikip.mysubmission.view.DetailView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.createSkeleton
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), DetailView {
    private var toolbarTitle = "Detail Page"
    private lateinit var rvIngredient: RecyclerView
    private lateinit var skeleton: Skeleton
    private lateinit var detailParent: CoordinatorLayout
    private lateinit var presenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)
        collapsingToolbarLayout.title = toolbarTitle
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter = DetailPresenter(this)

        rvIngredient = findViewById(R.id.rv_ingredient)
        detailParent = findViewById(R.id.activity_detail)
        rvIngredient.setHasFixedSize(true)

        skeleton = detailParent.createSkeleton(shimmerDurationInMillis = 1000)
        showLoading()

        val idMeal = intent?.getStringExtra(EXTRA_ID)
        presenter.loadMealDetail(idMeal!!)
    }

    private fun showIngredientRecycler(listIngredient: MutableList<String>, listMeasure: MutableList<String>) {
        rvIngredient.layoutManager = LinearLayoutManager(this)
        val listIngredientAdapter = ListIngredientAdapter(listIngredient, listMeasure)
        rvIngredient.adapter = listIngredientAdapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showLoading() {
        skeleton.showSkeleton()
    }

    override fun hideLoading() {
        skeleton.showOriginal()
    }

    override fun showData(data: List<DataDetailMealModel>, listIngredient: MutableList<String>, listMeasure: MutableList<String>) {
        val requestOption = RequestOptions()
                .placeholder(R.drawable.no_image)
                .error(R.drawable.no_image)
        Glide.with(this)
                .load(data[0].strMealThumb)
                .apply(requestOption)
                .into(img_meal)

        toolbarTitle = data[0].strMeal
        tv_instructions.text = data[0].strInstructions

        collapsingToolbarLayout.title = toolbarTitle
        showIngredientRecycler(listIngredient, listMeasure)
    }

    companion object {
        const val EXTRA_ID = "extra_id"
    }
}