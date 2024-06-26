package com.main.appmycityrmv.ui

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.main.appmycityrmv.data.local.Datasource
import com.main.appmycityrmv.data.model.Recommendation
import com.main.appmycityrmv.ui.theme.AppMyCityRMVTheme

@Composable
fun RecommendationInfoScreen(
    modifier: Modifier = Modifier,
    contentType: ContentType = ContentType.LIST,
    recommendation: Recommendation? = Datasource.recommendations.first(),
    onNavigateUp: () -> Unit = {}
) {
    if (contentType == ContentType.LIST) {
        BackHandler {
            onNavigateUp()
        }
    }
    recommendation?.let {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                painter = painterResource(id = it.image),
                contentDescription = it.title,
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(vertical = 16.dp)) {
                Text(
                    text = it.title,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = it.description,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun RecommendationInfoScreenPreview() {
    AppMyCityRMVTheme {
        Surface {
            RecommendationInfoScreen()
        }
    }
}