package com.mahedi.cccandroidtest.service.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "person")
data class Person (
	@PrimaryKey @SerializedName("id") val id : String,
	@SerializedName("first_name") val first_name : String,
	@SerializedName("last_name") val last_name : String,
	@SerializedName("email") val email : String,
	@SerializedName("phone_number") val phone_number : String
)