package com.fitless.core

/**Provides CustomRouter implementation that is inside app module to feature modules*/
interface RouterProvider<T> {
    fun provideRouter(): CustomRouter<T>
}