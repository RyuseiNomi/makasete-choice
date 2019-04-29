package com.teambrack.makasetechoice.makegroup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.teambrack.makasetechoice.R
import com.teambrack.makasetechoice.databinding.FragmentMakeGroupBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MakeGroupFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MakeGroupViewModel by lazy {
        ViewModelProviders.of(requireActivity(), viewModelFactory).get(MakeGroupViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DataBindingUtil.inflate<FragmentMakeGroupBinding>(
            inflater,
            R.layout.fragment_make_group,
            container,
            false
        ).also { binding ->
            binding.viewModel = viewModel
            binding.lifecycleOwner = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        val FRAGMENT_TAG = MakeGroupFragment::class.java.simpleName

        fun newInstance() = MakeGroupFragment()
    }
}