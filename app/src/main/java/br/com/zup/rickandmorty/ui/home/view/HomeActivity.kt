package br.com.zup.rickandmorty.ui.home.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import br.com.zup.rickandmorty.databinding.ActivityHomeBinding
import br.com.zup.rickandmorty.ui.home.view.adapter.HomeAdapter
import br.com.zup.rickandmorty.ui.home.viewmodel.HomeViewModel
import br.com.zup.rickandmorty.ui.viewstate.ViewState

class HomeActivity : AppCompatActivity() {
    private val adapter: HomeAdapter by lazy {
        HomeAdapter(mutableListOf())

    }
    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvImage.adapter = adapter
        binding.rvImage.layoutManager = GridLayoutManager(this, 2)
        viewModel.getAllCharacters()
        initObserver()
    }

    private fun initObserver() {
        viewModel.characterListState.observe(this) {
            when (it) {
                is ViewState.Sucess -> {
                    adapter.updateListCharacter(it.data as MutableList)

                }
            }
        }
    }
}