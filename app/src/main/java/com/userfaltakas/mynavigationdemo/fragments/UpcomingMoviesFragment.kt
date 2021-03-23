package com.userfaltakas.mynavigationdemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.userfaltakas.mynavigationdemo.data.Movie
import com.userfaltakas.mynavigationdemo.databinding.FragmentUpcomingMoviesBinding

class UpcomingMoviesFragment : Fragment() {

    private var _binding: FragmentUpcomingMoviesBinding? = null
    private val binding get() = _binding!!
    private var movie: Movie = Movie("Upcoming", 10)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUpcomingMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickUpcomingBtn()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun clickUpcomingBtn() = binding.upcomingBtn.setOnClickListener {
        val action =
            UpcomingMoviesFragmentDirections.actionUpcomingMoviesFragmentToMovieDetailsFragment(
                movie
            )
        view?.let { it1 ->
            Navigation.findNavController(it1)
                .navigate(action)
        }
    }
}