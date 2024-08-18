package com.example.memorytest

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var idList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {

        logCurrentMemoryProfile("onCreate start")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logCurrentMemoryProfile("onCreate after setContentView")

        val executeButton: Button = findViewById(R.id.btnExecute)

        Thread {
            Thread.sleep(10000)
            logCurrentMemoryProfile("onCreate end after delay")
        }.start()

        executeButton.setOnClickListener {
            for (i in 1..1000000) {
                idList.add(i)
            }
            logCurrentMemoryProfile("onCreate after button press")
        }
    }
}