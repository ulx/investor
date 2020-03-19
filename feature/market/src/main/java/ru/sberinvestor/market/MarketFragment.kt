package ru.sberinvestor.market


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ru.sberinvestor.core.fragment.BaseFragment
import ru.sberinvestor.market.databinding.FmtMarketBinding

class MarketFragment : BaseFragment() {

    private var _binding: FmtMarketBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FmtMarketBinding.inflate(inflater, container, false)
        return binding.root
    }

}
