package projeto.pdm.lojadecarro.viweModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import projeto.pdm.lojadecarro.data.Carro
import projeto.pdm.lojadecarro.repository.CarroRemoteRepository

class CarroRemoteViewModel (private val repository: CarroRemoteRepository) : ViewModel() {

    val myResponse: MutableLiveData<List<Carro>> = MutableLiveData()

    fun getCarro() {
        viewModelScope.launch(Dispatchers.IO) {
            viewModelScope.launch {
                val response: List<Carro> = repository.getCarro()
                myResponse.value = response
            }
        }
    }

}