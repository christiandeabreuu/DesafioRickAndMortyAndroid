package br.com.zup.rickandmorty.ui.home.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.rickandmorty.data.local.entity.CharacterEntity
import br.com.zup.rickandmorty.databinding.LayoutRmBinding
import com.squareup.picasso.Picasso

class HomeAdapter(
    private var listRM: MutableList<CharacterEntity>,
    private val clickCharacter: (characterEntity: CharacterEntity) -> Unit
) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutRmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listRM[position]
        holder.showInfo(item)
        holder.binding.cvItem.setOnClickListener {
            clickCharacter(item)
        }
    }

    override fun getItemCount() = listRM.size

    fun updateListCharacter(newList: MutableList<CharacterEntity>) {
        listRM = newList
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: LayoutRmBinding) : RecyclerView.ViewHolder(binding.root) {

        fun showInfo(characterResult: CharacterEntity) {
            binding.tvCharacterName.text = characterResult.name
            Picasso.get().load(characterResult.image)
                .into(binding.ivCharacterImg)

        }
    }
}