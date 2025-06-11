package com.example.giphytetsapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.giphytetsapp.domain.model.GiphyItem
import kotlinx.coroutines.flow.Flow

@Composable
fun HomeScreen(giphyList: Flow<PagingData<GiphyItem>>){
    val lazyGiphyItems: LazyPagingItems<GiphyItem> = giphyList.collectAsLazyPagingItems()

    LazyColumn {
        items(lazyGiphyItems.itemCount){ index ->
            GiphyItem(
                image = lazyGiphyItems[index]?.url ?: "",
                description = "IMAGE"
            )
        }
    }
}

@Composable
fun GiphyItem(image: String, description: String){
    Box(
        modifier = Modifier
            .height(300.dp)
            .width(160.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(image)
                .crossfade(true)
                .build(),
            contentDescription = "Gif image"
        )
        Text(
            modifier = Modifier,
            text = description
        )
    }
}