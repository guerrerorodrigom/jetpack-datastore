package com.rodrigoguerrero.spacedata.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rodrigoguerrero.spacedata.databinding.ActivityMainBinding
import com.rodrigoguerrero.spacedata.ui.adapters.MissionsAdapter
import com.rodrigoguerrero.spacedata.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var missionsAdapter: MissionsAdapter
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        startObserving()
        initViews()

        viewModel.getSpaceMissions()
    }

    private fun initViews() {
        with(binding.missionsRecyclerView) {
            val manager = LinearLayoutManager(this@MainActivity)
            layoutManager = manager
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity,
                    DividerItemDecoration.HORIZONTAL
                )
            )
            adapter = missionsAdapter
        }
    }

    private fun startObserving() {
        viewModel.spaceMissions.observe(this) { missions ->
            missionsAdapter.addItems(missions)
        }
    }
}