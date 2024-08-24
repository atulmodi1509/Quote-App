package com.example.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.quotesapp.models.DataManager
import com.example.quotesapp.screens.QuoteDetailScreen
import com.example.quotesapp.screens.QuoteListScreen



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        DataManager.loadAssetsFromFile(this)
        setContent {

            LaunchedEffect(key1 = true) {
                DataManager.loadAssetsFromFile(this@MainActivity)
            }

            App()
        }
    }
}

@Composable
fun App()
{
    if (DataManager.isDataLoaded.value)
    {
        if (DataManager.currentPages.value == Pages.LISTING)
        {
            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }
        }
        else{
            DataManager.currentQuote?.let { QuoteDetailScreen(quote = it) }
        }

    }
    else
    {
        Box (contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()){
            Text(text = "Loading.....",
                style = MaterialTheme.typography.titleMedium)
        }
    }
}

enum class Pages {
    LISTING,
    DETAIL
}





