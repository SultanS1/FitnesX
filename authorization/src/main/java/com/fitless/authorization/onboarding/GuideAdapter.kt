package com.fitless.authorization.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fitless.authorization.R
import com.fitless.authorization.databinding.GuideItemBinding

class GuideAdapter: RecyclerView.Adapter<GuideAdapter.ViewHolder>() {

    private var guideList: MutableList<GuideItem> = mutableListOf()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = GuideItemBinding.bind(itemView)

        fun bind(guideItem: GuideItem){
            binding.guidIc.setImageResource(guideItem.icon)
            binding.guideTxt.text = guideItem.guideText
            binding.guideTitleTxt.text = guideItem.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.guide_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: GuideAdapter.ViewHolder, position: Int) {
        val getItemCount = guideList.count()
        holder.bind(guideList[getItemCount])
    }

    override fun getItemCount(): Int {
        return guideList.size
    }

    fun setList(newList: List<GuideItem>){
        guideList.clear()
        guideList.addAll(newList)
        notifyItemChanged(itemCount)
    }

}