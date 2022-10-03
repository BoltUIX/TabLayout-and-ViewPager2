package com.boltuix.androidpreferences

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.boltuix.androidpreferences.databinding.Fragment1Binding
import com.boltuix.androidpreferences.databinding.Fragment2Binding

class Fragment3 : Fragment() {
    private var _binding: Fragment2Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = Fragment2Binding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        fun create(): Fragment3 {
            return Fragment3()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
