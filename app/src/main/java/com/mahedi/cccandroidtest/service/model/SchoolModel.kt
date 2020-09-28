package com.mahedi.cccandroidtest.service.model

import com.google.gson.annotations.SerializedName


data class SchoolModel (
    @SerializedName("estimate") val estimate : Estimate,
    @SerializedName("person") val person : Person
)