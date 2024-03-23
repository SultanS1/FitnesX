package com.fitless.core


interface BaseReducer<S: BaseState, A: BaseAction> {

    fun reduce(currentState: S, action: A): BaseState

//    // Initial state provided by subclasses
//    abstract val initialState: STATE
//
//    // Private mutable state flow for managing the state
//    private val _state = MutableStateFlow(initialState)
//
//    // Public state flow for observing the state
//    val state: StateFlow<STATE>
//        get() = _state
//
//    // Private mutable shared flow for emitting side effects
//    private val _sideEffect = MutableSharedFlow<SE>()
//
//    // Public shared flow for observing side effects
//    val sideEffect: SharedFlow<SE>
//        get() = _sideEffect
//
//    // Function to handle incoming actions
//    suspend fun handleAction(action: ACTION) {
//        // Process the action and update the state
//        val newState = reduce(_state.value, action)
//        _state.value = newState
//
//        // Emit any side effects produced during state processing
//        emitSideEffects(newState)
//    }
//
//    // Abstract function to define how to reduce state based on action
//    abstract fun reduce(currentState: STATE, action: ACTION): STATE
//
//    // Function to emit side effects based on the current state
//    private suspend fun emitSideEffects(state: STATE) {
//        val sideEffects = getSideEffectsForState(state)
//        sideEffects.forEach { _sideEffect.emit(it) }
//    }
//
//    // Abstract function to retrieve side effects based on the current state
//    abstract suspend fun getSideEffectsForState(state: STATE): List<SE>
}