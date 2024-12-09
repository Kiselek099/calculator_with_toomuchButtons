package com.example.calculatornew

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var inputET: EditText
    lateinit var resultTV: TextView
    lateinit var mainTB: Toolbar
    lateinit var oneBTN: Button
    lateinit var twoBTN: Button
    lateinit var threeBTN: Button
    lateinit var fourBTN: Button
    lateinit var fiveBTN: Button
    lateinit var sixBTN: Button
    lateinit var sevenBTN: Button
    lateinit var eightBTN: Button
    lateinit var nineBTN: Button
    lateinit var zeroBTN: Button
    lateinit var plusBTN: Button
    lateinit var difBTN: Button
    lateinit var multBTN: Button
    lateinit var divBTN: Button
    lateinit var equalBTN: Button
    lateinit var resetBTN: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
        onClickButtons()
        fun evaluateExpression(expression: String): Double {
            val exp = net.objecthunter.exp4j.ExpressionBuilder(expression).build()
            return exp.evaluate()
        }
        fun calculateResult() {
            val input = inputET.text.toString()
            try {
                val result = evaluateExpression(input)
                resultTV.text = result.toString()
            } catch (e: Exception) {
                resultTV.text = "Ошибка"
            }
        }
        equalBTN.setOnClickListener {
            calculateResult()
        }
    }

    private fun onClickButtons() {
        oneBTN.setOnClickListener {
            inputET.setText(inputET.text.toString() + "1")
            inputET.setSelection(inputET.text.length)
        }
        twoBTN.setOnClickListener {
            inputET.setText(inputET.text.toString() + "2")
            inputET.setSelection(inputET.text.length)
        }
        threeBTN.setOnClickListener {
            inputET.setText(inputET.text.toString() + "3")
            inputET.setSelection(inputET.text.length)
        }
        fourBTN.setOnClickListener {
            inputET.setText(inputET.text.toString() + "4")
            inputET.setSelection(inputET.text.length)
        }
        fiveBTN.setOnClickListener {
            inputET.setText(inputET.text.toString() + "5")
            inputET.setSelection(inputET.text.length)
        }
        sixBTN.setOnClickListener {
            inputET.setText(inputET.text.toString() + "6")
            inputET.setSelection(inputET.text.length)
        }
        sevenBTN.setOnClickListener {
            inputET.setText(inputET.text.toString() + "7")
            inputET.setSelection(inputET.text.length)
        }
        eightBTN.setOnClickListener {
            inputET.setText(inputET.text.toString() + "8")
            inputET.setSelection(inputET.text.length)
        }
        nineBTN.setOnClickListener {
            inputET.setText(inputET.text.toString() + "9")
            inputET.setSelection(inputET.text.length)
        }
        zeroBTN.setOnClickListener {
            inputET.setText(inputET.text.toString() + "0")
            inputET.setSelection(inputET.text.length)
        }
        plusBTN.setOnClickListener {
            inputET.setText(inputET.text.toString() + "+")
            inputET.setSelection(inputET.text.length)
        }
        difBTN.setOnClickListener {
            inputET.setText(inputET.text.toString() + "-")
            inputET.setSelection(inputET.text.length)
        }
        divBTN.setOnClickListener {
            inputET.setText(inputET.text.toString() + "/")
            inputET.setSelection(inputET.text.length)
        }
        multBTN.setOnClickListener {
            inputET.setText(inputET.text.toString() + "*")
            inputET.setSelection(inputET.text.length)
        }
        resetBTN.setOnClickListener {
            inputET.text.clear()
            resultTV.text = ""
        }
    }

    private fun init() {
        oneBTN = findViewById(R.id.oneBTN)
        twoBTN = findViewById(R.id.twoBTN)
        threeBTN = findViewById(R.id.threeBTN)
        fourBTN = findViewById(R.id.fourBTN)
        fiveBTN = findViewById(R.id.fiveBTN)
        sixBTN = findViewById(R.id.sixBTN)
        sevenBTN = findViewById(R.id.sevenBTN)
        eightBTN = findViewById(R.id.eightBTN)
        nineBTN = findViewById(R.id.nineBTN)
        zeroBTN = findViewById(R.id.zeroBTN)
        plusBTN = findViewById(R.id.plusBTN)
        divBTN = findViewById(R.id.divBTN)
        difBTN = findViewById(R.id.difBTN)
        multBTN = findViewById(R.id.multBTN)
        equalBTN = findViewById(R.id.equalBTN)
        resetBTN = findViewById(R.id.resetBTN)
        inputET = findViewById(R.id.inputET)
        resultTV = findViewById(R.id.resultTV)
        mainTB = findViewById(R.id.mainTB)
        setSupportActionBar(mainTB)
        supportActionBar?.title = "Калькулятор"
        mainTB.setTitleTextColor(resources.getColor(R.color.white))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val exitItem: MenuItem? = menu?.findItem(R.id.exitApp)
        exitItem?.icon?.setTint(resources.getColor(R.color.white))
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.exitApp -> {
                finishAffinity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}