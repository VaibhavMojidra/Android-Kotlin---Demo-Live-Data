package com.vaibhavmojidra.livedatademokotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.vaibhavmojidra.livedatademokotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding:ActivityMainBinding
    private lateinit var viewModelFactory: MainActivityViewModelFactory
    private  lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModelFactory= MainActivityViewModelFactory(3)
        viewModel=ViewModelProvider(this,viewModelFactory).get(MainActivityViewModel::class.java)
        viewModel.totalCount.observe(this, {
          activityMainBinding.result.text=it.toString()
        })
        activityMainBinding.apply {
            addButton.setOnClickListener {
                viewModel.getUpdateCount(Integer.parseInt(numberTextBox.text.toString()))
            }
        }
    }
}