package com.fitless.core

interface AppModuleDependencies<T> {
    fun provideRouter(): CustomRouter<T>
}