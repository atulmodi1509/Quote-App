package com.example.quotesapp.models

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.example.quotesapp.Pages
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.FileNotFoundException
import java.io.InputStreamReader

@Serializable
data class Quote (val text: String, val author: String)

object DataManager {

    var data = emptyList<Quote>()
    var currentQuote: Quote? = null
    var currentPages = mutableStateOf(Pages.LISTING)
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetsFromFile(context: Context) {
        try {
            val inputStream = context.assets.open("quotes.json")
            val reader = InputStreamReader(inputStream)
            val jsonString = reader.readText()
            data = Json.decodeFromString(jsonString)
            reader.close()
            isDataLoaded.value = true

        }catch (e: FileNotFoundException) {
            Log.e("DataManager", "File not found: ${e.message}")
        } catch (e: kotlinx.serialization.SerializationException) {
            Log.e("DataManager", "Serialization error: ${e.message}")} catch (e: Exception) {
            Log.e("DataManager", "Error loading data: ${e.message}")
        }
    }

    fun switchPages(quote: Quote?) {
        if(currentPages.value == Pages.LISTING)
        {
            currentQuote = quote
            currentPages.value = Pages.DETAIL
        }
        else
        {
            currentPages.value = Pages.LISTING
        }
    }
}
