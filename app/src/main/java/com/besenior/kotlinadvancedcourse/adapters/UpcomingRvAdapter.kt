package com.besenior.kotlinadvancedcourse.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.besenior.kotlinadvancedcourse.R
import com.besenior.kotlinadvancedcourse.databinding.UpcomingRvItemsBinding
import com.besenior.kotlinadvancedcourse.models.NotesModel

class UpcomingRvAdapter(private val model: ArrayList<NotesModel>) : RecyclerView.Adapter<UpcomingRvAdapter.UpcomingRvViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingRvViewHolder {
        val upcomingRvItemsBinding: UpcomingRvItemsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.upcoming_rv_items,parent,false)
        return UpcomingRvViewHolder(upcomingRvItemsBinding)
    }

    override fun onBindViewHolder(holder: UpcomingRvViewHolder, position: Int) {
        holder.bind(model[position])
    }

    override fun getItemCount() = model.size

    class UpcomingRvViewHolder(private val binding: UpcomingRvItemsBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(notesModel: NotesModel) {

            binding.pinnedtitle.text = notesModel.title
            binding.pinneddescription.text = notesModel.note
            binding.executePendingBindings()
        }
    }
}