package com.example.praktikum8.ui.kontak.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.praktikum8.ui.kontak.viewmodel.InsertUiEvent
import com.example.praktikum8.ui.kontak.viewmodel.InsertUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInputSiswa(
    insertUiState: InsertUiState,
    modifier: Modifier = Modifier,
    onValueChange: (InsertUiEvent)-> Unit = {},
    enable: Boolean = true
){
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){

    }
}
