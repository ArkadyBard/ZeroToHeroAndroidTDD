package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

private const val LOG = "TEST_LOG"
private const val SAVE_STATE = "SAVE_STATE"

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var button: Button
    private var textViewIsVisible = true

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(LOG, "onRestoreInstance called")
        textViewIsVisible = savedInstanceState.getBoolean(SAVE_STATE)
        if (textViewIsVisible) {
            textView.visibility = View.VISIBLE
        } else {
            textView.visibility = View.INVISIBLE
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.hideButton)

        button.setOnClickListener {
            textView.visibility = View.INVISIBLE
            textViewIsVisible = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(LOG, "onSaveInstance called")
        outState.putBoolean(SAVE_STATE, textViewIsVisible)
    }
}