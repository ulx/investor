package ru.sberinvestor.dashboard


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ru.sberinvestor.core.fragment.BaseFragment
import ru.sberinvestor.dashboard.databinding.FmtDashboardSberBinding


class DashboardFragment : BaseFragment() {

    private var _binding: FmtDashboardSberBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FmtDashboardSberBinding.inflate(inflater, container, false)
        return binding.root
    }

}
