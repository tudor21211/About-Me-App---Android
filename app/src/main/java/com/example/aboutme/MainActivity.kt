package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.aboutme.databinding.ActivityMainBinding
import androidx.databinding.DataBindingUtil

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var personName = MyName("Tudor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = personName

        //findViewById<Button>(R.id.done_button).setOnClickListener{
            //addNickname(findViewById<Button>(R.id.done_button))
        //}
        binding.doneButton.setOnClickListener{
            addNickname(binding.doneButton)
        }

    }

    private fun addNickname (view : View){
        val inputNickname = findViewById<EditText>(R.id.nickNameEdit)
        val outputNickname  = findViewById<TextView>(R.id.text_nickname)

        if (inputNickname.text != null) {
            binding.myName?.nickname=inputNickname.text.toString()
            inputNickname.visibility = View.GONE
            outputNickname.text = inputNickname.text
            outputNickname.visibility = View.VISIBLE
            view.visibility = View.GONE
        }

        //Hide keyboard
        val hide = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        hide.hideSoftInputFromWindow(view.windowToken,0)

    }

}