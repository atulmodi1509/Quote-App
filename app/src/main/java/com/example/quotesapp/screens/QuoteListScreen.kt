package com.example.quotesapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quotesapp.models.DataManager
import com.example.quotesapp.models.Quote

@Composable
fun QuoteListScreen(data: List<Quote>, onClick: (quote: Quote)->Unit)
{
    val isDataLoaded = DataManager.isDataLoaded.value
    Column {
        Text(text = "Quote App",
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(top = 8.dp, bottom = 8.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium)

        QuoteList(data = data, onClick)


    }
}

@Composable
fun QuoteList(data: List<Quote>, onClick: (quote: Quote)->Unit)
{
    val listState = rememberLazyListState()
    LazyColumn(state = listState, content = {
        items(data)
        {
            quote ->  QuoteListItem(quote = quote,onClick)
        }
    })
}
