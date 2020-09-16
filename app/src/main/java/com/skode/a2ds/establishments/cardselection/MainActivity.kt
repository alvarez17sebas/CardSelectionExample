package com.skode.a2ds.establishments.cardselection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemClick {

    private lateinit var adapter: CreditCardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CreditCardAdapter(provideItems(), this)

        setupRecyclerView()
    }

    private fun provideItems(): MutableList<CreditCart> {
        return arrayListOf(
            CreditCart("123-456-789", "Pedro Perez Pedregal"),
            CreditCart("098=765=432", "Raquel Ramirez Rosales"),
            CreditCart("345-234-000", "Zidane Zuleta Zatico")
        )
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }


    override fun itemAdapterClick(card: CreditCart) {
        Toast.makeText(this, card.accountHolder, Toast.LENGTH_SHORT).show()
    }
}