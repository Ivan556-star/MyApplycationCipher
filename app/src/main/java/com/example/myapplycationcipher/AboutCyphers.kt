package com.example.myapplycationcipher

import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplycationcipher.databinding.ActivityAboutCyphersBinding
import com.example.myapplycationcipher.databinding.ActivityAboutCyphersBinding.*


class AboutCyphers : AppCompatActivity() {
    private lateinit var bindingClass: ActivityAboutCyphersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityAboutCyphersBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        // запрет на поворот экрана
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        SPINER()
        //Чтобы текст в textView можно было скролить. Также в xml коде нужно добавить параметр ' android:scrollbars="vertical" '
        bindingClass.textViewAboutCyphers.setMovementMethod(ScrollingMovementMethod())
        bindingClass.descOfTheAlgorithm.setMovementMethod(ScrollingMovementMethod())
    }


    private fun SPINER(){
        // получаем массив строк из файла ресурсов
        val arrayStr = resources.getStringArray(R.array.namesCyphers)

        // для проверки, что выбрал пользователь в спинере
        bindingClass.spinnerAboutCyphers.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //чтобы изменить цвет текста в спинере на белый
                try {
                    (parent!!.getChildAt(0) as TextView).setTextColor(Color.BLACK)
                }catch (e: NullPointerException){
                    Log.e("MainAct_Log", "NullPointerException")
                }
                when {
                    arrayStr[position] == "Цезаря" -> {
                        bindingClass.textViewAboutCyphers.text = resources.getString(R.string.Cezar)
                        bindingClass.descOfTheAlgorithm.text = resources.getString(R.string.CezarALG)
                    }
                    arrayStr[position] == "Атбаш" -> {
                        bindingClass.textViewAboutCyphers.text = resources.getString(R.string.Atbash)
                        bindingClass.descOfTheAlgorithm.text = resources.getString(R.string.AtbashALG)
                    }
                    arrayStr[position] == "Спарты" -> {
                        bindingClass.textViewAboutCyphers.text = resources.getString(R.string.Sparta)
                        bindingClass.descOfTheAlgorithm.text = resources.getString(R.string.SpartaALG)
                    }
                    arrayStr[position] == "Виженера" -> {
                        bindingClass.textViewAboutCyphers.text = resources.getString(R.string.Vijener)
                        bindingClass.descOfTheAlgorithm.text = resources.getString(R.string.VijenerALG)
                    }
                }

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

}