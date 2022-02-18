package projeto.pdm.lojadecarro.api

import projeto.pdm.lojadecarro.data.Carro
import projeto.pdm.lojadecarro.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SimpleApi {

    @GET("/api/v1/car/")
    suspend fun getPost() : List<Carro>

    companion object{
        private val retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api : SimpleApi by lazy {
            retrofit.create(SimpleApi::class.java)
        }
    }
}