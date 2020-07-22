package com.aldidwikip.mysubmission.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.aldidwikip.mysubmission.R
import com.aldidwikip.mysubmission.adapter.ListMealAdapter
import com.aldidwikip.mysubmission.fragment.ConnectionErrorFragment
import com.aldidwikip.mysubmission.model.DataMealModel
import com.aldidwikip.mysubmission.presenter.MainPresenter
import com.aldidwikip.mysubmission.view.MainView
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var rvMeals: RecyclerView
    private lateinit var skeleton: Skeleton
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Meal Recipes"

        presenter = MainPresenter(this)

        rvMeals = findViewById(R.id.rv_meals)
        rvMeals.setHasFixedSize(true)

        onDataLoaded(listOf())
        skeleton =
                rvMeals.applySkeleton(R.layout.item_list_meals, 10, shimmerDurationInMillis = 1000)

        presenter.loadMeals()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_about) {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showLoading() {
        skeleton.showSkeleton()
    }

    override fun hideLoading() {
        skeleton.showOriginal()
    }

    override fun onDataLoaded(list: List<DataMealModel>) {
        rvMeals.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        val listMealAdapter = ListMealAdapter(list)
        rvMeals.adapter = listMealAdapter

        listMealAdapter.setOnItemClickCallback(object : ListMealAdapter.OnItemClickCallback {
            override fun onItemClicked(data: DataMealModel) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_ID, data.idMeal)
                startActivity(intent)
            }
        })
    }

    override fun showConnectionError() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ConnectionErrorFragment(presenter), CONNECTION_ERROR_FRAGMENT)
                .commit()
        app_bar_layout.visibility = View.INVISIBLE
    }

    override fun hideConnectionError() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragment = supportFragmentManager.findFragmentByTag(CONNECTION_ERROR_FRAGMENT)
        fragment?.let {
            fragmentTransaction.remove(fragment)
            fragmentTransaction.commit()
        }
        app_bar_layout.visibility = View.VISIBLE
    }

    companion object {
        private const val CONNECTION_ERROR_FRAGMENT = "connection_error"
    }
}