package com.fitless.core.architecture

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseReducer<STATE : BaseState, Action : BaseAction>(private val initialState: STATE) :
	ViewModel() {
	
	private val coroutineScope =
		CoroutineScope(Dispatchers.Main.immediate + SupervisorJob() + CoroutineExceptionHandler { coroutineContext, throwable ->
			println(throwable.message)
		})
	
	private val _sideEffect = MutableSharedFlow<BaseSideEffect>()
	val sideEffect: SharedFlow<BaseSideEffect> get() = _sideEffect
	
	private val _state = MutableStateFlow(initialState)
	val state: StateFlow<STATE> get() = _state
	
	val stateValue get() = state.value
	
	protected fun postState(currentState: (currentState: STATE) -> STATE) {
		_state.value = currentState(state.value)
	}
	
	protected fun postSideEffect(sideEffect: BaseSideEffect) {
		_sideEffect.tryEmit(sideEffect)
	}
	
	abstract fun submitAction(action: Action)
	
	fun launch(operation: suspend () -> Unit) = coroutineScope.launch {
		operation()
	}
	
}
