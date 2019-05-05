package com.teambrack.makasetechoice.maketable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.teambrack.makasetechoice.R
import com.teambrack.makasetechoice.databinding.FragmentMakeTableBinding
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_make_table.view.*
import javax.inject.Inject

class MakeTableFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MakeTableViewModel by lazy {
        ViewModelProviders.of(requireActivity(), viewModelFactory).get(MakeTableViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onLoad()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DataBindingUtil.inflate<FragmentMakeTableBinding>(
            inflater,
            R.layout.fragment_make_table,
            container,
            false
        ).also { binding ->
            binding.viewModel = viewModel
            binding.lifecycleOwner = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //adapterのインスタンス作成
        val makeTableAdapter = MakeTableAdapter(viewModel)
        //adapterのセットアップ
        setupMakeTableAdapter(view.member_list, makeTableAdapter)
    }

    private fun setupMakeTableAdapter(recyclerView: RecyclerView, adapter: MakeTableAdapter) {
        LinearLayoutManager(
            requireContext(),
            RecyclerView.VERTICAL,
            false
        ).also {
            recyclerView.layoutManager = it
            recyclerView.adapter = adapter
        }
    }


    companion object {
        val FRAGMENT_TAG = MakeTableFragment::class.java.simpleName

        fun newInstance() = MakeTableFragment()
    }
}