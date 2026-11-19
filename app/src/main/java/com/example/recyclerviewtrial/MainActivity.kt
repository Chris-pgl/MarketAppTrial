package com.example.recyclerviewtrial

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // 1- AdaoterView
    lateinit var recyclerView: RecyclerView

    // 2- Data Source
    lateinit var itemList : ArrayList<Item>

    // 3- Adapter
    lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val i1 = Item(R.drawable.fruit,"Fruits","Fresh Fruits from the Garden")
        val i2 = Item(R.drawable.vegitables,"Vegetables","Delicious Vegetables")
        val i3 = Item(R.drawable.bread,"Bakery","Fresh Bread and Beans")
        val i4 = Item(R.drawable.beverage,"Beverage","Juice, Tea, Coffee and Soda")
        val i5 = Item(R.drawable.milk,"Milk","Milk, Shakes and Yogurt")
        val i6 = Item(R.drawable.popcorn,"Snacks","Popcorn, Chips and Donut")


        itemList = ArrayList()

        itemList.add(i1)
        itemList.add(i2)
        itemList.add(i3)
        itemList.add(i4)
        itemList.add(i5)
        itemList.add(i6)

        adapter = MyAdapter(itemList)
        recyclerView.adapter = adapter

        adapter.setClickListener(object : ItemClickListener {
            override fun onClick(v: View, position: Int) {
                val item = itemList[position]
                Toast.makeText(this@MainActivity, "You choose: "+ item.title, Toast.LENGTH_SHORT).show()
            }
        })
    }
}