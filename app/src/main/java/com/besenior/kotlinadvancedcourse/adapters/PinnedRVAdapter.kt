package com.besenior.kotlinadvancedcourse.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.PrecomputedTextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.besenior.kotlinadvancedcourse.R
import com.besenior.kotlinadvancedcourse.databinding.PinnedRvItemsBinding
import com.besenior.kotlinadvancedcourse.room.entities.NoteEntity
import java.util.ArrayList

class PinnedRVAdapter(private var data: ArrayList<NoteEntity>,private var listener: CardClickListener) : RecyclerView.Adapter<PinnedRVAdapter.PinnedRvViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PinnedRvViewHolder {
        val pinnedRvItemsBinding:PinnedRvItemsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.pinned_rv_items,parent,false)


        return PinnedRvViewHolder(pinnedRvItemsBinding)
    }

    override fun onBindViewHolder(holder: PinnedRvViewHolder, position: Int) {
        holder.bind(data.get(position),listener)
    }

    override fun getItemCount(): Int {
        return data.size
    }


    class PinnedRvViewHolder(private val binding: PinnedRvItemsBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(noteEntity: NoteEntity, listener: CardClickListener) {

            binding.pinnedcardview.setCardBackgroundColor(Color.parseColor(noteEntity.notesModel.color))
            binding.pinnedtitle.setTextFuture(
                PrecomputedTextCompat.getTextFuture(
                    noteEntity.notesModel.title,
                    binding.pinnedtitle.textMetricsParamsCompat,
                    null
                )
            )

            binding.pinneddescription.text = noteEntity.notesModel.note
            binding.pinnedcardview.setOnClickListener {
                listener.onItemClickListener(noteEntity)
            }

            binding.executePendingBindings()


        }

    }

}