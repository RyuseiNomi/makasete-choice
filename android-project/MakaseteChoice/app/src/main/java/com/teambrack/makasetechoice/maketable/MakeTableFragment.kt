package com.teambrack.makasetechoice.maketable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.teambrack.makasetechoice.R
import com.teambrack.makasetechoice.databinding.FragmentMakeTableBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MakeTableFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MakeTableViewModel by lazy {
        ViewModelProviders.of(requireActivity(), viewModelFactory).get(MakeTableViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DataBindingUtil.inflate<FragmentMakeTableBinding>(
            inflater,
            R.layout.fragment_make_table,
            container,
            false
        ).also { binding ->
            binding.viewModel = viewModel
        }.root
    }

    companion object {
        val FRAGMENT_TAG = MakeTableFragment::class.java.simpleName

        fun newInstance() = MakeTableFragment()
    }
}