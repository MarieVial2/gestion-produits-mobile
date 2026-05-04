package com.example.marieproduct.view

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.marieproduct.API.RetrofitInstance
import com.example.marieproduct.API.RetrofitInstancePoke
import com.example.marieproduct.data.Pokemon
import kotlinx.coroutines.launch

@Composable
fun PokeAPIScreen () {

    val pokemons = remember { mutableStateListOf<Pokemon>() }
    val scope = rememberCoroutineScope()

    Scaffold { innerPadding ->

        Column(modifier = Modifier.padding(innerPadding)) {

            Button(onClick = {
                scope.launch {
                    try {
                        val list = (1..20).map {
                            RetrofitInstancePoke.api.getPokemon(it)
                        }

                        pokemons.clear()
                        pokemons.addAll(list)

                    } catch (e: Exception) {
                        Log.e("API", "Erreur chargement", e)
                    }
                }
            }) {
                Text("Charger Pokémon")
            }

            LazyColumn {
                items(pokemons) { pokemon ->
                    PokemonItem(pokemon)
                }
            }
        }
    }
}

@Composable
fun PokemonItem(pokemon: Pokemon) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.titleLarge
            )

            Text("Taille : ${pokemon.height}")
            Text("Poids : ${pokemon.weight}")
        }
    }

}