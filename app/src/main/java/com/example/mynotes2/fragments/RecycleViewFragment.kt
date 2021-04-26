package com.example.mynotes2.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynotes2.NoteViewModel
import com.example.mynotes2.NoteViewModelFactory
import com.example.mynotes2.NotesApplication
import com.example.mynotes2.NotesListAdapter
import com.example.mynotes2.databinding.FragmentRecycleViewBinding

class RecycleViewFragment() : Fragment() {

    private var _binding: FragmentRecycleViewBinding?= null
    private val binding get()= _binding!!

    private lateinit var notesListAdapter: NotesListAdapter
    private lateinit var fragContext: Context

    private val notesViewModel: NoteViewModel by viewModels {
        NoteViewModelFactory((fragContext.applicationContext as NotesApplication).repository)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragContext = context
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

        notesListAdapter = NotesListAdapter()
        binding.rvNotes.adapter = notesListAdapter
        binding.rvNotes.layoutManager = LinearLayoutManager(fragContext)

        notesViewModel.allWords.observe(
            viewLifecycleOwner,
            Observer { notes ->
                notes?.let { notesList ->
                    notesListAdapter.submitList(notesList)
                }
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}