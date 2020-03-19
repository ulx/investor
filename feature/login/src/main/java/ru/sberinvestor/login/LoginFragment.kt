package ru.sberinvestor.login


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ru.sberinvestor.core.fragment.BaseFragment
import ru.sberinvestor.login.databinding.FmtLoginSberBinding

class LoginFragment : BaseFragment() {

    private var _binding: FmtLoginSberBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FmtLoginSberBinding.inflate(inflater, container, false)
        return binding.root
    }

}
