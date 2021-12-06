package com.besenior.kotlinadvancedcourse.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.besenior.kotlinadvancedcourse.R
import com.besenior.kotlinadvancedcourse.databinding.UpcomingRvItemsBinding
import com.besenior.kotlinadvancedcourse.models.NotesModel
import com.besenior.kotlinadvancedcourse.room.entities.NoteEntity

class UpcomingRvAdapter(private val model: ArrayList<NoteEntity>) : RecyclerView.Adapter<UpcomingRvAdapter.UpcomingRvViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingRvViewHolder {
        val upcomingRvItemsBinding: UpcomingRvItemsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.upcoming_rv_items,parent,false)
        return UpcomingRvViewHolder(upcomingRvItemsBinding)
    }

    override fun onBindViewHolder(holder: UpcomingRvViewHolder, position: Int) {
        holder.bind(model[position])
    }

    override fun getItemCount() = model.size

    class UpcomingRvViewHolder(private val binding: UpcomingRvItemsBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(noteEntity: NoteEntity) {

            binding.pinnedtitle.text = noteEntity.notesModel.title
            binding.pinneddescription.text = noteEntity.notesModel.note
            binding.executePendingBindings()
        }
    }
}