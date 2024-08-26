package com.example.endangeredanimals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.endangeredanimals.data.DataSource
import com.example.endangeredanimals.model.Animal
import com.example.endangeredanimals.ui.theme.CatskillWhite
import com.example.endangeredanimals.ui.theme.EndangeredAnimalsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EndangeredAnimalsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        AnimalsList(DataSource().getAnimalsList(),Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun AnimalsList(animals: List<Animal>, modifier: Modifier) {
    LazyColumn {
        items(animals){
            AnimalListItem(animal = it)
        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun AnimalsListPreview() {
}

@Composable
fun AnimalListItem(animal: Animal, modifier: Modifier = Modifier) {

    Card(
        colors = CardDefaults.cardColors(containerColor = CatskillWhite),
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = animal.picture), contentDescription = stringResource(
                    id = animal.name
                ),
                modifier = modifier.size(120.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .height(120.dp)

            ) {
                Text(
                    text = stringResource(id = animal.name),
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .weight(1f) // to take the rest of area
                        .wrapContentHeight()
                )
                Text(
                    buildAnnotatedString {
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                            append(
                                text = stringResource(
                                    id = R.string.save_the_animal,
                                    stringResource(id = R.string.save), "", ""
                                )
                            )
                        }
                        append(
                            stringResource(
                                id = R.string.save_the_animal,
                                "",
                                stringResource(id = R.string.the_animal),
                                ""
                            )
                        )
                    },
                )
            }
        }
    }

}