package com.lnsantos.brainup.foundation.ui.options

sealed class ModalOptions<T> {
    object Hidden : ModalOptions<Unit>()
    object FirstCreate: ModalOptions<Unit>()
    object Create : ModalOptions<Unit>()

    data class Options<T>(val data: T) : ModalOptions<T>()
    data class Edit<T>(val data: T) : ModalOptions<T>()
}