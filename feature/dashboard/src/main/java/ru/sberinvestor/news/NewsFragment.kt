package ru.sberinvestor.news


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ru.sberinvestor.core.fragment.BaseFragment
import ru.sberinvestor.dashboard.databinding.FmtNewsBinding


class NewsFragment : BaseFragment() {

    private var _binding: FmtNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FmtNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

}
