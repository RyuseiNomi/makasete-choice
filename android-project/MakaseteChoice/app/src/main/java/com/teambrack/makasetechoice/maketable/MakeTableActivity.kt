package com.teambrack.makasetechoice.maketable

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.teambrack.makasetechoice.R
import com.teambrack.makasetechoice.databinding.ActivityMakeTableBinding
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_make_table.view.*
import javax.inject.Inject

class MakeTableActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: MakeTableViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MakeTableViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.onLoad()
        DataBindingUtil.setContentView<ActivityMakeTableBinding>(this, R.layout.activity_make_table).also { binding ->
            binding.viewModel = viewModel
            binding.lifecycleOwner = this

            //adapterのインスタンス作成
            val makeTableAdapter = MakeTableAdapter(viewModel)
            //adapterのセットアップ
            setupMakeTableAdapter(binding.root.member_list, makeTableAdapter)
        }
    }

    private fun setupMakeTableAdapter(recyclerView: RecyclerView, adapter: MakeTableAdapter) {
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
            return Intent(context, MakeTableActivity::class.java)
        }

        fun startActivity(context: Context) {
            val intent = createIntent(context)
            context.startActivity(intent)
        }
    }
}