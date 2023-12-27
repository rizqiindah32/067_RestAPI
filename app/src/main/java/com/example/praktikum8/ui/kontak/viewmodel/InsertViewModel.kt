package com.example.praktikum8.ui.kontak.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praktikum8.model.Kontak
import com.example.praktikum8.repository.KontakRepository
import kotlinx.coroutines.launch

class InsertViewModel(private val kontakRepository: KontakRepository): ViewModel() {
    var insertKontakState by mutableStateOf(InsertUiState())
        private set
    fun updateInsertKontakState(insertUiEvent: InsertUiEvent){
        insertKontakState = InsertUiState(insertUiEvent = insertUiEvent)
    }

suspend fun insertKontak(){
        viewModelScope.launch {
            try {
                kontakRepository.insertKontak(insertKontakState.insertUiEvent.toKontak())
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}

data class InsertUiState(
    val insertUiEvent: InsertUiEvent = InsertUiEvent(),
)
data class InsertUiEvent(
    val id: Int = 0,
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = "",
)

fun InsertUiEvent.toKontak(): Kontak = Kontak(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon,
)
fun Kontak.toUiStateKontak(): InsertUiState = InsertUiState(
    insertUiEvent = toInsertUiEvent(),
)

fun Kontak.toInsertUiEvent(): InsertUiEvent = InsertUiEvent(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telpon,
)