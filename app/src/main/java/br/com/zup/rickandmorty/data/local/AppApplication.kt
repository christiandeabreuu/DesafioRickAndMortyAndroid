package br.com.zup.rickandmorty.data.local

import android.app.Application
import androidx.room.Room
import br.com.zup.rickandmorty.data.local.database.CharacterDatabase

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            CharacterDatabase::class.java, "database-character"
        )
            .fallbackToDestructiveMigration()
            .build()

    }

    companion object {
        private lateinit var db: CharacterDatabase
        fun getDB(): CharacterDatabase {
            return db
        }
    }
}