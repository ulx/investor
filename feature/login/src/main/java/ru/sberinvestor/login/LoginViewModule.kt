package ru.sberinvestor.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class LoginViewModule(private val handle: SavedStateHandle) : ViewModel(){

    private val countKey = "count_key"
    private val _count = handle.getLiveData(countKey, -1)
    val count : LiveData<Int>
       get() = _count

    fun setCount(index : Int) {
        handle.set(countKey, index)
    }

    fun getIndex() : Int {
        return handle.get<Int>(countKey) ?: - 1
    }

    override fun onCleared() {
        super.onCleared()
    }

}