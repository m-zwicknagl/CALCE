package com.example.calce


import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout


class MainActivity : AppCompatActivity(),View.OnClickListener {
    private val TAG = "MyActivity"
    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var textViewMath: TextView
    lateinit var textViewSolution: TextView
    var task:String = ""
    var treeString:String = ""
    var openCount:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        textViewMath = findViewById(R.id.textViewMath)
        textViewSolution = findViewById(R.id.textViewSolution)

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        // to make the Navigation drawer icon always appear on the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_0 -> {
                task += "0"
            }
            R.id.button_1 -> {
                task += "1"
            }
            R.id.button_2 -> {
                task += "2"
            }
            R.id.button_3 -> {
                task += "3"
            }
            R.id.button_4 -> {
                task += "4"
            }
            R.id.button_5 -> {
                task += "5"
            }
            R.id.button_6 -> {
                task += "6"
            }
            R.id.button_7 -> {
                task += "7"
            }
            R.id.button_8 -> {
                task += "8"
            }
            R.id.button_9 -> {
                task += "9"
            }
            R.id.button_plus -> {
                task += " + "
            }
            R.id.button_minus -> {
                task += " - "
            }
            R.id.button_mul -> {
                task += " * "
            }
            R.id.button_div -> {
                task += " / "
            }
            R.id.button_point ->{
                task += "."
            }
            R.id.button_equal -> {
                Log.v(TAG,solve(task).toString())
            }
            R.id.button_c -> {
                task = ""
                textViewMath.text = ""
                textViewSolution.text = ""
            }

            else -> {
            }
        }
        textViewMath.text = task

    }
    fun solve(text: String):Double {
        var items = task.split(" ")
        var root = Operation('#')
        for(item in items){
            if(checkOperator(item)){
                if(root.operator== '#')
                {
                    root.operator = item.toCharArray().get(0)
                }else {
                    root.addItem(Operation(item.toCharArray()[0]))
                }
            }else{
                root.addItem((Number(item.toDouble())))
            }
        }
        var ergebnis = root.calc()
        Log.v("Main Activity"," : " + ergebnis)
        textViewSolution.text = " = " + ergebnis
        return ergebnis

    }
    fun checkOperator(text:String):Boolean{
        var s = "+-*/"
        for(c in s){
            if(text.contains(c)){
                return true
            }
        }
        return false
    }


}

