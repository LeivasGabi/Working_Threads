package com.example.workingthread.resources

import com.example.workingthread.model.Movie
import javax.security.auth.callback.Callback

class MovieRepositoryMock {

    fun getMovie(callback: (movies : List<Movie>) -> Unit)  {
        Thread(Runnable {
            Thread.sleep(1000)
            callback.invoke(
                listOf(
                    Movie(id = 0,"Shrek"),
                    Movie(id = 1, "Shrek 2")
                )
            )
        }).start()
    }
}