package com.example.dependencyinjectionstart.example2.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dependencyinjectionstart.R
import com.example.dependencyinjectionstart.example2.ExampleApp
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: ExampleViewModel
/* custom builder
 */
//    private val component by lazy {
//        DaggerApplicationComponent.builder()
//            .context(this)
//            .timeMillis(System.currentTimeMillis())
//            .build()
//
//    }
/*
custom factory
 */
//    private val component by lazy {
//        DaggerApplicationComponent.factory()
//            .create(application, System.currentTimeMillis())
//    }

    private val component by lazy {
        (application as ExampleApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.method()
    }
}