package com.taylor.fakepeoplearerealpeopletoo

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FakePersonGeneratorViewModel(FakePersonRepository()) as T
    }
}