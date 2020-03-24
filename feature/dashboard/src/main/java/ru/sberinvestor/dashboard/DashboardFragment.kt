package ru.sberinvestor.dashboard


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.stateViewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import ru.sberinvestor.balance.BalanceFragment
import ru.sberinvestor.core.fragment.BaseFragment
import ru.sberinvestor.dashboard.databinding.FmtDashboardSberBinding
import ru.sberinvestor.dashboard.di.dashboardModule
import ru.sberinvestor.market.MarketFragment
import ru.sberinvestor.news.NewsFragment
import ru.sberinvestor.profile.ProfileFragment


class DashboardFragment : BaseFragment() {

    private var _binding: FmtDashboardSberBinding? = null
    private val binding get() = _binding!!
    private val module = dashboardModule
    private val viewModel: DashboardViewModel by stateViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(module)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FmtDashboardSberBinding.inflate(inflater, container, false)
        binding.buttonLogin.setOnClickListener {
            findNavController().navigate(DashboardFragmentDirections.actionToLogin())
        }

        binding.buttonBalance.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, BalanceFragment())
                .commit()
        }

        binding.buttonMarket.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, MarketFragment())
                .commit()
        }

        binding.buttonNews.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, NewsFragment())
                .commit()
        }

        binding.buttonProfile.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, ProfileFragment())
                .commit()
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
            binding.underConstructionTextView.text = it.toString()
        })
        val i = viewModel.count.value ?: -1
        viewModel.setCount( i + 1)
        viewModel.getIndex()
    }

}