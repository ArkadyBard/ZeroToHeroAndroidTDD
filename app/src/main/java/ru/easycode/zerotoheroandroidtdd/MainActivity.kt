package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var linearLayout: LinearLayout

    private var isTextRemoved = true

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        isTextRemoved = savedInstanceState.getBoolean(TEXT_VISIBILITY)
        if (!isTextRemoved) linearLayout.removeView(textView)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayout = findViewById(R.id.rootLayout)
        textView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.removeButton)
        button.setOnClickListener {
            linearLayout.removeView(textView)
            isTextRemoved = false
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(TEXT_VISIBILITY, isTextRemoved)

    }

    companion object {
        const val TEXT_VISIBILITY = "title_visibility_tag"
    }
}