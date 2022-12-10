package kev.njunge.androidofflinecache.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kev.njunge.androidofflinecache.data.University
import kev.njunge.androidofflinecache.network.UniversityApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UniversityViewModel @Inject constructor(
    api: UniversityApi
) : ViewModel() {
    private val universitiesLiveData = MutableLiveData<List<University>>()
    val universities: LiveData<List<University>> = universitiesLiveData

    init {
        viewModelScope.launch {
            val universities = api.getUniversity()
            delay(2000)
            universitiesLiveData.value = universities
        }
    }

}