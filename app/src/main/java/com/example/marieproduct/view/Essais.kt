package com.example.marieproduct.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.marieproduct.R
import com.example.marieproduct.ui.theme.MarieProductTheme

@Composable
fun Essais(name: String, modifier: Modifier = Modifier) {
    var test by remember{ mutableStateOf(0)}
    var firstName by remember { mutableStateOf("essai") }
    Column (modifier = modifier){
        Text(
            text = "Valeur de la variable : ${test}!",

            )

        TextField(
            value = firstName,
            onValueChange = { value ->
                firstName=value
            }
        )

        Image (
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Icone de l'application"
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                test += 1
            },
            content = {
                Text("Incrémenter la variable", modifier = Modifier.padding(30.dp))
            }
        )
    }
}



