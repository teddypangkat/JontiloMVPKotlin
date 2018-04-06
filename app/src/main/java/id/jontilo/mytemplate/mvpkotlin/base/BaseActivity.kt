package id.gits.sariroti.base

import android.app.ProgressDialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import dmax.dialog.SpotsDialog


/**
 * Created by irfanirawansukirman on 13/01/18.
 */

abstract class BaseActivity<P : BasePresenter<*>> : AppCompatActivity() {

    protected open var presenter: P? = null

    protected abstract val initPresenter: P

    lateinit var activity: AppCompatActivity


    lateinit var dialog: SpotsDialog

    var mToast: Toast? = null

    //==============================================================================================

    /**
     * custom font
     * */
//    override fun attachBaseContext(newBase: Context?) {
//        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
//    }

    override fun onDestroy() {
        super.onDestroy()
        if (presenter != null) {
            presenter!!.dettachView()
        }
    }

    protected fun bindView(layoutId: Int) {
        setContentView(layoutId)
        presenter = initPresenter

        activity = this

        initTools()
    }

    protected fun toastMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }


    private fun initTools() {

//        progressDialog = ProgressDialog(activity)
        dialog = SpotsDialog(activity)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)
    }

    fun showProgressDialog(message: String) {
        dialog.setTitle(message)
        dialog.show()
    }

    fun hideProgressDialog() {
        dialog.dismiss()
    }
}