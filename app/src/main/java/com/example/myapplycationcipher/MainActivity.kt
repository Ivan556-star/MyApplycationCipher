package com.example.myapplycationcipher

import android.content.ClipData
import android.content.ClipboardManager
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import com.example.myapplycationcipher.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        Log.d("MainAct_Log", "OnCreate")

        // получаем массив строк из файла ресурсов
        val arrayStr = resources.getStringArray(R.array.namesCyphers)

        // для проверки, что выбрал пользователь в спинере
        bindingClass.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "Вы выбрали шифр: ${arrayStr[position]}" , Toast.LENGTH_SHORT).show()
                when {
                    arrayStr[position] == "Цезаря" -> {
                        // для ввода только цифр
                        bindingClass.inputKey.inputType = InputType.TYPE_CLASS_NUMBER
                        // делаем поле кликабельным и выдимым
                        bindingClass.inputKey.isFocusable = true
                        bindingClass.inputKey.isFocusableInTouchMode = true
                        bindingClass.inputKey.isClickable = true
                        bindingClass.inputKey.visibility = View.VISIBLE;

                        bindingClass.encryptButton.setOnClickListener {
                            if (checkInTextAndInKey()) {
                                if (bindingClass.inputKey.text.toString().isDigitsOnly() && bindingClass.inputKey.text.toString().toInt() > 0)
                                    //сразу работаю с калссом Cezar не создовая его объект
                                    bindingClass.encrDecryTV.text = Cezar().crypt(1,
                                            bindingClass.inputText.text.toString(),
                                            bindingClass.inputKey.text.toString())[0]
                                else
                                    Toast.makeText(this@MainActivity, "Ошибка, ключ должен быть целым положительным числом" , Toast.LENGTH_SHORT).show()
                            }
                            else
                                Toast.makeText(this@MainActivity, "Ошибка, поля не должны быть пустыми" , Toast.LENGTH_SHORT).show()

                        }

                        bindingClass.decryptButton.setOnClickListener {
                            if (checkInTextAndInKey())
                                bindingClass.encrDecryTV.text = Cezar().crypt(0,
                                        bindingClass.inputText.text.toString(),
                                        bindingClass.inputKey.text.toString())[0]
                            else
                                Toast.makeText(this@MainActivity, "Ошибка, поля не должны быть пустыми" , Toast.LENGTH_SHORT).show()

                        }
                    }
                    arrayStr[position] == "Атбаш" -> {
                        bindingClass.inputKey.isFocusable = false
                        bindingClass.inputKey.isFocusableInTouchMode = false
                        bindingClass.inputKey.isClickable = false
                        bindingClass.inputKey.visibility = View.INVISIBLE;

                        bindingClass.encryptButton.setOnClickListener {
                            if (checkInTextAndInKey())
                            //сразу работаю с калссом Cezar не создовая его объект
                                bindingClass.encrDecryTV.text = AtBash().crypt(1,
                                        bindingClass.inputText.text.toString(),
                                        bindingClass.inputKey.text.toString())[0]
                            else
                                Toast.makeText(this@MainActivity, "Ошибка, поле не может быть пустыми" , Toast.LENGTH_SHORT).show()

                        }

                        bindingClass.decryptButton.setOnClickListener {
                            if (checkInTextAndInKey())
                                bindingClass.encrDecryTV.text = AtBash().crypt(0,
                                        bindingClass.inputText.text.toString(),
                                        bindingClass.inputKey.text.toString())[0]
                            else
                                Toast.makeText(this@MainActivity, "Ошибка, поле не может быть пустыми" , Toast.LENGTH_SHORT).show()

                        }
                    }
                    arrayStr[position] == "Спарты" -> {
                        bindingClass.inputKey.isFocusable = false
                        bindingClass.inputKey.isFocusableInTouchMode = false
                        bindingClass.inputKey.isClickable = false
                        bindingClass.inputKey.visibility = View.INVISIBLE;


                        bindingClass.encryptButton.setOnClickListener {
                            if (checkInTextAndInKey())
                            //сразу работаю с калссом Cezar не создовая его объект
                                bindingClass.encrDecryTV.text = Skitalo().crypt(1,
                                        bindingClass.inputText.text.toString(),
                                        bindingClass.inputKey.text.toString())[0]
                            else
                                Toast.makeText(this@MainActivity, "Ошибка, поле не может быть пустыми" , Toast.LENGTH_SHORT).show()

                        }

                        bindingClass.decryptButton.setOnClickListener {
                            if (checkInTextAndInKey())
                                bindingClass.encrDecryTV.text = Skitalo().crypt(0,
                                        bindingClass.inputText.text.toString(),
                                        bindingClass.inputKey.text.toString())[0]
                            else
                                Toast.makeText(this@MainActivity, "Ошибка, поле не может быть пустыми" , Toast.LENGTH_SHORT).show()

                        }
                    }
                    arrayStr[position] == "Виженера" -> {
                        bindingClass.inputKey.inputType = InputType.TYPE_CLASS_TEXT
                        bindingClass.inputKey.isFocusable = true
                        bindingClass.inputKey.isFocusableInTouchMode = true
                        bindingClass.inputKey.isClickable = true
                        bindingClass.inputKey.visibility = View.VISIBLE;

                        bindingClass.encryptButton.setOnClickListener {
                            if (checkInTextAndInKey())
                            //сразу работаю с калссом Cezar не создовая его объект
                                bindingClass.encrDecryTV.text = Vijenera().crypt(1,
                                        bindingClass.inputText.text.toString(),
                                        bindingClass.inputKey.text.toString())[0]
                            else
                                Toast.makeText(this@MainActivity, "Ошибка, поля не должны быть пустыми" , Toast.LENGTH_SHORT).show()

                        }

                        bindingClass.decryptButton.setOnClickListener {
                            if (checkInTextAndInKey())
                                bindingClass.encrDecryTV.text = Vijenera().crypt(0,
                                        bindingClass.inputText.text.toString(),
                                        bindingClass.inputKey.text.toString())[0]
                            else
                                Toast.makeText(this@MainActivity, "Ошибка, поля не должны быть пустыми" , Toast.LENGTH_SHORT).show()

                        }
                    }
                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        // для копирования текста из encrDecryTV долгим нажатием
        bindingClass.encrDecryTV.setOnLongClickListener {
            val clipboard = bindingClass.encrDecryTV.context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?
            val clip = ClipData.newPlainText("Order Number", bindingClass.encrDecryTV.text.toString())
            clipboard?.setPrimaryClip(clip)
            Toast.makeText(this@MainActivity, "Текст был скопирован в буфер обмена", Toast.LENGTH_SHORT).show()
            true
        }

    }


    fun checkInTextAndInKey() : Boolean {
        if (bindingClass.inputText.text.toString().isEmpty() && bindingClass.inputText.text.toString().isEmpty())
            return false
        return true
    }

    fun checkInText() : Boolean {
        if (bindingClass.inputText.text.toString().isEmpty())
            return false
        return true
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