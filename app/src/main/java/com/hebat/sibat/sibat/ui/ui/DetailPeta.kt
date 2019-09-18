package com.hebat.sibat.sibat.ui.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hebat.sibat.sibat.R

class DetailPeta : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_peta)

        val actionBar = supportActionBar
        actionBar!!.title = "Detail Peta"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
