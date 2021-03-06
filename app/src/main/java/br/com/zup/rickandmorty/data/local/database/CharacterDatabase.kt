package br.com.zup.rickandmorty.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.zup.rickandmorty.data.local.dao.CharacterDAO
import br.com.zup.rickandmorty.data.local.entity.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 4)
abstract class CharacterDatabase : RoomDatabase() {

    abstract fun characterDAO(): CharacterDAO

}