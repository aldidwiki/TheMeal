package com.aldidwikip.mysubmission.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aldidwikip.mysubmission.R
import kotlinx.android.synthetic.main.item_ingredients_meal.view.*

class ListIngredientAdapter(
        private val listIngredient: List<String>,
        private val listMeasure: List<String>
) : RecyclerView.Adapter<ListIngredientAdapter.IngredientViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_ingredients_meal, parent, false)
        return IngredientViewHolder(view)
    }

    override fun getItemCount() = listIngredient.count { it != "" }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.mIngredient.text = listIngredient[position]
        holder.mMeasure.text = listMeasure[position]
    }

    inner class IngredientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mIngredient: TextView = itemView.tv_ingredient
        val mMeasure: TextView = itemView.tv_measure
    }
}