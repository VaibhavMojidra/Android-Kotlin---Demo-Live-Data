package com.vaibhavmojidra.livedatademokotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingValue:Int) : ViewModel() {
    private var count= MutableLiveData<Int>()
    val totalCount:LiveData<Int> get()=count;
    init{
        count.value=startingValue
    }

    fun getUpdateCount(value:Int): Int? {
        count.value=(count.value)?.plus(value)
        return count.value
    }
}