package com.bugreproduction.geftimov

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GeftimovViewModel: ViewModel(){
    val changePageEvent = MutableLiveData<Int>()
    val swipeControlEvent = MutableLiveData<Boolean>()
    val touchEndEventForPage = MutableLiveData<Int>()

    private var maxPage: Int = 0

    fun initVM(maxPage: Int, indexMain: Int){
        this.maxPage = maxPage
        changePageEvent.postValue(indexMain)
        swipeControlEvent.postValue(true)
        touchEndEventForPage.postValue(-1)
    }

    fun getMaxPage():Int = maxPage

    fun toPage(index: Int){
        changePageEvent.postValue(index)
    }

    fun enableDisableSwipe(enableDisable: Boolean){
        swipeControlEvent.postValue(enableDisable)
    }
}