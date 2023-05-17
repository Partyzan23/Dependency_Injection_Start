package com.example.dependencyinjectionstart.example2.di

import com.example.dependencyinjectionstart.example2.presentation.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent
import javax.inject.Named


@Subcomponent(modules = [ViewModelModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)

    @Subcomponent.Factory
    interface Factory{

        fun create(
            @BindsInstance @IdQualifier id: String,
            @BindsInstance @NameQualifier name:String
        ): ActivityComponent
    }
}