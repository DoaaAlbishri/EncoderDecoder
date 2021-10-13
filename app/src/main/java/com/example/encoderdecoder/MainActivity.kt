package com.example.encoderdecoder

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val phrases = arrayListOf<ArrayList<String>>()
    private lateinit var rvMain: RecyclerView
    private lateinit var rvAdapter: RVAdapter
    private lateinit var etPhrase1: EditText
    private lateinit var etPhrase2: EditText
    private lateinit var btEncode: Button
    private lateinit var btDecode: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMain = findViewById(R.id.rvMain)
        rvAdapter = RVAdapter(phrases)
        rvMain.adapter = rvAdapter
        rvMain.layoutManager = LinearLayoutManager(this)

        etPhrase1 = findViewById(R.id.etPhrase1)
        btEncode = findViewById(R.id.btEncode)
        btEncode.setOnClickListener {
            encoder(etPhrase1.text.toString())
        }
        etPhrase2 = findViewById(R.id.etPhrase2)
        btDecode = findViewById(R.id.btDecode)
        btDecode.setOnClickListener {
            decoder(etPhrase2.text.toString())
        }

    }
    fun encoder(userInput:String){
        var S = userInput
        var input = userInput.toLowerCase()
        var bool = false
        // changed string
        var newS = ""
        var k = 13
        // iterate for every characters
        for (i in 0 until input.length) {
            // ASCII value
            val check = userInput.get(i).toInt()
            val lettr = input.get(i).toInt()
            if(check>64 && check<91){
                bool = true
            }
            // store the duplicate
            val dup = k
            // if k-th ahead character exceed 'z'
            if (lettr + k > 122) {
                k -= 122 - lettr
                k = k % 26
                var r = 96 + k
                if (bool) {
                    newS += (96 + k).toChar().toUpperCase()
                    bool = false
                }else{
                    newS += (96 + k).toChar()
                }
            } else {
                if (lettr > 64 && lettr<91 || lettr>96 && lettr< 123) {
                    if (bool) {
                    newS +=  (lettr + k).toChar().toUpperCase()
                        bool = false
                    }else{
                        newS +=  (lettr + k).toChar()
                    }
                } else {
                    newS += lettr.toChar()
                }
            }
            k = dup
        }
        // print the new string
        println(newS)
        phrases.add(arrayListOf(S, newS))
        rvAdapter.update()
        etPhrase1.text.clear()
    }

    fun decoder(userInput:String){
        var S = userInput
        var input = userInput.toLowerCase()
        var bool = false
        // changed string
        var newS = ""
        var k = 13
        // iterate for every characters
        for (i in 0 until input.length) {
            // ASCII value
            val check = userInput.get(i).toInt()
            val lettr = input.get(i).toInt()
            if(check>64 && check<91){
                bool = true
            }
            // store the duplicate
            val dup = k
            // if k-th ahead character exceed 'z'
            if (lettr + k > 122) {
                k -= 122 - lettr
                k = k % 26
                var r = 96 + k
                if (bool) {
                    newS += (96 + k).toChar().toUpperCase()
                    bool = false
                }else{
                    newS += (96 + k).toChar()
                }
            } else {
                if (lettr > 64 && lettr<91 || lettr>96 && lettr< 123) {
                    if (bool) {
                        newS +=  (lettr + k).toChar().toUpperCase()
                        bool = false
                    }else{
                        newS +=  (lettr + k).toChar()
                    }
                } else {
                    newS += lettr.toChar()
                }
            }
            k = dup
        }
        // print the new string
        println(newS)
        phrases.add(arrayListOf(S, newS))
        rvAdapter.update()
        etPhrase2.text.clear()
    }
}