package com.example.pamprak5.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Preview(showBackground = true)
@Composable
fun Mainscreen(
    modifier: Modifier=Modifier
){

    var nama by rememberSaveable { mutableStateOf("")}
    var email by remember { mutableStateOf("")}
    var alamat by remember { mutableStateOf("")}
    var noHP by remember { mutableStateOf("")}
    var selectedGender by remember { mutableStateOf("")}

    var jenisKelamin = listOf("Laki-laki", "Perempuan")

    var namaUser by rememberSaveable { mutableStateOf("")}
    var emailUser by remember { mutableStateOf("")}
    var alamatUser by remember { mutableStateOf("")}
    var noHPUser by remember { mutableStateOf("")}
    var selectedGenderUser by remember { mutableStateOf("")}

    Column (
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){

        OutlinedTextField(value = nama,
            onValueChange = {nama = it},
            placeholder = { Text("Masukan nama")},
            label = { Text("Nama")},
            modifier= modifier
                .fillMaxWidth()
                .padding(5.dp))

        OutlinedTextField(value = email,
            onValueChange = {email = it},
            placeholder = { Text("Masukan Email")},
            label = { Text("Email")},
            modifier= modifier
                .fillMaxWidth()
                .padding(5.dp))

        OutlinedTextField(value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Masukan alamat")},
            label = { Text("Alamat")},
            modifier= modifier
                .fillMaxWidth()
                .padding(5.dp))

        OutlinedTextField(value = noHP,
            onValueChange = {noHP = it},
            placeholder = { Text("Masukan noHP")},
            label = { Text("noHP")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier= modifier
                .fillMaxWidth()
                .padding(5.dp))

        Row() {
            jenisKelamin.forEach{item ->
                Row (verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = selectedGender==item, onClick =
                    {
                        selectedGender=item
                    })
                    Text(text = item)
                }
            }
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Simpan")
        }

        Card (modifier.size(height = 400.dp, width = 500.dp) ) {
            CardSection(judulParam = "Nama", isiParam = namaUser)
            CardSection(judulParam = "Email", isiParam = emailUser)
            CardSection(judulParam = "Alamat", isiParam = alamatUser)
            CardSection(judulParam = "NoHP", isiParam = noHPUser)
            CardSection(judulParam = "Kelamin", isiParam = selectedGenderUser)
        }

    }
}


@Composable
fun CardSection(judulParam: String, isiParam: String){
    Column(modifier = Modifier.padding(10.dp)) {

        Spacer(modifier = Modifier.padding(8.dp))
        Row (modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = judulParam, modifier = Modifier.weight(0.8f))
            Text(text = ":")
            Text(text = isiParam, modifier = Modifier.weight(2f))
        }
    }
}
