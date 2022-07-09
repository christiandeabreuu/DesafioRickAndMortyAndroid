package br.com.zup.rickandmorty

import android.app.Application
import androidx.room.Room
import br.com.zup.rickandmorty.data.local.database.CharacterDataBase

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            CharacterDataBase::class.java, "database-character"
        ).build()
    }

    companion object {
        private lateinit var db: CharacterDataBase
        fun getDB(): CharacterDataBase {
            return db
        }
    }
}