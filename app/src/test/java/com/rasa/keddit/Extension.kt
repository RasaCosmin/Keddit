package com.rasa.keddit

import org.mockito.Mockito

/**
 * Created by cosmi on 26-Nov-17.
 */
inline fun <reified T : Any> mock(): T = Mockito.mock(T::class.java)