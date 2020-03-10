package com.sofclient.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Base viewModel with support
 * [CompositeDisposable] and [MutableLiveData]
 */
abstract class BaseViewModel : ViewModel() {

    protected var disposables: CompositeDisposable = CompositeDisposable()

    /**
     * Sets view listeners
     */
    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

    /**
     * Add instance disposable to scope
     */
    operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
        disposables.add(disposable)
    }
}