package ru.sberinvestor.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.Dispatchers.IO

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.sberbank.network.entity.Dictionaries
import ru.sberinvestor.core.state.CodeState
import ru.sberinvestor.core.state.InvestorResult

class DashboardViewModel(private val handle: SavedStateHandle, private val interactor: DashboardInteractor) : ViewModel() {

    private lateinit var countCollect: Flow<InvestorResult<Int>>
    private lateinit var dictionaryCollect: Flow<InvestorResult<Dictionaries>>
    private val countKey = "count_key"
    private val dataKey = "data_key"
    private val _count = handle.getLiveData(countKey, -1)
    val count: LiveData<Int>
        get() = _count

    fun setCount(index: Int) {
        handle.set(countKey, index)
        viewModelScope.launch(IO) {
            dictionaryCollect = interactor.getDictionaries()

            dictionaryCollect.collect { res ->
                when (res) {
                    is InvestorResult.Success -> {
                        Log.i("DashboardViewModel", "value = ${res.data}")
                        _count.postValue(res.data.resp.companies.size)
                        dictionaryCollect.collect()
                    }
                    is InvestorResult.Error -> {
                        showError(res.code)
                        dictionaryCollect.collect()
                    }
                    is InvestorResult.Loading -> {
                        _count.postValue(-999)
//                        if (res.data.resp.instruments.isNotEmpty()) {
//                            handle.set(dataKey, res.data)
//                        }
                    }
                }
            }
        }
    }

    private fun showError(code: CodeState) {
        Log.w("DashboardViewModel", "errorCode = ${code.code}")
    }

    fun getIndex(): Int {
        return handle.get<Int>(countKey) ?: -1
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.launch {
            countCollect.collect()
        }
    }

    /**
     *     fun setCount(index : Int) {
    handle.set(countKey, index)
    viewModelScope.launch {
    when(val res = interactor.getDictionaries()){
    is InvestorResult.Success -> {
    Log.i("DashboardViewModel", "value = ${res.data}")
    _count.postValue(res.data.resp.companies.size)
    countCollect = interactor.getDictionaries2()
    countCollect.collect { action ->
    if (action is InvestorResult.Success){
    _count.postValue(action.data)
    countCollect.collect()
    }
    if (action is InvestorResult.Loading) {
    _count.postValue(action.data)
    }
    }
    }
    is InvestorResult.Error -> showError(res.code)
    is InvestorResult.Loading -> {if (res.data.resp.instruments.isNotEmpty()) {
    handle.set(dataKey, res.data)
    }}
    }
    }
    }

     */

}