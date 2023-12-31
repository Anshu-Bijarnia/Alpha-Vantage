package com.example.alphavantage.marketStatus.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.alphavantage.marketStatus.domain.model.MarketStatus

@Composable
fun MarketStatusItem(
    status: MarketStatus,
    modifier: Modifier = Modifier,
    expand: Boolean = false
) {
    var expanded by remember { mutableStateOf(expand) }
    Card(
        modifier = modifier
            .width(200.dp)
            .padding(4.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.primary)
            .clickable { expanded = !expanded }
            .padding(4.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(text = status.region)
            Text(
                text = status.currentStatus,
                color = if (isClosed(status)) Color.Red else Color.Green
            )
            if (expanded) {
                Text(text = "Regions: ${status.primaryExchange}")
                if (status.notes.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(text = "Notes: ${status.notes}")
                }
            }
        }
    }
}

fun isClosed(status: MarketStatus): Boolean {
    if (status.currentStatus == "closed") {
        return true
    }
    return false
}