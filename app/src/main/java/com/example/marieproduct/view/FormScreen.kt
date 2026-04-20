package com.example.marieproduct.view

import android.R.attr.enabled
import android.R.attr.label
import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.marieproduct.R
import com.example.marieproduct.ui.theme.MarieProductTheme
import kotlinx.coroutines.selects.select

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen() {

    var productName by remember { mutableStateOf("") }
    var country by remember { mutableStateOf("") }
    var selectedOption by remember { mutableStateOf("")}
    var checked by remember { mutableStateOf(false)}


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Formulaire") }
            )
        },
        content = { padding ->

            Column(

                modifier = Modifier.padding(padding).padding(32.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = productName,
                    onValueChange =  { productName = it },
                    label = { Text("Nom du produit")}
                )

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = country,
                    onValueChange =  { country = it },
                    label = { Text("Pays d'origine")}
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (selectedOption == "Consommable"),
                            onClick = { selectedOption = "Consommable" },
                        )
                        Text(
                            text = "Consommable"
                        )
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (selectedOption == "Durable"),
                            onClick = { selectedOption = "Durable" }
                        )
                        Text(
                            text = "Durable"
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = (selectedOption == "Autre"),
                            onClick = { selectedOption = "Autre" }
                        )
                        Text(
                            text = "Autre"
                        )
                    }
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checked,
                        onCheckedChange = { checked = it }
                    )
                    Text(
                        text = "A ajouter aux favoris"
                    )
                }
                Button(
                    onClick = {

                    },
                    content = {
                        Text("Ajouter produit", modifier = Modifier.padding(15.dp))
                    }
                )

            }
        }
    )
}



@Preview
@Composable
fun FormScreenPreview() {
    MarieProductTheme {
        FormScreen()
    }
}