package com.example.spendingmaster.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

// Room veritabanı için Expense entity sınıfımız
@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val expensesId: Long = 0,
    val expenseDetails: String,
    val expensePrice: Double,
    val currencyType: String,
    // val currencyCode: String // Para birimi kodu
)
