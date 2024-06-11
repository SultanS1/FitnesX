package com.fitless.core.architecture

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
/**
 * Base class for implementing reducers in an MVI architecture.
 * Reducers are responsible for managing the state of an application or a component
 * by processing actions and updating the state accordingly.
 *
 * @param STATE The type representing the state of the application or component.
 * @param Action The type representing actions that can trigger state changes.
 * @property initialState The initial state of the application or component.
 */
abstract class BaseReducer<STATE : BaseState, Action : BaseAction, SE: BaseSideEffect>(private val initialState: STATE) : ViewModel() {
	
	private val coroutineScope =
		CoroutineScope(Dispatchers.Main.immediate + SupervisorJob() + CoroutineExceptionHandler { coroutineContext, throwable ->
			println(throwable.message)
		})
	
	private val _sideEffect = MutableSharedFlow<SE>()
	val sideEffect: SharedFlow<SE> get() = _sideEffect
	
	private val _state = MutableStateFlow(initialState)
	val state: StateFlow<STATE> get() = _state
	
	val stateValue get() = state.value

	/**
	 * Abstract function to submit an action to the reducer.
	 * Implementations of this function should handle the action and update the state accordingly.
	 * @param action The action to be processed.
	 */
	abstract fun submitAction(action: Action)

	/**
	 * Posts a new state to the reducer.
	 * This function allows subclasses to update the state by providing a lambda function
	 * that calculates the new state based on the current state.
	 * @param currentState Lambda function that computes the new state based on the current state.
	 */
	protected fun postState(currentState: (currentState: STATE) -> STATE) {
		_state.value = currentState(state.value)
	}

	/**
	 * Posts a new side effect to the reducer.
	 * Side effects represent asynchronous events or actions triggered by state changes.
	 * @param sideEffect The side effect to be emitted.
	 */
	protected fun postSideEffect(sideEffect: SE) {
		launch {
			_sideEffect.tryEmit(sideEffect)
		}
	}

	/**
	 * Launches a coroutine within the coroutine scope of the reducer.
	 * This function simplifies the process of launching coroutines and ensures
	 * proper handling of coroutine lifecycles.
	 * @param operation The suspending function to be executed within the coroutine.
	 */
	protected fun launch(operation: suspend () -> Unit) = coroutineScope.launch {
		operation()
	}

	override fun onCleared() {
		super.onCleared()
		coroutineScope.cancel()
	}
	
}
