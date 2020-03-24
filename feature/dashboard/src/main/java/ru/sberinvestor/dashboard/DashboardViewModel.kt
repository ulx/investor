package ru.sberinvestor.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.sberinvestor.core.state.CodeState
import ru.sberinvestor.core.state.InvestorResult

class DashboardViewModel(private val handle: SavedStateHandle, private val interactor: DashboardInteractor) : ViewModel(){

    private val countKey = "count_key"
    private val dataKey = "data_key"
    private val _count = handle.getLiveData(countKey, -1)
    val count : LiveData<Int>
       get() = _count

    fun setCount(index : Int) {
        handle.set(countKey, index)
        viewModelScope.launch {
           when(val res = interactor.getDictionaries()){
                is InvestorResult.Success -> Log.i("DashboardViewModel", "value = ${res.data}")
                is InvestorResult.Error -> showError(res.code)
                is InvestorResult.Loading -> {if (res.data.resp.instruments.isNotEmpty()) {
                    handle.set(dataKey, res.data)
                }}
            }
        }
    }

    private fun showError(code: CodeState) {
        Log.w("DashboardViewModel", "errorCode = ${code.code}")
    }

    fun getIndex() : Int {
        return handle.get<Int>(countKey) ?: - 1
    }

    override fun onCleared() {
        super.onCleared()
    }

}