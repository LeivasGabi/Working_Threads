package com.example.workingthread.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.workingthread.model.Movie
import com.example.workingthread.resources.MovieRepositoryMock

class MovieViewModel(private val repositoryMock: MovieRepositoryMock) : ViewModel() {

    var movieLiveData = MutableLiveData<List<Movie>>()

    fun getMovie(){
        repositoryMock.getMovie { movies ->
            movieLiveData.postValue(movies)
        }
    }

    class MovieViewModelFactory(private val repositoryMock: MovieRepositoryMock) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MovieViewModel(repositoryMock) as T
        }
    }
}