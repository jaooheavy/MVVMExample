package com.example.myapplication

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var dialog: ProgressDialog

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    /*private val adapter: MainAdapter by lazy {
        MainAdapter()
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dialog = ProgressDialog(this)

        /*with(rvList){
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }*/

        Get.setOnClickListener {
            dialog.show()
            loadCEP()
        }

        viewModel.getCharacters().observe(this, {
            dialog.dismiss()
            Get.text = it.cep
        })

    }

    private fun loadCEP(){
        viewModel.load()
    }
}