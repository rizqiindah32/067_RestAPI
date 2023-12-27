package com.example.praktikum8.ui.home.viewmodel

import android.net.http.HttpException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.praktikum8.model.Kontak
import com.example.praktikum8.repository.KontakRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed class KontakUIState{
    data class Success(val kontak: List<Kontak>) : KontakUIState()
    object Error : KontakUIState()
    object Loading : KontakUIState()
}

class HomeViewModel(private val kontakRepository: KontakRepository) : ViewModel() {
    var kontakUIState: KontakUIState by mutableStateOf(KontakUIState.Loading)
        private set

    init {
        getKontak()
    }

    fun getKontak(){
        viewModelScope.launch {
            kontakUIState = try {
                KontakUIState.Success(kontakRepository.getKontak())
            } catch (e: IOException){
                KontakUIState.Error
            } catch (e: IOException){
                KontakUIState.Error
            }
        }
    }

    fun deleteKontak(id: Int){
        viewModelScope.Launch{
            try {
                kontakRepository.deleteKontak(id)
            } catch (e: IOException){
                KontakUIState.Error
            } catch (e: HttpException){
                KontakUIState.Error
            }
        }
    }
}