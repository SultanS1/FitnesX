package com.fitless.core.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.fitless.core.architecture.BaseAction
import com.fitless.core.architecture.BaseReducer
import com.fitless.core.architecture.BaseSideEffect
import com.fitless.core.architecture.BaseState
import kotlinx.coroutines.launch


/**
 * Abstract base class for implementing Fragments in an MVI architecture.
 * Fragments derived from this class are responsible for rendering UI based on the current state,
 * and for reacting to user actions by submitting corresponding actions to the associated reducer.
 *
 * @param State The type representing the state of the fragment's associated feature or component.
 * @param Action The type representing actions that can trigger state changes.
 * @param Binding The type representing the ViewBinding associated with the fragment's layout.
 * @property layoutId The resource ID of the fragment's layout.
 * @property binding The ViewBinding instance associated with the fragment's layout.
 * @property reducer The reducer responsible for managing the state of the fragment.
 */
abstract class BaseFragment<State : BaseState, Action : BaseAction, SE: BaseSideEffect, Binding : ViewBinding>(layoutId: Int) : Fragment(layoutId) {

	/**
	 * Abstract property representing the ViewBinding associated with the fragment's layout.
	 */
	abstract val binding: Binding

	/**
	 * Abstract property representing the reducer associated with the fragment.
	 * The reducer is responsible for managing the state of the fragment.
	 */
	abstract val reducer: BaseReducer<State, Action, SE>

	/**
	 * Abstract function for rendering the UI based on the current state.
	 * Subclasses must implement this function to update the UI based on changes in the state.
	 * @param state The current state of the fragment's associated feature or component.
	 */
	abstract fun render(state: State)

	/**
	 * Called when the fragment's view is created.
	 * Subclasses should override this function to perform any necessary setup after the view is created.
	 */
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewLifecycleOwner.lifecycleScope.launch {
			lifecycleScope.launchWhenStarted {
				reducer.state.collect { state ->
					render(state)
				}
			}
		}
	}

}