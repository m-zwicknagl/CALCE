package com.example.calce

import kotlin.reflect.typeOf

class Operation(var operator:Char): Item() {
    var leftItem:Item = Number(0.0)
    var rightItem:Item = Number(0.0)
    var opPriority = mapOf('+' to 0, '-' to 0, '*' to 1, '/' to 1, '#' to 99999)

    override fun calc(): Double {
        return callOperation()
    }

    override fun addItem(newItem:Item):Boolean {
        if(leftItem is Operation && leftItem.addItem(newItem)) {
            return true
        }
        if(rightItem is Operation) if(rightItem.addItem(newItem)){
            return true
        }
        if((newItem is Operation) && (leftItem is Number) && !leftItem.done)
            if(opPriority.getValue(operator) < opPriority.getValue(newItem.operator) ){
                newItem.done = true
                leftItem = newItem
                return true
            }
        if((leftItem is Number) && (newItem is Number) && (leftItem.done == false)){
            newItem.done = true
            leftItem = newItem
            return true
        }
        if((rightItem is Number) && (newItem is Number) && (rightItem.done == false)){
            newItem.done = true
            rightItem = newItem
            return true
        }
        return false
    }

    fun callOperation():Double{
        when(operator){
            '+'->return add(leftItem,rightItem)
            '-'->return sub(leftItem,rightItem)
            '*'->return mul(leftItem,rightItem)
            '/'->return div(leftItem,rightItem)
            else->{return 0.0}
        }
    }

    fun add(val1:Item, val2:Item):Double{
        return val1.calc() + val2.calc()
    }
    fun sub(val1:Item, val2:Item):Double{
        return val1.calc() - val2.calc()
    }
    fun mul(val1:Item, val2:Item):Double{
        return val1.calc() * val2.calc()
    }
    fun div(val1:Item, val2:Item):Double{
        return val1.calc() / val2.calc()
    }





}