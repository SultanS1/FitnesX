package com.fitless.core.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.fitless.core.architecture.BaseAction
import com.fitless.core.architecture.BaseReducer
import com.fitless.core.architecture.BaseState
import kotlinx.coroutines.launch


abstract class BaseFragment<State : BaseState, Action : BaseAction , Binding : ViewBinding>(layoutId: Int) : Fragment(layoutId) {

	abstract val binding: Binding

	abstract val reducer: BaseReducer<State, Action>

	abstract fun render(state: State)

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