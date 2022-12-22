package com.example.workingthread.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.workingthread.R
import com.example.workingthread.resources.MovieRepositoryMock
import com.example.workingthread.viewModel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment(R.layout.fragment_movie) {

    private lateinit var viewModel: MovieViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, MovieViewModel.MovieViewModelFactory(MovieRepositoryMock())).get(MovieViewModel::class.java)

        viewModel.movieLiveData.observe(viewLifecycleOwner, Observer { movies ->
            textViewFisrtMovie.text = movies[0].title
            textViewSecondMovie.text = movies[1].title
        })
        viewModel.getMovie()
    }
}