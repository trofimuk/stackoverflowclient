package com.sofclient.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData

/**
 * Base fragment
 */
abstract class BaseFragment : Fragment(){
    /**
     * Returns layout id
     */
    @LayoutRes
    abstract fun getLayoutId(): Int

    /**
     * Init view
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    /**
     * Sets view listeners
     */
    abstract fun setListeners()

    /**
     * Init user cases view
     */
    abstract fun initUi()
}