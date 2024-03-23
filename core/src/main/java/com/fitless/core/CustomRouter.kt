package com.fitless.core

interface CustomRouter<T> {

    fun navigateTo(screen: T)

    fun pop()

    fun replace(screen: T)

}
