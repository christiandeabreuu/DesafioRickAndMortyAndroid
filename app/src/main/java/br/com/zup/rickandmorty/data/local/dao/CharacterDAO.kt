package br.com.zup.rickandmorty.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import br.com.zup.rickandmorty.data.local.entity.CharacterEntity

@Dao
interface CharacterDAO {
    @Query("Select * From character_entity")
    fun getAll(): LiveData<List<CharacterEntity>>

    @Query("Select * From character_entity WHERE favorite = 1")
    fun getAllFavorites(): LiveData<List<CharacterEntity>>

    @Update
    fun update(characterEntity: CharacterEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(characterResult: List<CharacterEntity>)
}
