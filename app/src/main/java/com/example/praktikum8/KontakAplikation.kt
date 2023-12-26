package com.example.praktikum8

import android.app.Application
import com.example.praktikum8.repository.AppContainer
import com.example.praktikum8.repository.KontakContainer

class KontakAplikation : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = KontakContainer()
    }
}

