package com.besenior.kotlinadvancedcourse.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.besenior.kotlinadvancedcourse.R
import com.besenior.kotlinadvancedcourse.databinding.FragmentSingleNoteBinding
import com.besenior.kotlinadvancedcourse.models.NotesModel
import com.besenior.kotlinadvancedcourse.viewmodel.AppViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SingleNoteFragment : Fragment() {
    private lateinit var binding: FragmentSingleNoteBinding

    private var savedColor = "#64C8FD"

    private val viewModel:AppViewModel by viewModels()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_single_note, container, false)
        binding.singleNote = this
        // Inflate the layout for this fragment
        return binding.root
    }

    fun onAddNoteClick(view: View){
        binding.apply {
            if (this.titleEdtx.text.isNullOrBlank()){
                Snackbar.make(this.mainCoord, "Pls Enter Your Title...", Snackbar.LENGTH_SHORT).show()
            }else{
                if (this.noteEdtx.text.isNullOrBlank()){
                    Snackbar.make(this.mainCoord, "Pls Enter Your Note...", Snackbar.LENGTH_SHORT).show()
                }else{
                    val title = this.titleEdtx.text.toString()
                    val note = this.noteEdtx.text.toString()
                    val color = savedColor

                    val noteModel = NotesModel(title,note,color,false)
                    viewModel.insertNoteToDatabase(noteModel)


                    Navigation.findNavController(view).navigate(R.id.action_singleNoteFragment_to_homeFragment)

                }
            }
        }

    }

    fun onColorViewClick(check: View){

        hideAllCheck()

        check.visibility = View.VISIBLE

        binding.apply {
            when(check.id){
                this.check1.id -> savedColor = "#64C8FD"
                this.check2.id -> savedColor = "#8069FF"
                this.check3.id -> savedColor = "#FFCC36"
                this.check4.id -> savedColor = "#D77FFD"
                this.check5.id -> savedColor = "#FF419A"
                this.check6.id -> savedColor = "#7FFB76"
            }
        }

    }

    private fun hideAllCheck(){
        binding.apply {
            this.check1.visibility = View.INVISIBLE
            this.check2.visibility = View.INVISIBLE
            this.check3.visibility = View.INVISIBLE
            this.check4.visibility = View.INVISIBLE
            this.check5.visibility = View.INVISIBLE
            this.check6.visibility = View.INVISIBLE
        }
    }

}