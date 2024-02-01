package com.example.reciclerviewcomposeexample

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ReciclerViewPhotos() {
    val context  = LocalContext.current
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(getPhotoList()) {
            ItemPhoto(photo = it) { Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show() }
        }
    }
}


@Composable
fun ItemPhoto(photo: Photos, onItemSelected: (Photos) -> Unit) {
    Card(
        border = BorderStroke(4.dp, color = Color.Black),
        modifier = Modifier
            .width(300.dp)
            .clickable {
                onItemSelected(photo)
            }) {
        Column() {
            Image(
                painter = painterResource(id = photo.photo),
                contentDescription = "Photo",
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = photo.name,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}


fun getPhotoList(): List<Photos> {
    return listOf(
        Photos("Bruno", R.drawable.bruno1),
        Photos("Marina", R.drawable.marina1),
        Photos("Todos", R.drawable.todos1),
        Photos("Bruno", R.drawable.bruno1),
        Photos("Marina", R.drawable.marina1),
        Photos("Todos", R.drawable.todos1),
        Photos("Bruno", R.drawable.bruno1),
        Photos("Marina", R.drawable.marina1),
        Photos("Todos", R.drawable.todos1)

    )
}