package projeto.pdm.lojadecarro.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Carro::class], version = 1, exportSchema = true)
abstract class CarroDatabase: RoomDatabase() {

    abstract fun carroDao(): CarroDao

    companion object{
        @Volatile
        private var INSTANCE: CarroDatabase? = null


        fun getDatabase(context: Context): CarroDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
               val instance = Room.databaseBuilder(
                   context.applicationContext,
                   CarroDatabase::class.java,
                   "carro_database"
               ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}