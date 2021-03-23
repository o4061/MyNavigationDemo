package com.userfaltakas.mynavigationdemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.userfaltakas.mynavigationdemo.data.Movie
import com.userfaltakas.mynavigationdemo.databinding.FragmentTopRatedMoviesBinding

class TopRatedMoviesFragment : Fragment() {

    private var _binding: FragmentTopRatedMoviesBinding? = null
    private val binding get() = _binding!!
    private var movie: Movie = Movie("TopRated", 10)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTopRatedMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickTopRatedBtn()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun clickTopRatedBtn() = binding.topRatedBtn.setOnClickListener {
        val action =
            TopRatedMoviesFragmentDirections.actionTopRatedMoviesFragmentToMovieDetailsFragment(
                movie
            )
        view?.let { it1 ->
            Navigation.findNavController(it1)
                .navigate(action)
        }
    }
}