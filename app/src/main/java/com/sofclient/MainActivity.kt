package com.sofclient

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.sofclient.base.BaseActivity


class MainActivity : BaseActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.container)
    }
}
