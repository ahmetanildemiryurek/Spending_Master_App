package com.example.spendingmaster.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ExpenseListResponse(
    @Json(name = "expenses")
    val expenses: List<Expense>
) {
    @JsonClass(generateAdapter = true)
    data class Expense(
        @Json(name = "id")
        val id: Long = 0,
        @Json(name = "number")
        val number: Int = 0,
        @Json(name = "name")
        val name: String,
        @Json(name = "price")
        val price: Double,
        @Json(name = "currencyType")
        val currencyType: String,
        @Json(name = "currencyName")
        val currencyName: String? = null
    )
}

