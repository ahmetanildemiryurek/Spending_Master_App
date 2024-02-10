package com.example.spendingmaster.ui.listExpense

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.spendingmaster.R
import com.example.spendingmaster.data.model.ExpenseListResponse

//androide özgü işlemleri classlara bağımlı kalmadan kullanmak için bunu parametre olarak verdik (toast msg. gibi vb.)
class ExpenseListFragmentAdapter: RecyclerView.Adapter<ExpenseListFragmentAdapter.ExpenseListFragmentViewHolder>() {

    class ExpenseListFragmentViewHolder(view: View): RecyclerView.ViewHolder(view)


    private val differCallback = object : DiffUtil.ItemCallback<ExpenseListResponse.Expense>(){
        override fun areItemsTheSame(
            oldItem: ExpenseListResponse.Expense,
            newItem: ExpenseListResponse.Expense
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ExpenseListResponse.Expense,
            newItem: ExpenseListResponse.Expense
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseListFragmentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.expense_design, parent, false)
        return ExpenseListFragmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseListFragmentViewHolder, position: Int) {
        val listItem = differ.currentList[position]
        holder.itemView.apply {
            findViewById<TextView>(R.id.expenseNumber).text = listItem.number.toString()
            findViewById<TextView>(R.id.expenseName).text = listItem.name
            findViewById<TextView>(R.id.expensePrice).text = listItem.price.toString()
            findViewById<TextView>(R.id.currencyType).text = listItem.currencyType

            setOnClickListener {
                onItemClickListener?.invoke(listItem.id.toString())
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((String) -> Unit)? = null

    fun setOnItemClickListener(listener: (String) -> Unit) {
        onItemClickListener = listener
    }
}