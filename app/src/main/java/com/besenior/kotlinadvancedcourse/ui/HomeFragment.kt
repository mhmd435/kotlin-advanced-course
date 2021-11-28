package com.besenior.kotlinadvancedcourse.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.besenior.kotlinadvancedcourse.R
import com.besenior.kotlinadvancedcourse.adapters.PinnedRVAdapter
import com.besenior.kotlinadvancedcourse.adapters.UpcomingRvAdapter
import com.besenior.kotlinadvancedcourse.databinding.FragmentHomeBinding
import com.besenior.kotlinadvancedcourse.models.NotesModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        binding.fragmentHome = this

        setupPinnedRecyclerview()
        setupUpcomingRecyclerview()


        // Inflate the layout for this fragment
        return binding.root
    }

    private fun setupPinnedRecyclerview() {
//        val data:ArrayList<NotesModel> = ArrayList()
//        data.add(NotesModel("note 1","this is note1"))
//        data.add(NotesModel("note 2","this is note2"))
//        data.add(NotesModel("note 3","this is note3"))
//
//        if (data.isEmpty())
//            binding.pinnedCon.visibility = View.GONE
//        else
//            binding.pinnedCon.visibility = View.VISIBLE
//
//        binding.pinnedRv.adapter = PinnedRVAdapter(data)


    }

    private fun setupUpcomingRecyclerview() {
//        val data:ArrayList<NotesModel> = ArrayList()
//        data.add(NotesModel("note 1","this is note1"))
//        data.add(NotesModel("note 2","this is note2"))
//        data.add(NotesModel("note 3","this is note3"))
//
//        binding.upcomingRv.adapter = UpcomingRvAdapter(data)
//

    }

    fun fabOnClick(view: View){
        view.findNavController().navigate(R.id.action_homeFragment_to_singleNoteFragment)
    }
}