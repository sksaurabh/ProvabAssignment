package com.saurabh.provabassignment

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

var olderStackString:TextView?=null
var recentStackString:TextView?=null
var addButton:Button?=null
var addStack:EditText?=null
var recentStack: Stack<String> = Stack<String>()
var olderStack: Stack<String> = Stack<String>()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        olderStackString=findViewById(R.id.olderStackString)
        recentStackString=findViewById(R.id.RecentStackString)
        addButton=findViewById(R.id.addButton)
        addStack=findViewById(R.id.addStack)

        addButton?.setOnClickListener {
            add(addStack?.text.toString())
            olderStackString?.text=olderStack.toString()
            recentStackString?.text=recentStack.toString()
        }

    }

    fun add(s: String?) {
        if (recentStack.size == 2) {
            //String tempString= recentStack.pop();
            if (!recentStack.contains(s)) {
                val topelement = recentStack.pop()
                if (olderStack.size == 3) {
                    val topinOlder = olderStack.pop()
                    val secondLastinOlder = olderStack.pop()
                    val lastInOlder = olderStack.pop()
                    olderStack.add(topelement)
                    olderStack.add(lastInOlder)
                    olderStack.add(secondLastinOlder)
                } else {
                    if (!olderStack.isEmpty()) {
                        if (olderStack.size == 2) {
                            val topinOlder = olderStack.pop()
                            val secondLastinOlder = olderStack.pop()
                            olderStack.add(topelement)
                            olderStack.add(secondLastinOlder)
                            olderStack.add(topinOlder)
                        } else {
                            val topinOlder = olderStack.pop()
                            olderStack.add(topelement)
                            olderStack.add(topinOlder)
                        }
                    } else {
                        olderStack.add(topelement)
                    }
                }
                val latesttopelement = recentStack.pop()
                recentStack.add(s)
                recentStack.add(latesttopelement)
            }
        } else {
            if (recentStack.isEmpty()) {
                recentStack.add(s)
            } else if (!recentStack.contains(s)) {
                val topelement = recentStack.pop()
                recentStack.add(s)
                recentStack.add(topelement)
            }
        }
    }
}