package com.fitless.authorization.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fitless.authorization.R
import com.fitless.authorization.databinding.GuideItemBinding

class GuideRvAdapter: RecyclerView.Adapter<GuideRvAdapter.ViewHolder>() {

    private var guideList: List<GuideItem> = emptyList()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding = GuideItemBinding.bind(itemView)

        fun bind(guideItem: GuideItem){
            binding.guidIc.setImageResource(guideItem.icon)
            binding.guideTxt.text = guideItem.guideText
            binding.guideTitleTxt.text = guideItem.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideRvAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.guide_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: GuideRvAdapter.ViewHolder, position: Int) {
        holder.bind(guideList[position])
    }

    override fun getItemCount(): Int {
        return guideList.size
    }

    fun setList(newList: List<GuideItem>){
        guideList = newList
        notifyItemChanged(itemCount)
    }

}