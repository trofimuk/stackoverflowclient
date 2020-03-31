package com.sofclient.base

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.sofclient.R

/**
 * Base fragment
 */
abstract class BaseFragment : Fragment(){
    lateinit var progressBar: AlertDialog

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createProgressBar()
        initUi()
    }

    /**
     * Sets view listeners
     */
    abstract fun setListeners()

    /**
     * Init user cases view
     */
    abstract fun initUi()

    protected fun displayProgressbar(loading: Boolean){
        if (loading) {
            progressBar.show()
        } else {
            progressBar.dismiss()
        }
    }

    private fun createProgressBar() {
        val dialogLayout = layoutInflater.inflate(R.layout.dialog_progressbar, null)
        progressBar = AlertDialog.Builder(context)
            .setView(dialogLayout)
            .setCancelable(false)
            .create()
        progressBar.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    protected fun displayError(message: String?){
        val errorDialog = AlertDialog.Builder(context)
            .setTitle(getString(R.string.text_error))
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton(android.R.string.yes) { dialog, _ ->
                dialog.dismiss()
            }
            .create()
        errorDialog.show()
    }
}