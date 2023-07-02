package com.example.myhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.myhomework.databinding.FragmentListOfCapitalBinding

class ListOfCapitalFragment : Fragment(R.layout.fragment_list_of_capital) {
    private var binding: FragmentListOfCapitalBinding? = null
    private var adapter: CapitalAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListOfCapitalBinding.bind(view)
        initAdapter()
    }

    private fun initAdapter(){
        adapter = CapitalAdapter(
            list = CapitalRepository.list,
            glide = Glide.with(this)
        ) { capital ->
            findNavController().navigate(
                R.id.rvMoscow,
                ResultCapitalFragment.createBunle(capital.id)
            )
        }
        binding?.rvMoscow?.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}