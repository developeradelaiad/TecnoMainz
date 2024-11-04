package com.example.tecnomainz.client

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface ClientDao {
    @Upsert
    fun upsertClient(client:ClientData)
    @Query("SELECT * FROM client")
    fun getClient():LiveData<List<ClientData>>
    @Delete
    fun deleteClient(client:ClientData)
    @Query("DELETE FROM client")
    fun deleteAllClient()
}