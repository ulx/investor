package ru.sberinvestor.login


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.stateViewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import ru.sberinvestor.balance.di.loginModule

import ru.sberinvestor.core.fragment.BaseFragment
import ru.sberinvestor.login.databinding.FmtLoginSberBinding

class LoginFragment : BaseFragment() {

    private var _binding: FmtLoginSberBinding? = null
    private val binding get() = _binding!!
    private val module = loginModule
    private val viewModel: LoginViewModel by stateViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(module)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FmtLoginSberBinding.inflate(inflater, container, false)

        binding.loginButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionToDashboard())
        }
        return binding.root
    }

    override fun onStop() {
        super.onStop()
        unloadKoinModules(module)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.count.observe(viewLifecycleOwner, Observer {
            binding.loginUnderConstructionTextView.text = it.toString()
        })
        val i = viewModel.count.value ?: -1
        viewModel.setCount( i + 1)
        viewModel.getIndex()
    }

}
