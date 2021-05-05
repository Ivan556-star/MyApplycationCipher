package com.example.myapplycationcipher

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.content.pm.ActivityInfo
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
    private var backPressedTime: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        Log.d("MainAct_Log", "OnCreate")

        SPINER()
        // запрет на поворот экрана
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
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





    private fun SPINER(){
        // получаем массив строк из файла ресурсов
        val arrayStr = resources.getStringArray(R.array.namesCyphers)

        // для проверки, что выбрал пользователь в спинере
        bindingClass.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(this@MainActivity, "Вы выбрали шифр: ${arrayStr[position]}", Toast.LENGTH_SHORT).show()
                when {
                    arrayStr[position] == "Цезаря" -> {
                        // для ввода только цифр
                        bindingClass.inputKey.inputType = InputType.TYPE_CLASS_NUMBER
                        VISIBLE()

                        bindingClass.encryptButton.setOnClickListener {
                            if (checkInTextAndInKey()) {

                                try {
                                    if (bindingClass.inputKey.text.toString().isDigitsOnly() && bindingClass.inputKey.text.toString().toInt() > 0) {
                                        //сразу работаю с калссом Cezar не создовая его объект
                                        val cypher = Cezar().crypt(1,
                                                bindingClass.inputText.text.toString(),
                                                bindingClass.inputKey.text.toString())
                                        bindingClass.encrDecryTV.text = cypher[0]
                                        bindingClass.TVKey.text = cypher[1]
                                    }
                                    else
                                        Toast.makeText(this@MainActivity,
                                                "Ошибка, ключ должен быть целым положительным числом",
                                                Toast.LENGTH_SHORT).show()
                                } catch (e: Exception){
                                    Toast.makeText(this@MainActivity,
                                            "Ошибка, ключ должен быть целым положительным числом",
                                            Toast.LENGTH_SHORT).show()
                                }
                            }
                            else
                                Toast.makeText(this@MainActivity,
                                        "Ошибка, поля не должны быть пустыми",
                                        Toast.LENGTH_SHORT).show()

                        }

                        bindingClass.decryptButton.setOnClickListener {
                            if (checkInTextAndInKey())
                                try {
                                    if (bindingClass.inputKey.text.toString().isDigitsOnly() && bindingClass.inputKey.text.toString().toInt() > 0) {
                                        val cypher = Cezar().crypt(0,
                                                bindingClass.inputText.text.toString(),
                                                bindingClass.inputKey.text.toString())
                                        bindingClass.encrDecryTV.text = cypher[0]
                                        bindingClass.TVKey.text = cypher[1]
                                    }
                                    else
                                        Toast.makeText(this@MainActivity,
                                                "Ошибка, ключ должен быть целым положительным числом",
                                                Toast.LENGTH_SHORT).show()
                                } catch (e: Exception){
                                    Toast.makeText(this@MainActivity,
                                            "Ошибка, ключ должен быть целым положительным числом",
                                            Toast.LENGTH_SHORT).show()
                                }
                            else
                                Toast.makeText(this@MainActivity,
                                        "Ошибка, поля не должны быть пустыми",
                                        Toast.LENGTH_SHORT).show()

                        }
                    }
                    arrayStr[position] == "Атбаш" -> {
                        INVISIBLE()

                        bindingClass.encryptButton.setOnClickListener {
                            if (checkInText()){
                                val cypher = AtBash().crypt(1,
                                        bindingClass.inputText.text.toString(),
                                        bindingClass.inputKey.text.toString())
                                bindingClass.encrDecryTV.text = cypher[0]
                                bindingClass.TVKey.text = cypher[0]
                            }
                            else
                                Toast.makeText(this@MainActivity, "Ошибка, поле не может быть пустыми", Toast.LENGTH_SHORT).show()

                        }

                        bindingClass.decryptButton.setOnClickListener {
                            if (checkInText()){
                                val cypher = AtBash().crypt(0,
                                        bindingClass.inputText.text.toString(),
                                        bindingClass.inputKey.text.toString())
                                bindingClass.encrDecryTV.text = cypher[0]
                                bindingClass.TVKey.text = cypher[0]
                            }
                            else
                                Toast.makeText(this@MainActivity, "Ошибка, поле не может быть пустыми", Toast.LENGTH_SHORT).show()

                        }
                    }
                    arrayStr[position] == "Спарты" -> {
                        INVISIBLE()

                        bindingClass.encryptButton.setOnClickListener {
                            if (checkInText()){
                                val cypher = Skitalo().crypt(1,
                                        bindingClass.inputText.text.toString(),
                                        bindingClass.inputKey.text.toString())
                                bindingClass.encrDecryTV.text = cypher[0]
                                bindingClass.TVKey.text = cypher[0]
                            }
                            else
                                Toast.makeText(this@MainActivity, "Ошибка, поле не может быть пустыми", Toast.LENGTH_SHORT).show()

                        }

                        bindingClass.decryptButton.setOnClickListener {
                            if (checkInText()){
                                val cypher = Skitalo().crypt(0,
                                        bindingClass.inputText.text.toString(),
                                        bindingClass.inputKey.text.toString())
                                bindingClass.encrDecryTV.text = cypher[0]
                                bindingClass.TVKey.text = cypher[0]
                            }
                            else
                                Toast.makeText(this@MainActivity, "Ошибка, поле не может быть пустыми", Toast.LENGTH_SHORT).show()

                        }
                    }
                    arrayStr[position] == "Виженера" -> {
                        // для того, чтобы в поле можно было вводить текст
                        bindingClass.inputKey.inputType = InputType.TYPE_CLASS_TEXT
                        VISIBLE()

                        bindingClass.encryptButton.setOnClickListener {
                            if (checkInTextAndInKey()){
                                val cypher = Vijenera().crypt(1,
                                        bindingClass.inputText.text.toString(),
                                        bindingClass.inputKey.text.toString())
                                bindingClass.encrDecryTV.text = cypher[0]
                                bindingClass.TVKey.text = cypher[1]
                            }
                            else
                                Toast.makeText(this@MainActivity, "Ошибка, поля не должны быть пустыми", Toast.LENGTH_SHORT).show()

                        }

                        bindingClass.decryptButton.setOnClickListener {
                            if (checkInTextAndInKey()){
                                val cypher = Vijenera().crypt(0,
                                        bindingClass.inputText.text.toString(),
                                        bindingClass.inputKey.text.toString())
                                bindingClass.encrDecryTV.text = cypher[0]
                                bindingClass.TVKey.text = cypher[1]
                            }
                            else
                                Toast.makeText(this@MainActivity, "Ошибка, поля не должны быть пустыми", Toast.LENGTH_SHORT).show()

                        }
                    }
                }

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }


    // для копирования текста из encrDecryTV при нажатии на CopyAnswer
    fun onClickCopyAnswer(view: View){
        val clipboard = bindingClass.encrDecryTV.context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?
        val clip = ClipData.newPlainText("Order Number", bindingClass.encrDecryTV.text.toString())
        clipboard?.setPrimaryClip(clip)
        Toast.makeText(this@MainActivity, "Ответ был скопирован в буфер обмена", Toast.LENGTH_SHORT).show()
    }

    fun onClickCopyText(view: View){
        val clipboard = bindingClass.inputText.context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?
        val clip = ClipData.newPlainText("Order Number", bindingClass.inputText.text.toString())
        clipboard?.setPrimaryClip(clip)
        Toast.makeText(this@MainActivity, "Текст был скопирован в буфер обмена", Toast.LENGTH_SHORT).show()
    }

    fun onClickCopyKey(view: View){
        val clipboard = bindingClass.TVKey.context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?
        val clip = ClipData.newPlainText("Order Number", bindingClass.TVKey.text.toString())
        clipboard?.setPrimaryClip(clip)
        Toast.makeText(this@MainActivity, "Ключ был скопирован в буфер обмена", Toast.LENGTH_SHORT).show()
    }


    //чтобы вставить текст из буфера обмена
    fun onClickPasteText(view: View){
        val myClipboard = (getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?)!!
        val abc = myClipboard.primaryClip
        val item = abc?.getItemAt(0)
        bindingClass.inputText.setText(item?.text.toString())
        Toast.makeText(applicationContext, "Text Pasted", Toast.LENGTH_SHORT).show()
    }

    fun onClickPasteKey(view: View){
        val myClipboard = (getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?)!!
        val abc = myClipboard.primaryClip
        val item = abc?.getItemAt(0)
        bindingClass.inputKey.setText(item?.text.toString())
        Toast.makeText(applicationContext, "Key Pasted", Toast.LENGTH_SHORT).show()
    }


    //для передачи ответа в другие приложения
    fun onClickShareAnswer(view: View){
        val answer = "Текст:\n${bindingClass.encrDecryTV.text}"
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, answer)
        intent.type = "text/plain"

        startActivity(Intent.createChooser(intent, "Отправить в:"))
    }

    fun onClickShareKey(view: View){
        val key = "Ключ:\n${bindingClass.TVKey.text}"
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, key)
        intent.type = "text/plain"

        startActivity(Intent.createChooser(intent, "Отправить в:"))
    }



    private fun checkInTextAndInKey() : Boolean {
        if (bindingClass.inputText.text.toString().isEmpty() && bindingClass.inputText.text.toString().isEmpty())
            return false
        return true
    }

    private fun checkInText() : Boolean {
        if (bindingClass.inputText.text.toString().isEmpty())
            return false
        return true
    }


    // делаем поля кликабельными и выдимыми
    fun VISIBLE(){
        bindingClass.inputKey.visibility = View.VISIBLE
        bindingClass.pasteKey.visibility = View.VISIBLE
    }

    // делаем поля не кликабельными и не выдимыми
    fun INVISIBLE(){
        bindingClass.inputKey.visibility = View.GONE
        bindingClass.pasteKey.visibility = View.GONE
    }

    // системная кнопка "Назад"
    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
            return
        }
        else
            Toast.makeText(this, "Нажмите ещё раз, чтобы выйти из приложения", Toast.LENGTH_SHORT).show()
        backPressedTime = System.currentTimeMillis()
    }

}