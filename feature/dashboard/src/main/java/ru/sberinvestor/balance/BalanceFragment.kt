package ru.sberinvestor.balance


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import ru.sberinvestor.core.fragment.BaseFragment
import ru.sberinvestor.dashboard.databinding.FmtBalanceBinding

class BalanceFragment : BaseFragment() {

    private var _binding: FmtBalanceBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FmtBalanceBinding.inflate(inflater, container, false)
        return binding.root
    }

}
