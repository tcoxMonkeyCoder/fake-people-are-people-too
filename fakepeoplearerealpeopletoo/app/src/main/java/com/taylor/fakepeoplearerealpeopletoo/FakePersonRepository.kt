package com.taylor.fakepeoplearerealpeopletoo

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.delay
import java.io.BufferedReader
import java.io.InputStreamReader

class FakePersonRepository {
    private var people: List<Person>? = null

    suspend fun getFakePersonDetails(): Person? {
        if(people == null)
            people = getPeopleFromJson()
        delay(2000)
        val fakeAnError = (1..4).random().rem(4) == 1
        return if(fakeAnError) null else people?.random()
    }

    private fun getPeopleFromJson(): List<Person>? {
        val gson = Gson()
        val type = object : TypeToken<List<Person>>(){}.type
        val inputStream = App.instance.applicationContext.resources.openRawResource(R.raw.convertcsv)
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        people = gson.fromJson(bufferedReader, type)
        return people
    }
}