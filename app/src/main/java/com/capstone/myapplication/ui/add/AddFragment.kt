package com.capstone.myapplication.ui.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.capstone.myapplication.R

/**
 * A simple [Fragment] subclass.
 * Use the [AddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragment : Fragment() {
    private lateinit var addViewModel: AddViewModel
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ):View? {
        addViewModel = ViewModelProvider(this).get(AddViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_add,container,false)
        return root
    }
}