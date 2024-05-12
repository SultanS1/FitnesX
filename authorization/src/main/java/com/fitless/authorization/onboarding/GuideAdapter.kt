package com.fitless.authorization.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fitless.authorization.R
import com.fitless.authorization.databinding.GuideItemBinding

/**
 * RecyclerView adapter for displaying guide items.
 */
class GuideAdapter: RecyclerView.Adapter<GuideAdapter.ViewHolder>() {

    private var guideList: MutableList<GuideItem> = mutableListOf()

    /**
     * ViewHolder class for the GuideAdapter.
     * @param itemView The inflated view for each item.
     */
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = GuideItemBinding.bind(itemView)

        /**
         * Binds data to the ViewHolder.
         * @param guideItem The guide item data to bind.
         */
        fun bind(guideItem: GuideItem){
            binding.guidIc.setImageResource(guideItem.icon)
            binding.guideTxt.text = guideItem.guideText
            binding.guideTitleTxt.text = guideItem.title
        }

    }

    /**
     * Creates ViewHolders for the adapter.
     * @param parent The parent ViewGroup.
     * @param viewType The view type.
     * @return A ViewHolder instance.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.guide_item, parent, false)
        return ViewHolder(view)
    }

    /**
     * Binds data to the ViewHolder at the specified position.
     * @param holder The ViewHolder to bind data to.
     * @param position The position of the item in the list.
     */
    override fun onBindViewHolder(holder: GuideAdapter.ViewHolder, position: Int) {
        val getItemCount = guideList.count()
        holder.bind(guideList[getItemCount])
    }

    /**
     * Gets the number of items in the list.
     * @return The number of items.
     */
    override fun getItemCount(): Int {
        return guideList.size
    }

    /**
     * Sets a new list of guide items and notifies the adapter of the change.
     * @param newList The new list of guide items.
     */
    fun setList(newList: List<GuideItem>){
        guideList.clear()
        guideList.addAll(newList)
        notifyItemChanged(itemCount)
    }

}