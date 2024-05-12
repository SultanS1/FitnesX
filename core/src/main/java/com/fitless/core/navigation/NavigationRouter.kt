package com.fitless.core.navigation

/**CustomRouter interface defines a contract for routing navigation within an application.
 * It provides methods to navigate to, pop, and replace screens or destinations within the application.*/
interface NavigationRouter<T> {

    /**
     * Navigates to the specified screen or destination.
     * @param screen The screen or destination to navigate to.
     */
    fun navigateTo(screen: T)

    /**
     * Pops the top screen or destination from the navigation stack.
     * This action typically navigates back to the previous screen or closes the current screen.
     */
    fun pop()

    /**
     * Replaces the current screen or destination with the specified screen or destination.
     * @param screen The screen or destination to replace the current one with.
     */
    fun replace(screen: T)

}
