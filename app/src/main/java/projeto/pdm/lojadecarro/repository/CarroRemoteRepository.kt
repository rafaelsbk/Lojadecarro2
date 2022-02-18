package projeto.pdm.lojadecarro.repository

import projeto.pdm.lojadecarro.api.RetrofitInstance
import projeto.pdm.lojadecarro.data.Carro

class CarroRemoteRepository {
    suspend fun getCarro() : List<Carro> {
        return RetrofitInstance.api.getPost()
    }
}