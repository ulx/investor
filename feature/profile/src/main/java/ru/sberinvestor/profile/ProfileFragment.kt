package ru.sberinvestor.profile


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ru.sberinvestor.core.fragment.BaseFragment
import ru.sberinvestor.profile.databinding.FmtProfileBinding

class ProfileFragment : BaseFragment() {

    private var _binding: FmtProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FmtProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

}
