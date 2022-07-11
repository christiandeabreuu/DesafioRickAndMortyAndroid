package br.com.zup.rickandmorty.ui.detail.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.rickandmorty.*
import br.com.zup.rickandmorty.data.local.entity.CharacterEntity
import br.com.zup.rickandmorty.databinding.ActivityDetalheBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetalheBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalheBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        getCharacterDetail()
    }

    @SuppressLint("SetTextI18n")
    private fun getCharacterDetail() {
        val character = intent.getParcelableExtra<CharacterEntity>(KEY)

        character?.let {
            binding.tvNameDetail.text = NAME + character.name
            binding.tvSpecies.text = SPECIE + character.species
            binding.tvStatus.text = STATUS + character.status
            binding.tvGender.text = GENDER + character.gender
            Picasso.get().load(it.image).into(binding.ivDetailCharacter)

            supportActionBar?.title = it.name
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}