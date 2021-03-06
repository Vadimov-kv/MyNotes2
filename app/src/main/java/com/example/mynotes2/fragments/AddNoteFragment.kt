package com.example.mynotes2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mynotes2.databinding.FragmentAddNoteBinding
import com.example.mynotes2.databinding.FragmentNoteEntityBinding


class AddNoteFragment : Fragment() {
    private var _binding: FragmentAddNoteBinding?= null
    private val binding get()= _binding!!

    private var noteString:String  =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAddNoteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}