package projeto.pdm.lojadecarro.viweModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import projeto.pdm.lojadecarro.repository.CarroRemoteRepository

class MainViewModelFactory(private val repository: CarroRemoteRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CarroRemoteViewModel(repository) as T
    }
}