package com.example.wallet2.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ReceivedTranListViewModel(
    private val receivedTranRepository: ReceivedTranRepository
): ViewModel() {

}