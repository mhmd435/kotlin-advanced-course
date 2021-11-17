package com.besenior.kotlinadvancedcourse.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.PrecomputedTextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.besenior.kotlinadvancedcourse.R
import com.besenior.kotlinadvancedcourse.databinding.PinnedRvItemsBinding
import com.besenior.kotlinadvancedcourse.models.NotesModel
import java.util.ArrayList

class PinnedRVAdapter(private var data: ArrayList<NotesModel>) : RecyclerView.Adapter<PinnedRVAdapter.PinnedRvViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PinnedRvViewHolder {
        val pinnedRvItemsBinding:PinnedRvItemsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.pinned_rv_items,parent,false)


        return PinnedRvViewHolder(pinnedRvItemsBinding)
    }

    override fun onBindViewHolder(holder: PinnedRvViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }


    class PinnedRvViewHolder(private val binding: PinnedRvItemsBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(notesModel: NotesModel) {

            binding.pinnedtitle.setTextFuture(
                PrecomputedTextCompat.getTextFuture(
                    notesModel.title,
                    binding.pinnedtitle.textMetricsParamsCompat,
                    null
                )
            )

            binding.pinneddescription.text = notesModel.note

            binding.executePendingBindings()


        }

    }

}