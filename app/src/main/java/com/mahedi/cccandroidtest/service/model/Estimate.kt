package com.mahedi.cccandroidtest.service.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "estimate")
data class Estimate (
	@PrimaryKey	@SerializedName("id") val id : String,
	@SerializedName("company") val company : String,
	@SerializedName("address") val address : String,
	@SerializedName("number") val number : Int,
	@SerializedName("revision_number") val revision_number : Int,
	@SerializedName("created_date") val created_date : String,
	@SerializedName("created_by") val created_by : String,
	@SerializedName("requested_by") val requested_by : String,
	@SerializedName("contact") val contact : String
)