package com.cs191014.assignment1.ui.home

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cs191014.assignment1.ui.home.Record


class RecordsModel : ViewModel() {
    private val recordsList: MutableLiveData<ArrayList<Record>> =
        MutableLiveData<ArrayList<Record>>()
    val records: LiveData<ArrayList<Record>>
        get() = recordsList

    fun initializeRecords(records: ArrayList<Record>) {
//        recordsList.value = Record.createRecordList(10)
        recordsList.value = records;
    }

    fun addRecord(newRecord: Record, context: Context) {
        var tempList = recordsList.value
        tempList?.add(newRecord)
        recordsList.value = tempList ?: ArrayList()
        val db = RecordDatabase.getInstance(context.applicationContext)
        db.recordDao().insertAll(newRecord)
    }
}
