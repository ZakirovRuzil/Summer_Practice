package com.example.myhomework

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.bumptech.glide.Glide
import com.example.myhomework.databinding.FragmentResultCapitalBinding

class ResultCapitalFragment : Fragment(R.layout.fragment_result_capital) {
    private var binding: FragmentResultCapitalBinding? = null
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentResultCapitalBinding.bind(view)

        var objId = arguments?.getInt(ARG_ID_CAPITAL)
        var allCapital = CapitalRepository.getAllCapital()
        var singleCapital = allCapital.firstOrNull{it -> it.id == objId}

        binding?.run {
            textCapitalName.text = "Name: ${singleCapital?.name} | Id: ${singleCapital?.id}"

            Glide
                .with(fragmentResult)
                .load(singleCapital?.url)
                .into(imageCapital)

            descriptionCapital.text = singleCapital?.description
        }


    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object{
        private const val ARG_ID_CAPITAL = "ARG_CAPITAL_ID"

        fun createBunle(id:Int) : Bundle{
            var bundle = Bundle()
            bundle.putInt(ARG_ID_CAPITAL,id)
            return bundle
        }
    }
}