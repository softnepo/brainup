package com.lnsantos.brainup.foundation.ui.options

sealed class ModalOptions<in T> {
    object Hidden: ModalOptions<Any>()
    object FirstCreate: ModalOptions<Any>()
    object Create : ModalOptions<Any>()

    data class Options<T>(val data: T) : ModalOptions<Any>()
    data class Edit<T>(val data: T) : ModalOptions<Any>()
}