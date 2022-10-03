package com.boltuix.androidpreferences

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.boltuix.androidpreferences.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    private var _binding: Fragment1Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = Fragment1Binding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun create(): Fragment1 {
            return Fragment1()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
