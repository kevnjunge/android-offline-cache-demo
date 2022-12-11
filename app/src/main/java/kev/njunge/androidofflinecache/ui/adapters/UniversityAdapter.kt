package kev.njunge.androidofflinecache.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kev.njunge.androidofflinecache.data.University
import kev.njunge.androidofflinecache.databinding.UniversityItemBinding

class UniversityAdapter :
    ListAdapter<University, UniversityAdapter.UniversityViewHolder>(UniversityComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder {
        val binding =
            UniversityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UniversityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    class UniversityViewHolder(private val binding: UniversityItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(university: University) {
            binding.apply {
                tvUniversityName.text = university.name
                tvUniversityCountry.text = university.country

            }
        }
    }

    class UniversityComparator : DiffUtil.ItemCallback<University>() {
        override fun areItemsTheSame(oldItem: University, newItem: University) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: University, newItem: University) =
            oldItem == newItem
    }

}