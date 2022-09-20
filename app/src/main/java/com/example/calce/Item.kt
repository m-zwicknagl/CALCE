package com.example.calce

import android.util.Log

abstract class Item (){

    var done:Boolean = false
    abstract fun calc():Double
    abstract fun addItem(newItem:Item):Boolean

}