package com.example.giphytetsapp.ui.home_screen

import android.os.Build.VERSION.SDK_INT
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.example.giphytetsapp.R
import com.example.giphytetsapp.data.network.ConnectivityManager
import com.example.giphytetsapp.domain.model.giphy_list.GiphyItemList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow


@Composable
fun HomeScreen(
    connectivityManagerState: SharedFlow<Boolean>,
    giphyList: Flow<PagingData<GiphyItemList>>,
    onClickListingItem: (String) -> Unit,
) {
    val listGiphyItems: LazyPagingItems<GiphyItemList> = giphyList.collectAsLazyPagingItems()
    val lazyGridState = rememberLazyStaggeredGridState()
    val connectivityManager = connectivityManagerState.collectAsStateWithLifecycle(true)
    val connectivity = connectivityManager.value
    val context = LocalContext.current

    LaunchedEffect(connectivity) {
        if (connectivity == false) {
            Toast.makeText(
                context,
                context.getString(R.string.wrong_connection),
                Toast.LENGTH_LONG
            ).show()
        } else {
            listGiphyItems.refresh()
        }
    }

    when (listGiphyItems.loadState.refresh) {
        is LoadState.Error -> {
            Toast.makeText(
                context,
                context.getString(R.string.wrong_connection),
                Toast.LENGTH_LONG
            ).show()
        }

        LoadState.Loading -> {
            Loader()
        }

        else -> {
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
                        image = listGiphyItems[index]?.images?.fixedWidth?.url,
                        onItemClick = {
                            onClickListingItem(it)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun GiphyItem(
    modifier: Modifier = Modifier,
    image: String?,
    onItemClick: (String) -> Unit,
) {
    if (image == null) return
    Box(
        modifier = Modifier
            .then(modifier)
            .height(200.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(image)
            }
    ) {
        GiphyImage(image = image)
    }
}

@Composable
fun GiphyImage(modifier: Modifier = Modifier, image: String) {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    Image(
        modifier = Modifier
            .then(modifier)
            .fillMaxSize(),
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(context)
                .data(image)
                .crossfade(true)
                .build(),
            imageLoader = imageLoader,
            contentScale = ContentScale.Crop,
        ),
        contentDescription = null
    )
}

@Composable
fun Loader(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .then(modifier)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}
