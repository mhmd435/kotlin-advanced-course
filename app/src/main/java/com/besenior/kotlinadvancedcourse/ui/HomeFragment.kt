package com.besenior.kotlinadvancedcourse.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.besenior.kotlinadvancedcourse.R
import com.besenior.kotlinadvancedcourse.adapters.CardClickListener
import com.besenior.kotlinadvancedcourse.adapters.PinnedRVAdapter
import com.besenior.kotlinadvancedcourse.adapters.UpcomingRvAdapter
import com.besenior.kotlinadvancedcourse.databinding.FragmentHomeBinding
import com.besenior.kotlinadvancedcourse.room.entities.NoteEntity
import com.besenior.kotlinadvancedcourse.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList

@AndroidEntryPoint
class HomeFragment : Fragment(),CardClickListener{

    private val viewModel: AppViewModel by viewModels()

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
        viewModel.liveData.observe(viewLifecycleOwner){ listData ->
            val data: ArrayList<NoteEntity> = ArrayList()
            listData.forEach{
                if (it.notesModel.pinned){
                    data.add(it)
                }
            }
            if (data.isEmpty())
                binding.pinnedCon.visibility = View.GONE
            else
                binding.pinnedCon.visibility = View.VISIBLE

            binding.pinnedRv.adapter = PinnedRVAdapter(data,this)
        }
    }

    private fun setupUpcomingRecyclerview() {
        viewModel.liveData.observe(viewLifecycleOwner){ listData ->

            val data: ArrayList<NoteEntity> = ArrayList()
            listData.forEach{
                if (!it.notesModel.pinned){
                    data.add(it)
                }
            }

            if (data.isEmpty())
                binding.textView3.visibility = View.VISIBLE
            else
                binding.textView3.visibility = View.GONE

            binding.upcomingRv.adapter = UpcomingRvAdapter(data,this)

        }
    }

    fun fabOnClick(view: View){
        view.findNavController().navigate(R.id.action_homeFragment_to_singleNoteFragment)
    }

    override fun onItemClickListener(noteEntity: NoteEntity) {
        val bundle = bundleOf("datamodel" to noteEntity)
        Navigation.findNavController(binding.root).navigate(R.id.action_homeFragment_to_singleNoteFragment,bundle)
    }
}