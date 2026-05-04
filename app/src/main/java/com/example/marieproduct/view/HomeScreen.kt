package com.example.marieproduct.view

import android.R
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.marieproduct.data.Product

//La fonction retourne Unit pour dire que ça retourne rien (void en java)
@Composable
fun HomeScreen (products: List<Product>, navigateToForm: (productName: String) -> Unit, navigateToApi: () -> Unit, onDelete: (Product) -> Unit){
    Scaffold() { innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding)
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text("Bienvenue sur MarieProduct" , style = TextStyle(
                color = Color.Blue,
                textDecoration = TextDecoration.Underline,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(

                onClick = {
                navigateToForm("Test")
            }) {
                Text("Naviguer vers le formulaire")
            }
            Button(onClick = {
                navigateToApi()
            }) {
                Text("Naviguer vers l'API")
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text("Produits enregistrés" , style = TextStyle(
                color = Color.Gray,
                textDecoration = TextDecoration.Underline,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            ))


                if(products.isNotEmpty()) {

                    LazyColumn {
                    items(products) { product ->
                        ProductItem(product, products,
                            onDelete = { deletedProduct ->
                                onDelete(deletedProduct)
                            }
                            // ou : onDelete = onDelete
                            //Pour faire correspondre ce onDelete et celle de la signature de HomeScreen
                        )
                    }
                        }
                } else {
                    Text("Il n'y a pas de produits pour le moment")
                }



            //Text(text= "${product?.name ?: "Pas de données"} - ${product?.country ?: "Pas de données"}")
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

@Composable
fun ProductItem(product: Product, productList : List<Product>, onDelete: (Product) -> Unit) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .combinedClickable(
                onClick = {
                    Toast.makeText(
                        context,
                        "Produit: ${product.name}", Toast.LENGTH_SHORT
                    ).show()
                },
                onLongClick = {
                   onDelete(product)
                }
            )
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text(product.name, style = MaterialTheme.typography.titleLarge)
            Text(product.country, style = MaterialTheme.typography.titleMedium)
            Text(product.selectedOption, style = MaterialTheme.typography.labelSmall)
            if (product.favori){
                Text("Produit favori")
            }

        }
    }
}