package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var button: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.changeButton)
        button.setOnClickListener {
            textView.text = "I am an Android Developer!"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("JUNIT test", "save text state in textview")
        outState.putString("TITLE_TAG", "I am an Android Developer!")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("JUNIT test", "restore text state in textview")
        val text = savedInstanceState.getString("TITLE_TAG")
        textView.text = text
    }
}