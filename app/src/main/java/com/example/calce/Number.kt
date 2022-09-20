package com.example.calce

class Number(var value:Double = 0.0): Item() {



    override fun calc(): Double {
        return value
    }

    override fun addItem(newItem:Item):Boolean {
        return false
    }
}