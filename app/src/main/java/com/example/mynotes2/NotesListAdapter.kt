package com.example.mynotes2

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes2.databinding.FragmentNoteEntityBinding

class NotesListAdapter(private val noteViewModel:NoteViewModel)
    :RecyclerView.Adapter<NotesListAdapter.NoteItemViewHolder>() {



    inner class NoteItemViewHolder(private val noteBinding:FragmentNoteEntityBinding):
        RecyclerView.ViewHolder(noteBinding.root){

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}



