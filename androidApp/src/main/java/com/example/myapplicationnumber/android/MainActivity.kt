package com.example.countertracking.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationnumber.android.MyApplicationTheme

//import androidx.compose.ui.unit.sp

//import com.example.countertracking.Greeting

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ){
                    Counter()
                }
            }
        }
    }
}


@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun Defaultnumber() {
    MyApplicationTheme {
        Modifier.background(Color.White)
        Counter()
    }
}

@Composable
fun Counter() {
    var displayText = remember { mutableStateOf("0")}

    Column() {
        Row (modifier = Modifier
            .height(50.dp)
            .width(100.dp)){
            CountDisplay(displayText)
        }
        Row() {
            Column() {
                addButton(displayText)
            }
            Column {
                subButton(displayText)
            }
        }
    }
}

@Composable
fun CountDisplay (display: MutableState<String>) {
    Text(text = display.value,
        modifier = Modifier
            .height(100.dp)
            .padding(10.dp)
            .fillMaxWidth(),
        fontSize = 20.sp)
}

@Composable
fun addButton(display: MutableState<String>) {
    Button(modifier = Modifier
        .background(Color.Cyan)
        .padding(4.dp), onClick = {
        val currentCount = display.value.toInt()
        display.value = (currentCount + 1).toString()
    }) {
        Text(text = "add")
    }
}

@Composable
fun subButton(display: MutableState<String>) {
    Button(modifier = Modifier
        .background(Color.Cyan)
        .padding(4.dp), onClick = {
        val currentCount = display.value.toInt()
        display.value = (currentCount - 1).toString()
    }) {
        Text(text = "sub")
    }
}