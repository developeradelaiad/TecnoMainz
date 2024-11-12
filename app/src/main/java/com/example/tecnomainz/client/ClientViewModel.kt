package com.example.tecnomainz.client

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class ClientViewModel(app:Application) : AndroidViewModel(app) {

    private val dp = ClientRoom.getDatabase(app)
    fun upsertClient(client:ClientData) = dp.clientDao().upsertClient(client)
    fun getClient( )= dp.clientDao().getClient()
    fun deleteClient(client:ClientData) = dp.clientDao().deleteClient(client)
    fun deleteAllClient() = dp.clientDao().deleteAllClient()
}