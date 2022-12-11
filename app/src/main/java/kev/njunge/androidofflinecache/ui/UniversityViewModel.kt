package kev.njunge.androidofflinecache.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kev.njunge.androidofflinecache.data.UniversityRepository
import javax.inject.Inject

@HiltViewModel
class UniversityViewModel @Inject constructor(
    repository: UniversityRepository
) : ViewModel() {

    val universities = repository.getUniversities().asLiveData()
}