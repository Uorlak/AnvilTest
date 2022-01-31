package com.example.anvil

import android.app.Application
import com.squareup.anvil.annotations.ContributesSubcomponent
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import dagger.Component

abstract class GroundScope private constructor()

@MergeComponent(GroundScope::class)
@SingleIn(GroundScope::class)
interface GroundAppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): GroundAppComponent
    }
}

@ContributesSubcomponent(
    scope = ZeroScope::class,
    parentScope = GroundScope::class
)
@SingleIn(ZeroScope::class)
interface ZeroSubcomponent {

    @ContributesTo(GroundScope::class)
    interface ParentComponent {
        fun zeroSubcomponent(): ZeroSubcomponent
    }
}
