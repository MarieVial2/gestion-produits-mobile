package com.example.marieproduct.view

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.marieproduct.data.Product

//La fonction retourne Unit pour dire que ça retourne rien (void en java)
@Composable
fun HomeScreen (product: Product?, navigateToForm: (productName: String) -> Unit, navigateToApi: () -> Unit){
    Scaffold() { innerPadding ->
        Column (modifier = Modifier.padding(innerPadding)) {
            Button(onClick = {
                navigateToForm("Test")
            }) {
                Text("Naviguer vers le formulaire")
            }
            Button(onClick = {
                navigateToApi()
            }) {
                Text("Naviguer vers l'API")
            }


            Text(text= "${product?.name ?: "Pas de données"} - ${product?.country ?: "Pas de données"}")
            //Text(text= product?.name ?: "Pas de données")
            //ou
            //Text("${product.name ?: "aucun produit"}")

            /* ou :
            if(product?.id != null) {
                Text(text = product.id.toString())
            }
             */



        }
    }



}