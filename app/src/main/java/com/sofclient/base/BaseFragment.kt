package com.sofclient.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData

/**
 * Base fragment with [mViewModel]
 */
abstract class BaseFragment<T, V: BaseViewModel<T>>: Fragment(){
    lateinit var mViewModel: V

    protected lateinit var data: LiveData<T>

    /**
     * Returns layout id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    /**
     * Create fragment with init viewModel
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = getViewModel()
    }

    /**
     * Init view
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    /**
     * Returns viewModel instance
     */
    abstract fun getViewModel(): V

    /**
     * Sets view listeners
     */
    abstract fun setListeners()

    /**
     * Init user cases view
     */
    abstract fun initUi()
}