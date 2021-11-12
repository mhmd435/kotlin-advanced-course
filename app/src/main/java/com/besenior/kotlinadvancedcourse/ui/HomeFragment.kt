package com.besenior.kotlinadvancedcourse.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.besenior.kotlinadvancedcourse.R
import com.besenior.kotlinadvancedcourse.adapters.PinnedRVAdapter
import com.besenior.kotlinadvancedcourse.databinding.FragmentHomeBinding
import com.besenior.kotlinadvancedcourse.models.NotesModel
import java.util.ArrayList

class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)

        setupPinnedRecyclerview()


        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setupPinnedRecyclerview() {
        val data:ArrayList<NotesModel> = ArrayList()
        data.add(NotesModel("note 1","this is note1"))
        data.add(NotesModel("note 2","this is note2"))
        data.add(NotesModel("note 3","this is note3"))

        if (data.isEmpty())
            binding.pinnedCon.visibility = View.GONE
        else
            binding.pinnedCon.visibility = View.VISIBLE

        binding.pinnedRv.adapter = PinnedRVAdapter(data)


    }
}