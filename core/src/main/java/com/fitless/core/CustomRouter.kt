package com.fitless.core

/**CustomRouter interface defines a contract for routing navigation within an application.
 * It provides methods to navigate to, pop, and replace screens or destinations within the application.*/
interface CustomRouter<T> {

    fun navigateTo(screen: T)

    fun pop()

    fun replace(screen: T)

}
