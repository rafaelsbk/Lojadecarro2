package projeto.pdm.lojadecarro.api

import projeto.pdm.lojadecarro.data.Carro
import retrofit2.http.GET

interface SimpleApi {

    @GET("/api/v1/car/")
    suspend fun getPost() : List<Carro>

}