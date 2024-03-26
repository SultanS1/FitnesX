package com.fitless.core

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow


abstract class BaseReducer<STATE : BaseState, SE : BaseSideEffect> {

    abstract val initialState: STATE

    private val _sideEffect = MutableSharedFlow<BaseSideEffect>()
    val sideEffect: SharedFlow<BaseSideEffect> get() = _sideEffect

    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<STATE> get() = _state

    protected fun postAction(currentState: (currentState: STATE) -> STATE) {
        _state.value = currentState(_state.value)
    }

    protected fun postSideEffect(sideEffect: BaseSideEffect) {
        _sideEffect.tryEmit(sideEffect)
    }

    abstract fun handleAction(action: BaseAction)

}
