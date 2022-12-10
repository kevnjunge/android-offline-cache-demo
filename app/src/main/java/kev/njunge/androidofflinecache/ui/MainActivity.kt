package kev.njunge.androidofflinecache.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kev.njunge.androidofflinecache.databinding.ActivityMainBinding
import kev.njunge.androidofflinecache.ui.adapters.UniversityAdapter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel:UniversityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val universityAdapter = UniversityAdapter()

        binding.apply {
            recyclerView.apply {
                adapter = universityAdapter
                layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,true)
            }

            viewModel.universities.observe(this@MainActivity){ universities ->
                universityAdapter.submitList(universities)
            }
        }
    }
}