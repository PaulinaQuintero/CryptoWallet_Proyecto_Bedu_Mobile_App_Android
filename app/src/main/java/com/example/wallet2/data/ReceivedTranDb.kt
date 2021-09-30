package com.example.wallet2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.wallet2.data.models.ReceivedTran

@Database(entities = arrayOf(ReceivedTran::class), version = 2)
abstract class ReceivedTranDb: RoomDatabase() {

    companion object {
        private var databaseInstance: ReceivedTranDb? = null

        const val DB_NAME = "RECEIVED_TRAN_DB"

        fun getInstance(context: Context) : ReceivedTranDb?{
            if(databaseInstance==null){

                synchronized(ReceivedTranDb::class){
                    databaseInstance = Room.databaseBuilder(
                        context.applicationContext,
                        ReceivedTranDb::class.java,
                        DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            return databaseInstance
        }
    }

    abstract fun receivedTranDao(): ReceivedTran
}