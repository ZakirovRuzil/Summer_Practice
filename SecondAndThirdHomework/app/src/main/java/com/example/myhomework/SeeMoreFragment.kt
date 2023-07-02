package com.example.myhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.myhomework.databinding.FragmentSeeMoreBinding

class SeeMoreFragment : Fragment(R.layout.fragment_see_more) {
    private var binding: FragmentSeeMoreBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSeeMoreBinding.bind(view)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}