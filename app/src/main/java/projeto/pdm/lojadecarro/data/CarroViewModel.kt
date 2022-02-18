package projeto.pdm.lojadecarro.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CarroViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Carro>>
    private val repository: CarroRepo
    init {
        val carDao = CarroDatabase.getDatabase(application).carroDao()
        repository = CarroRepo(carDao)
        readAllData = repository.readAllData
    }

    fun addCar(carro: Carro){
        viewModelScope.launch(Dispatchers.IO){
            repository.addCarro(carro)
        }
    }
    fun updateCarro(carro: Carro){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateCarro(carro)
        }
    }

}