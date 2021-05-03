package com.example.myapplycationcipher

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplycationcipher.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass: ActivityMainBinding
    private var selected = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        Log.d("MainAct_Log", "OnCreate")

        selected = bindingClass.spinner.selectedItem.toString()

    }


    fun onClickEncrypt(view: View) {
        when (selected) {
            "Цезаря" -> {
                //сразу работаю с калссом Cezar не создовая его объект
                bindingClass.encrDecryTV.text = Cezar().crypt(1,
                        bindingClass.inputText.text.toString(),
                        bindingClass.inputKey.text.toString())[0]
            }
        }
    }


    override fun onStart() {
        super.onStart()
        Log.d("MainAct_Log", "onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d("MainAct_Log", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainAct_Log", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainAct_Log", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainAct_Log", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainAct_Log", "onDestroy")
    }

}