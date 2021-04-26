package com.example.mynotes2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.mynotes2.fragments.RecycleViewFragmentDirections
import com.example.mynotes2.databinding.FragmentRecycleViewBinding

class RecycleViewFragment : Fragment() {

    private var _binding: FragmentRecycleViewBinding?= null
    private val binding get()= _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecycleViewBinding.inflate(inflater,container,false)

        binding.btnAdd.setOnClickListener(){
            it.findNavController().navigate(RecycleViewFragmentDirections.actionRecycleViewFragmentToAddNoteFragment())
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}