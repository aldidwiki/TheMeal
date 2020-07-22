package com.aldidwikip.mysubmission.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aldidwikip.mysubmission.R
import com.aldidwikip.mysubmission.model.DataMealModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_list_meals.view.*

class ListMealAdapter(private val mDataMeal: List<DataMealModel>) :
    RecyclerView.Adapter<ListMealAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_meals, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount() = mDataMeal.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        with(holder) {
            bind(mDataMeal[position])

            itemView.setOnClickListener {
                onItemClickCallback.onItemClicked(mDataMeal[adapterPosition])
            }
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mMealName: TextView = itemView.tv_item_name
        private val mImgMeal: ImageView = itemView.img_item_photo

        fun bind(data: DataMealModel) {
            mMealName.text = data.strMeal

            val requestOption = RequestOptions()
                .placeholder(R.drawable.no_image)
                .error(R.drawable.no_image)
            Glide.with(itemView.context)
                .load(data.strMealThumb)
                .apply(requestOption)
                .into(mImgMeal)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: DataMealModel)
    }
}