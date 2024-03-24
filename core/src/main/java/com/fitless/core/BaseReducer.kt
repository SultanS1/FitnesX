package com.fitless.core


interface BaseReducer<S: BaseState, A: BaseAction> {

    fun reduce(currentState: S, action: A): BaseState

}