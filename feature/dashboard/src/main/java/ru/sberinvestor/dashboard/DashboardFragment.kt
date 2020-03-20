package ru.sberinvestor.dashboard


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ru.sberinvestor.balance.BalanceFragment
import ru.sberinvestor.core.fragment.BaseFragment
import ru.sberinvestor.dashboard.databinding.FmtDashboardSberBinding
import ru.sberinvestor.market.MarketFragment
import ru.sberinvestor.news.NewsFragment
import ru.sberinvestor.profile.ProfileFragment


class DashboardFragment : BaseFragment() {

    private var _binding: FmtDashboardSberBinding? = null
    private val binding get() = _binding!!

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

}