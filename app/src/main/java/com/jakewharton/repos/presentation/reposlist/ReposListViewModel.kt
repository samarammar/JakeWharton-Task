package com.jakewharton.repos.presentation.reposlist

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jakewharton.repos.data.networking.CoroutineDispatcherProvider
import com.jakewharton.repos.domain.usecase.RepoUsecase
import com.jakewharton.repos.util.ExceptionParser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ReposListViewModel   @Inject
constructor(
    private val repoUsecase: RepoUsecase,
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider
) : ViewModel() {

    private val _uiState = MutableStateFlow<ReposUiState>(ReposUiState.Loading)
    val uiState: StateFlow<ReposUiState> = _uiState

    fun getReposList() {
        _uiState.value = ReposUiState.Loading

        viewModelScope.launch(coroutineDispatcherProvider.IO()) {
            try {

                val result = repoUsecase.execute()

                _uiState.value = ReposUiState.Loaded(ReposListUiState(result))
            } catch (error: Exception) {
                _uiState.value = ReposUiState.Error(ExceptionParser.getMessage(error))
            }
        }
    }


    sealed class ReposUiState {
        object Loading : ReposUiState()
        class Loaded(val itemState: ReposListUiState) : ReposUiState()
        class Error(@StringRes val message: Int) : ReposUiState()
    }


}