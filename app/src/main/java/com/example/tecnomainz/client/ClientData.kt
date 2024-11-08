package com.example.tecnomainz.client

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.sql.Date
import java.sql.Time

@Entity("client")
@Parcelize
class ClientData (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val code:Int,
    val userName:String,
    val total:String,
    val rest:String,
    val paymentDate:String,
    val deliveryName:String,
    val typeOfInsect:String,
    val phoneFirstNumber:String,
    val phoneSecondNumber: String,
    val address:String,
    val details:String,
    val followers:String,
//    val date: Date,
//    val time: Time,
    // TODO: Solve Date and Time Error
): Parcelable