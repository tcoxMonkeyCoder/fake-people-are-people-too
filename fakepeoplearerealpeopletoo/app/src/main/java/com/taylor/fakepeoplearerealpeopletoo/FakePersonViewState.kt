package com.taylor.fakepeoplearerealpeopletoo

sealed class FakePersonViewState(val loading: Boolean, val person: Person?, val error: String?) {
    class Loading: FakePersonViewState(true, null, null)
    class FakePersonLoaded(person: Person): FakePersonViewState(false, person, null)
    class Error(message: String): FakePersonViewState(false, null, message)
}