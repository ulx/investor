package ru.sberinvestor.balance


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.stateViewModel
import org.koin.core.context.loadKoinModules
import ru.sberinvestor.balance.di.balanceModule


import ru.sberinvestor.core.fragment.BaseFragment
import ru.sberinvestor.dashboard.databinding.FmtBalanceBinding

class BalanceFragment : BaseFragment() {

    private var _binding: FmtBalanceBinding? = null
    private val binding get() = _binding!!
    private val module = balanceModule
    private val viewModel: BalanceViewModel by stateViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(module)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FmtBalanceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        //unloadKoinModules(module)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.count.observe(viewLifecycleOwner, Observer {
            binding.underConstructionTextView.text = it.toString()
        })
        val i = viewModel.count.value ?: -1
        viewModel.setCount( i + 1)
        viewModel.getIndex()
    }

}
