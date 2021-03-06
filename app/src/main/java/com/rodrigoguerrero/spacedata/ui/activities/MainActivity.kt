package com.rodrigoguerrero.spacedata.ui.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rodrigoguerrero.spacedata.R
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.menu_sort_by_date -> {
            true
        }
        R.id.menu_sort_by_name -> {
            true
        }
        else -> super.onOptionsItemSelected(item)
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