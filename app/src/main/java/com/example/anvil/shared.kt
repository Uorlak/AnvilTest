package com.example.anvil

import com.squareup.anvil.annotations.ContributesSubcomponent
import com.squareup.anvil.annotations.ContributesTo
import javax.inject.Scope
import kotlin.reflect.KClass

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class SingleIn(val scope: KClass<*>)

abstract class ZeroScope private constructor()
abstract class FirstScope private constructor()
abstract class SecondScope private constructor()

@ContributesSubcomponent(
    scope = FirstScope::class,
    parentScope = ZeroScope::class
)
@SingleIn(FirstScope::class)
interface FirstSubcomponent {

    @ContributesTo(ZeroScope::class)
    interface ParentComponent {
        fun firstSubcomponent(): FirstSubcomponent
    }
}

@ContributesSubcomponent(
    scope = SecondScope::class,
    parentScope = FirstScope::class
)
@SingleIn(SecondScope::class)
interface SecondSubcomponent {

    @ContributesTo(FirstScope::class)
    interface ParentComponent {
        fun secondSubcomponent(): SecondSubcomponent
    }
}
