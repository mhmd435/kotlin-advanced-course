package com.besenior.kotlinadvancedcourse.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.besenior.kotlinadvancedcourse.R
import com.besenior.kotlinadvancedcourse.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)

        binding.textView2.text = "home"
        // Inflate the layout for this fragment
        return binding.root
    }
}