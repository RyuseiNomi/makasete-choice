package com.teambrack.makasetechoice.makegroup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.teambrack.makasetechoice.R
import com.teambrack.makasetechoice.databinding.ActivityMakeGroupBinding
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_make_group.view.*
import javax.inject.Inject

class MakeGroupActivity : DaggerAppCompatActivity(){
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MakeGroupViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MakeGroupViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onLoad()
        DataBindingUtil.setContentView<ActivityMakeGroupBinding>(this, R.layout.activity_make_group).also{ binding ->
            binding.viewModel = viewModel
            binding.lifecycleOwner = this
            binding.root.member_list.adapter = ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                viewModel.members.value?.map { it.name }?.toList() ?: emptyList()
            )

            //adapterのインスタンス作成
            val memberGroupAdapter = MemberGroupAdapter(viewModel)
            //adapterのセットアップ
            setupMakeGroupAdapter(binding.root.group_table, memberGroupAdapter)
        }
    }

    private fun setupMakeGroupAdapter(recyclerView: RecyclerView, adapter: MemberGroupAdapter) {
        LinearLayoutManager(
            this,
            RecyclerView.VERTICAL,
            false
        ).also {
            recyclerView.layoutManager = it
            recyclerView.adapter = adapter
        }
    }

    companion object {
        private fun createIntent(context: Context): Intent {
            return Intent(context, MakeGroupActivity::class.java)
        }

        fun startActivity(context: Context) {
            val intent = createIntent(context)
            context.startActivity(intent)
        }
    }
}