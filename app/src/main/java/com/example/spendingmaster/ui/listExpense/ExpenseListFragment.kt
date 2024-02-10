package com.example.spendingmaster.ui.listExpense

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.spendingmaster.base.BaseFragment
import com.example.spendingmaster.data.model.ExpenseListResponse
import com.example.spendingmaster.databinding.FragmentExpenseListBinding
import com.example.spendingmaster.domain.usecase.UseCaseState
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ExpenseListFragment :
    BaseFragment<FragmentExpenseListBinding>(FragmentExpenseListBinding::inflate) {

    private val viewModel: ExpenseListViewModel by viewModels()

    private fun setupAdapter() {
        binding.expenseListCardView.adapter = expenseListAdapter
        expenseListAdapter.setOnItemClickListener {
            val navigation = ExpenseListFragmentDirections.actionExpenseListFragmentToExpenseDetailsFragment(it.toInt())
            findNavController().navigate(navigation)
        }
    }

    private val expenseListAdapter by lazy {
        ExpenseListFragmentAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }

    override fun setupUI(savedInstanceState: Bundle?) {
        setupAdapter()
        viewModel.listLiveData.observe(this) {
            handleExpenseList(it)
        }
        viewModel.getExpenseListUseCaseState()
    }


    private fun handleExpenseList(status: UseCaseState<ExpenseListResponse>) {
        when (status) {
            is UseCaseState.Error -> {
                // close the loading view
            }
            is UseCaseState.Success -> {
                expenseListAdapter.differ.submitList(status.data?.expenses)
            }
            else -> {
                // close the loading view
            }
        }
    }
}