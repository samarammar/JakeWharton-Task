package com.jakewharton.repos.presentation.reposlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jakewharton.repos.R
import com.jakewharton.repos.data.database.model.RepoEntity
import com.jakewharton.repos.data.model.RepoReponce
import com.jakewharton.repos.databinding.ActivityReposListBinding
import com.jakewharton.repos.presentation.base.BaseActivity
import com.jakewharton.repos.presentation.reposlist.adapter.ReposAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import timber.log.Timber


@AndroidEntryPoint
class ReposListActivity :  BaseActivity<ActivityReposListBinding>()
{
    override val bindLayout: (LayoutInflater) -> ActivityReposListBinding
        get() = ActivityReposListBinding::inflate

    private lateinit var viewModel: ReposListViewModel
    private lateinit var adaptercompet: ReposAdapter
    private fun initUi() {
        binding.rvRepos.run {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = adaptercompet
        }
    }

    private fun onListItemClick(repo: RepoEntity) {
//        val intent = Intent(
//            this,
//            R::class.java
//        )
//
//        intent.putExtra(PRODUCTS_OBJ, product)
//        startActivity(intent)
    }


    override fun prepareView() {
        viewModel = ViewModelProvider(this).get(ReposListViewModel::class.java)
        viewModel.getReposList()
        adaptercompet = ReposAdapter(this){ code -> onListItemClick(code) }


        initUi()
        fetchCompetitions()
    }

    private fun fetchCompetitions() {

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect { state ->
                    when (state) {
                        is ReposListViewModel.ReposUiState.Loaded -> onLoaded(state.itemState)

                        is ReposListViewModel.ReposUiState.Error -> showError(state.message)
                        is ReposListViewModel.ReposUiState.Loading -> showLoading()
                    }
                }
            }
        }
    }

    private suspend fun onLoaded(reposListUiState: ReposListUiState) {
        Timber.d("showerror")

        reposListUiState.run {
            val flowOfLists: Flow<List<RepoEntity>> = repos
            val flatList: List<RepoEntity> = flowOfLists.flattenToList()
            adaptercompet.update(flatList)


        }
    }



    suspend fun <T> Flow<List<T>>.flattenToList() =
        flatMapConcat { it.asFlow() }.toList()

    private fun showLoading() {
        Timber.d("showLoading")
    }

    private fun showError(@StringRes stringRes: Int) {

        Toast.makeText(baseContext, stringRes, Toast.LENGTH_SHORT).show()
    }


}