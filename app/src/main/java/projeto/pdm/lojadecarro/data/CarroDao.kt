package projeto.pdm.lojadecarro.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CarroDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCarro (carro: Carro)

    @Query("SELECT * FROM carro_tbl ORDER BY id ASC")
    fun getAllCarros(): LiveData<List<Carro>>

    @Update
    suspend fun updateCarro(carro: Carro)
}