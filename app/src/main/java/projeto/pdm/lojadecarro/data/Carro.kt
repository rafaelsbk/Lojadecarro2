package projeto.pdm.lojadecarro.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity (tableName = "carro_tbl")
data class Carro(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val marca: String,
    val modelo: String,
    val tipoCar: String,
    val cor: String,
    val ano: Int
    ): Parcelable