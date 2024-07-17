package com.alisdn.intentserviceapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alisdn.intentserviceapp.ui.theme.IntentServiceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            IntentServiceAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding), onclick = { onclick() }
                    )
                }
            }
        }
    }

    private fun onclick() {
         Intent(this,MyIntentService::class.java).also{
            startService(it)
        }
    }
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier,
    onclick: ()->Unit) {
    var name = "NNNNNN"

    Column {
        Button(onClick = {
            onclick()
            name="Service started"
        }) {
            Text(text = "Start")
        }
        Button(onClick = {
            MyIntentService.stopService()
            name="Service stopped"
        }) {
            Text(text = "Stop")
        }
        Text(
            text = name,
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
//    IntentServiceAppTheme {
//        Greeting("Android")
//    }
}