package com.example.quotesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quotesapp.models.Quote


@Composable
fun QuoteListItem(quote: Quote, onClick: (quote: Quote)-> Unit)
{
    Card(elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(quote) }
            .padding(8.dp)
            )
    {

        Row(Modifier.padding(16.dp)){
            Image(imageVector = Icons.Filled.Close, contentDescription ="",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .background(Color.Black)
                    .size(40.dp)
                    .rotate(180f))

            Spacer(modifier = Modifier.padding(8.dp))

            Column {
                if(quote.text.isNotEmpty())
                {
                    Text(text = quote.text,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(bottom = 4.dp))
                }

                Box (modifier = Modifier
                    .height(2.dp)
                    .fillMaxWidth(.4f)
                    .background(Color.Gray))

                if (quote.author.isNotEmpty())
                {
                    Text(text = quote.author,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 4.dp))
                }
            }
        }
    }
}


