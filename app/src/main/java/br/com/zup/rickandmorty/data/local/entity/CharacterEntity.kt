package br.com.zup.rickandmorty.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "character_entity")
data class CharacterEntity(
    @PrimaryKey
    var id: Int,
    var image: String,
    var species: String,
    var status: String,
    var gender: String,
    var name: String,
    var favorite: Boolean
): Parcelable
