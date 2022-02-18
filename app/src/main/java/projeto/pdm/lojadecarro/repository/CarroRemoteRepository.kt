package projeto.pdm.lojadecarro.repository


import projeto.pdm.lojadecarro.api.SimpleApi
import projeto.pdm.lojadecarro.data.Carro

class CarroRemoteRepository {
    suspend fun getCarro() : List<Carro> {
        return SimpleApi.api.getPost()
    }
}