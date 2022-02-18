package projeto.pdm.lojadecarro.data

import androidx.lifecycle.LiveData

class CarroRepo(private val carroDao: CarroDao) {


    val readAllData: LiveData<List<Carro>> = carroDao.getAllCarros()

    suspend fun addCarro(carro: List<Carro>){
        carroDao.addCarro(carro)
    }

    suspend fun addCarroRemote (carro: List<Carro>){
        carroDao.insertRemote(carro)
    }

    suspend fun updateCarro(carro: Carro){
        carroDao.updateCarro(carro)
    }
}