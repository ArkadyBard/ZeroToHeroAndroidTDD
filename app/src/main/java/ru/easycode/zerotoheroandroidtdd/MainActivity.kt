package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val linearLayout = LinearLayout(this)
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.id = R.id.rootLayout

        textView = TextView(this)
        textView.id = R.id.titleTextView
        textView.text = "Hello World!"
        linearLayout.addView(textView)

        button = Button(this)
        button.id = R.id.changeButton
        button.text = "change"
        linearLayout.addView(button)

        setContentView(linearLayout)

        button.setOnClickListener {
            textView.text = "I am an Android Developer!"
        }

    }
}