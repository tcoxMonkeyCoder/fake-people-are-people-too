package com.taylor.fakepeoplearerealpeopletoo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val lifecycle = "lifecycle"
    var count = 0
    val COUNT_KEY = "count"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        count = savedInstanceState?.getInt(COUNT_KEY, 0) ?: 0
        count_txt.text = count.toString()

        count_btn.setOnClickListener { _ ->
            count_txt.text = (++count).toString()
        }

        go_to_person_generater.setOnClickListener {
            val intent = Intent(this, GeneratePersonActivity::class.java)

            startActivity(intent)
        }

        Log.i(lifecycle, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i(lifecycle, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(lifecycle, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(lifecycle, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(lifecycle, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(lifecycle, "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(COUNT_KEY, count)
    }
}
