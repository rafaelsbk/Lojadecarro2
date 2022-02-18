package projeto.pdm.lojadecarro.data

import androidx.lifecycle.LiveData

class CarroRepo(private val carroDao: CarroDao) {


    val readAllData: LiveData<List<Carro>> = carroDao.getAllCarros()

    suspend fun addCarro(carro: Carro){
        carroDao.addCarro(carro)
    }

    suspend fun updateCarro(carro: Carro){
        carroDao.updateCarro(carro)
    }
}