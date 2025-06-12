package com.example.giphytetsapp.ui.home_screen

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.example.giphytetsapp.domain.model.giphy_list.GiphyItemList
import kotlinx.coroutines.flow.Flow


@Composable
fun HomeScreen(
    giphyList: Flow<PagingData<GiphyItemList>>,
    onClickListingItem: (String) -> Unit,
) {
    val listGiphyItems: LazyPagingItems<GiphyItemList> = giphyList.collectAsLazyPagingItems()
    val lazyGridState = rememberLazyStaggeredGridState()

    LazyVerticalStaggeredGrid(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .navigationBarsPadding(),
        columns = StaggeredGridCells.Fixed(2),
        state = lazyGridState,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        items(listGiphyItems.itemCount) { index ->
            GiphyItem(
                modifier = Modifier
                    .clickable {
                        onClickListingItem(listGiphyItems[index]?.id ?: "")
                    },
                image = listGiphyItems[index]?.images?.fixedWidth?.url ?: ""
            )
        }
    }
}

@Composable
fun GiphyItem(
    modifier: Modifier = Modifier, image: String,
) {
    Box(
        modifier = modifier.then(modifier)
            .height(200.dp)
            .fillMaxWidth()
    ) {
        GiphyImage(modifier = modifier, image = image)
    }
}

@Composable
fun GiphyImage(modifier: Modifier = Modifier, image: String) {
    val painter = rememberAsyncImagePainter(image)
    val state = painter.state
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    Image(
        modifier = Modifier.then(modifier)
            .fillMaxSize(),
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current)
                .data(image)
                .crossfade(true)
                .build(),
            imageLoader = imageLoader,
            contentScale = ContentScale.Crop,
        ),
        contentDescription = "Gif image"
    )
}
