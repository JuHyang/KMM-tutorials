package com.example.myapplication2.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
            MyApplicationTheme {
                val greetings by mainViewModel.greetingList.collectAsStateWithLifecycle()

                Column (
                    modifier = Modifier.padding(all = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    greetings.forEach { greeting ->
                        Text(greeting)
                        Divider()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
    }
}
