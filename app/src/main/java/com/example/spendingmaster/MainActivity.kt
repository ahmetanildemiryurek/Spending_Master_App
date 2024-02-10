package com.example.spendingmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spendingmaster.data.model.ExpenseListResponse
import com.example.spendingmaster.databinding.ActivityMainBinding
import com.example.spendingmaster.ui.listExpense.ExpenseListFragmentAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}