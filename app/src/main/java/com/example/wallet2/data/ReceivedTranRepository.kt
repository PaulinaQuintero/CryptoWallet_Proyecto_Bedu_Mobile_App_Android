package com.example.wallet2.data

import androidx.lifecycle.LiveData
import com.example.wallet2.data.models.ReceivedTran
import kotlinx.coroutines.*

class ReceivedTranRepository(
    private val recivedTranDao: ReceivedTranDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun removeReceivedTran(receivedTran: ReceivedTran) {
        coroutineScope {
            launch{recivedTranDao.removeReceivedTran(receivedTran)}
        }
    }

    fun getReceivedTrans(): LiveData<List<ReceivedTran>> {
        return recivedTranDao.getReceivedTrans()
    }

    suspend fun populateReceivedTrans(receivedTrans: List<ReceivedTran>) = withContext(ioDispatcher) {
        return@withContext recivedTranDao.insertAll(receivedTrans)
    }
}