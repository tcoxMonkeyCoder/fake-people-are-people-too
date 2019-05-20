package com.taylor.fakepeoplearerealpeopletoo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FakePersonGeneratorViewModel(val repository: FakePersonRepository): ViewModel() {

    private val currentState: MutableLiveData<FakePersonViewState> = MutableLiveData()
    val state: LiveData<FakePersonViewState> = currentState

    fun generateFakePerson() = GlobalScope.launch {
        currentState.postValue(FakePersonViewState.Loading())
        try {
            val person = repository.getFakePersonDetails()
            if(person != null)
                currentState.postValue(FakePersonViewState.FakePersonLoaded(person))
            else
                currentState.postValue(FakePersonViewState.Error("Sorry, we couldn't find any fake people right now."))
        } catch(e: Exception) {
            currentState.postValue(FakePersonViewState.Error("Sorry, we couldn't find any fake people right now."))
        }
    }
}