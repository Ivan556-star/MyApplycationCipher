package com.example.myapplycationcipher

import android.content.ClipData
import android.content.ClipboardManager
import android.content.pm.ActivityInfo
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import com.example.myapplycationcipher.databinding.ActivityHackBinding

class Hack : AppCompatActivity() {
    private lateinit var bindingClass: ActivityHackBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityHackBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        SPINER()

        // запрет на поворот экрана
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    }


    private fun SPINER() {
        // получаем массив строк из файла ресурсов
        val arrayStr = resources.getStringArray(R.array.ChoiceHack)
        // для проверки, что выбрал пользователь в спинере
        bindingClass.spinnerHack.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    //чтобы изменить цвет текста в спинере на белый
                    try {
                        (parent!!.getChildAt(0) as TextView).setTextColor(Color.WHITE)
                    } catch (e: NullPointerException) {
                        Log.e("MainAct_Log", "NullPointerException")
                    }

                    //Toast.makeText(this@MainActivity, "Вы выбрали шифр: ${arrayStr[position]}", Toast.LENGTH_SHORT).show()
                    when {
                        arrayStr[position] == "Цезаря" -> {
                            setDefaultText()
                            visible()
                            bindingClass.ButtonHack.setOnClickListener {
                                var tmpS = ""
                                var k = 1
                                if (!bindingClass.inputTextHack.text.toString().isEmpty()) {
                                    if (checkCheckBoxes() != -1) {
                                        val cypher = Cezar().hack(
                                            bindingClass.inputTextHack.text.toString(),
                                            checkCheckBoxes()
                                        )
                                        for (s in cypher) {
                                            tmpS += "Ключ $k:  $s\n\n"
                                            k++
                                        }
                                        bindingClass.encrDecryTVHack.text = tmpS
                                    }
                                    else{
                                        val toast = Toast.makeText(
                                            this@Hack,
                                            "Ошибка, выберите алфавит",
                                            Toast.LENGTH_SHORT
                                        )
                                        toast.setGravity(Gravity.TOP, 0, 0)
                                        toast.show()
                                    }
                                } else {
                                    val toast = Toast.makeText(
                                        this@Hack,
                                        "Ошибка, поле текста не должно быть пустым",
                                        Toast.LENGTH_SHORT
                                    )
                                    toast.setGravity(Gravity.TOP, 0, 0)
                                    toast.show()
                                }
                            }
                        }
                        arrayStr[position] == "Спарты" -> {
                            invisible()
                            setDefaultText()
                            bindingClass.ButtonHack.setOnClickListener {
                                var tmpS = ""
                                var k = 1
                                if (!bindingClass.inputTextHack.text.toString().isEmpty()) {
                                    val cypher = Skitalo().hack(
                                        bindingClass.inputTextHack.text.toString(),
                                        0
                                    )
                                    for (s in cypher) {
                                        tmpS += "Ключ $k:  $s\n\n"
                                        k++
                                    }
                                    bindingClass.encrDecryTVHack.text = tmpS
                                } else {
                                    val toast = Toast.makeText(
                                        this@Hack,
                                        "Ошибка, поле текста не должно быть пустым",
                                        Toast.LENGTH_SHORT
                                    )
                                    toast.setGravity(Gravity.TOP, 0, 0)
                                    toast.show()
                                }
                            }
                        }
                    }
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
    }


    private fun setDefaultText() {
        bindingClass.encrDecryTVHack.text = "Расшифрованные варианты"
        bindingClass.inputTextHack.setText("")
    }

    private fun invisible(){
        bindingClass.checkBoxEN.visibility = View.GONE
        bindingClass.checkBoxRU.visibility = View.GONE
        bindingClass.textView.visibility = View.GONE
    }

    private fun visible(){
        bindingClass.checkBoxEN.visibility = View.VISIBLE
        bindingClass.checkBoxRU.visibility = View.VISIBLE
        bindingClass.textView.visibility = View.VISIBLE
    }

    private fun checkCheckBoxes(): Int {
        if (bindingClass.checkBoxEN.isChecked == true && bindingClass.checkBoxRU.isChecked == true)
            return 3
        else if (bindingClass.checkBoxEN.isChecked == true)
            return 2
        else if (bindingClass.checkBoxRU.isChecked == true)
            return 1
        else
            return -1
    }

    fun onClickCopyTextHack(view: View){
        val clipboard = bindingClass.inputTextHack.context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?
        val clip = ClipData.newPlainText("Order Number", bindingClass.inputTextHack.text.toString())
        clipboard?.setPrimaryClip(clip)
        val toast = Toast.makeText(this@Hack, "Текст был скопирован в буфер обмена", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 0, 0)
        toast.show()
    }

    fun onClickPasteTextHack(view: View){
        val myClipboard = (getSystemService(CLIPBOARD_SERVICE) as ClipboardManager?)!!
        val abc = myClipboard.primaryClip
        val item = abc?.getItemAt(0)
        bindingClass.inputTextHack.setText(item?.text.toString())
        val toast = Toast.makeText(this, "Text Pasted", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 0, 0)
        toast.show()
    }

    fun onClickClearHack(view: View){
        bindingClass.encrDecryTVHack.text = "Расшифрованные варианты"
    }

}