package com.boltuix.androidpreferences

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.boltuix.androidpreferences.databinding.TabLayoutBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutDemo : Fragment() {

    private var _binding: TabLayoutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = TabLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // val root= inflater.inflate(R.layout.tab_layout, container, false)

        //renderViewPager
        binding.viewpager.adapter = object : FragmentStateAdapter(this) {

            override fun createFragment(position: Int): Fragment {
                return ResourceStore.pagerFragments[position]
            }

            override fun getItemCount(): Int {
                return ResourceStore.tabList.size
            }
        }

        //renderTabLayer
        TabLayoutMediator(binding.tabs, binding.viewpager) { tab, position ->
            tab.text = getString(ResourceStore.tabList[position])
        }.attach()

    }

}

interface ResourceStore {
    companion object {
        val tabList = listOf(
            R.string.tab1, R.string.tab2, R.string.tab3
        )
        val pagerFragments = listOf(
            Fragment1.create(), Fragment2.create(),
            Fragment3.create())
    }
}