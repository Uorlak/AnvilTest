package com.example.anvil

import android.app.Application
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component

@MergeComponent(ZeroScope::class)
@SingleIn(ZeroScope::class)
interface ZeroAppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): ZeroAppComponent
    }
}
