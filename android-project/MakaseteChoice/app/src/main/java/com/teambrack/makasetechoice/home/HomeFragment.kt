package com.teambrack.makasetechoice.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.teambrack.makasetechoice.R
import com.teambrack.makasetechoice.databinding.FragmentHomeBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class HomeFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: HomeViewModel by lazy {
        ViewModelProviders.of(requireActivity(), viewModelFactory).get(HomeViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        ).also { binding ->
            binding.viewModel = viewModel
        }.root
    }

    companion object {
        val FRAGMENT_TAG = HomeFragment::class.java.simpleName

        fun newInstance() = HomeFragment()
    }
}