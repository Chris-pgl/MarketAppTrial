package com.example.recyclerviewtrial

import android.view.View

interface ItemClickListener {

    fun onClick(v: View, position: Int)
}