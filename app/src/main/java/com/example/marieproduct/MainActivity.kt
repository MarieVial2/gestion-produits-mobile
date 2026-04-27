package com.example.marieproduct

import android.R.attr.content
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.marieproduct.data.Product
import com.example.marieproduct.data.Routes
import com.example.marieproduct.ui.theme.MarieProductTheme
import com.example.marieproduct.view.APIScreen
import com.example.marieproduct.view.FormScreen
import com.example.marieproduct.view.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val a = "Test"
        Log.d("MainActivity", "onCreate Called $a")
        enableEdgeToEdge()
        setContent {

            MarieProductTheme {

                val backStack = remember {
                    mutableStateListOf<Routes>(
                        Routes.Home
                    )
                }

                var savedProduct by remember { mutableStateOf<Product?>(null)}

                // Ceci me permet de lister toutes les directions possibles selon la page. Toutes les pages doivent être répertoriées et les directions de chacune listées à l'aide des fonctions qui les appellent.
                NavDisplay(
                    backStack = backStack,
                    onBack = { backStack.removeLastOrNull() },
                    entryProvider = { key ->
                        when (key) {
                            Routes.Home -> NavEntry(key) {
                                //HomeScreen permet d'accéder à 2 pages : Form et Api
                                HomeScreen(
                                    //ici je peux donner un nom à l'élément à passer en parametre de Form() et qui remplacerait it
                                    //ex: navigateToForm = { productName
                                    product = savedProduct,
                                    navigateToForm = {
                                        backStack.add(Routes.Form(""))
                                    },
                                    navigateToApi = {
                                        backStack.add(Routes.API)
                                    }
                                )
                            }

                            is Routes.Form -> NavEntry(key) {
                                FormScreen(
                                    productName = key.productName,
                                    onValidate = { product ->
                                        savedProduct = product
                                        backStack.removeLastOrNull()
                                    }
                                )
                            }

                            is Routes.API -> NavEntry(key) {
                                APIScreen(

                                    onBack = {
                                        backStack.removeLastOrNull()
                                    }
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}


//Tests de mise en page :
