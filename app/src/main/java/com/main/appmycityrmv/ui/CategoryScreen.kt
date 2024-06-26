package com.main.appmycityrmv.ui

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.main.appmycityrmv.data.local.Datasource
import com.main.appmycityrmv.data.model.Recommendation
import com.main.appmycityrmv.ui.theme.AppMyCityRMVTheme

@Composable
fun CategoryScreen(
    modifier: Modifier = Modifier,
    recommendations: List<Recommendation> = Datasource.recommendations,
    onItemClicked: (Recommendation) -> Unit = {},
) {
    LazyColumn(
        modifier = modifier.padding(6.dp)
    ) {
        items(recommendations) {
            RecommendationListItem(recommendation = it, onItemClicked = onItemClicked)
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CategoryScreenPreview() {
    AppMyCityRMVTheme {
        Surface {
            CategoryScreen()
        }
    }
}

// (2) Recommendation list item: Card (clickable for navigation)
@OptIn(ExperimentalMaterialApi::class)
@Preview(showBackground = true)
@Composable
fun RecommendationListItem(
    modifier: Modifier = Modifier,
    recommendation: Recommendation = Datasource.recommendations.first(),
    onItemClicked: (Recommendation) -> Unit = {},
) {
    Card(
        onClick = { onItemClicked(recommendation) },
        modifier = modifier.padding(2.dp),
        elevation = 2.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = recommendation.image),
                contentDescription = recommendation.description,
                modifier = Modifier
                    .width(100.dp)
                    .height(75.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(4.dp)
            ) {
                Text(
                    text = recommendation.title,
                    modifier = Modifier.padding(horizontal = 4.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.body1
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = recommendation.description,
                    modifier = Modifier.padding(horizontal = 4.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}