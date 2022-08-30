package com.abhishek.jetpackcomposebasic

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abhishek.jetpackcomposebasic.data.datasource.DataSource
import com.abhishek.jetpackcomposebasic.ui.theme.JetpackComposeBasicTheme
import java.util.*

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    JetpackComposeBasicApp()
                }
            }
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {

    TextField(
        value = "", onValueChange = {},
        modifier = modifier
            .heightIn(min = 56.dp)
            .fillMaxWidth(),
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = null)
        },
        placeholder = {
            Text(text = stringResource(id = R.string.placeholder_search))
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        )
    )
}

@Composable
fun AlignYourBody(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(shape = CircleShape)
        )

        Text(
            text = stringResource(id = text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}

@Composable
fun FavouriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {

    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.width(192.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painterResource(id = drawable),
                contentDescription = null,
                modifier = Modifier.size(56.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                stringResource(id = text),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(DataSource.alignYourBodyData) { item ->
            AlignYourBody(
                item.drawable,
                item.text
            )
        }
    }
}

@Composable
fun FavouriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        modifier = modifier.height(120.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(DataSource.favoriteCollectionsData) { item ->
            FavouriteCollectionCard(drawable = item.drawable, text = item.text)
        }
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = stringResource(id = title).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(16.dp)
        )
        content()
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier
            .padding(vertical = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.favorite_collections) {
            FavouriteCollectionsGrid()
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun MyBottomNavigation(
    modifier: Modifier = Modifier
) {
    BottomNavigation(modifier) {
        BottomNavigationItem(selected = true,
            onClick = { },
            icon = { Icon(Icons.Default.Spa, contentDescription = null) },
            label = {
                Text(text = stringResource(id = R.string.bottom_navigation_home))
            }
        )

        BottomNavigationItem(selected = true,
            onClick = { },
            icon = { Icon(Icons.Default.AccountCircle, contentDescription = null) },
            label = {
                Text(text = stringResource(id = R.string.bottom_navigation_profile))
            }
        )
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun JetpackComposeBasicApp() {
    Scaffold(
        bottomBar = { MyBottomNavigation() }
    ) { padding ->
        HomeScreen()
    }
}

@Preview
@Composable
fun SearchBarPreview() {
    JetpackComposeBasicTheme {
        SearchBar()
    }
}

@Preview
@Composable
fun AlignYourBodyPreview() {
    JetpackComposeBasicTheme {
        AlignYourBody(
            R.drawable.ab1_inversions,
            R.string.inversions,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
fun AlignYourBodyRowPreview() {
    JetpackComposeBasicTheme {
        AlignYourBodyRow(

        )
    }
}

@Preview
@Composable
fun FavouriteCollectionCardPreview() {
    JetpackComposeBasicTheme {
        FavouriteCollectionCard(
            R.drawable.fc2_nature_meditations,
            R.string.nature_meditations,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
fun FavouriteCollectionGridPreview() {
    JetpackComposeBasicTheme {
        FavouriteCollectionsGrid(
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
fun HomeSectionPreview() {
    JetpackComposeBasicTheme {
        HomeSection(R.string.align_your_body) {
            AlignYourBodyRow()
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    JetpackComposeBasicTheme {
        HomeScreen()
    }
}

@Preview
@Composable
fun BottomNavigationPreview() {
    JetpackComposeBasicTheme {
        MyBottomNavigation()
    }
}

@Preview
@Composable
fun MyAppPreview() {
    JetpackComposeBasicTheme {
        JetpackComposeBasicApp()
    }
}



