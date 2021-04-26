package com.example.mynotes2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes2.database.NoteEntity
import com.example.mynotes2.databinding.ItemNoteEntityBinding

class NotesListAdapter()
    : ListAdapter<NoteEntity, NotesListAdapter.NoteItemViewHolder>(NotesComparator()) {

    inner class NoteItemViewHolder(private val noteBinding :ItemNoteEntityBinding):
        RecyclerView.ViewHolder(noteBinding.root) {

        fun bind(item: NoteEntity) {
            with(noteBinding) {
                tvNote.text = item.note
                tvTime.text = item.time.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemNoteEntityBinding.inflate(layoutInflater, parent, false)
        return NoteItemViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class NotesComparator: DiffUtil.ItemCallback<NoteEntity>() {
        override fun areItemsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NoteEntity, newItem: NoteEntity): Boolean {
            return oldItem.importance == newItem.importance &&
                    oldItem.note == newItem.note &&
                    oldItem.time == newItem.time
        }

    }
}



