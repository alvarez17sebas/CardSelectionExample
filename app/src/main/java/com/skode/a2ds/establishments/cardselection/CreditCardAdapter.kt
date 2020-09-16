package com.skode.a2ds.establishments.cardselection

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class CreditCardAdapter(var data: MutableList<CreditCart>, var clickItem: ItemClick) :
    RecyclerView.Adapter<CreditCardAdapter.CreditCardViewHolder>() {

    private var selected: Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreditCardViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_creditcard, parent, false)
        return CreditCardViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CreditCardViewHolder, position: Int) {
        val card = data[position]
        holder.bindData(card)
    }

    inner class CreditCardViewHolder(itemView: View) : ViewHolder(itemView) {
        private var tvCreditCardNumber: TextView = itemView.findViewById(R.id.tvCardNumber)
        private var tvAccountHolder: TextView = itemView.findViewById(R.id.tvAccountHolder)
         var cvContainer: CardView = itemView.findViewById(R.id.cvContainer)

        init {
            setClickListeners()
        }

        fun bindData(creditCard: CreditCart) {
            tvCreditCardNumber.text = creditCard.cardNumber
            tvAccountHolder.text = creditCard.accountHolder
            if(selected == layoutPosition){
                cvContainer.setCardBackgroundColor(Color.GREEN)
            }else{
                cvContainer.setCardBackgroundColor(Color.WHITE)
            }
        }

        fun setClickListeners() {
            cvContainer.setOnClickListener {
                clickItem.itemAdapterClick(data[layoutPosition])
                selected = layoutPosition
                notifyDataSetChanged()
            }
        }
    }
}