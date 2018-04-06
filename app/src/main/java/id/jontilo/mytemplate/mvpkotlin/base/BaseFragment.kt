package id.gits.sariroti.base

import android.app.ProgressDialog
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast


/**
 * Created by irfanirawansukirman on 26/03/18.
 */
abstract class BaseFragment<P : BasePresenter<*>> : Fragment() {

    protected open var presenter: P? = null

    protected abstract val initPresenter: P

    lateinit var activity: AppCompatActivity

    lateinit var progressDialog: ProgressDialog

    var mToast: Toast? = null

    //==============================================================================================

    override fun onDestroy() {
        super.onDestroy()
        if (presenter != null) {
            presenter!!.dettachView()
        }
    }

    fun bindView(inflater: LayoutInflater, containre: ViewGroup, layoutId: Int): View {

        val view = inflater.inflate(layoutId, containre, false)


        presenter = initPresenter

        activity = getActivity() as AppCompatActivity

        initTools()

        return view

    }

    protected fun toastMessage(message: String) {
        if (mToast != null) mToast?.cancel()
        mToast = Toast.makeText(activity, message, Toast.LENGTH_SHORT)
        mToast?.show()
    }


    private fun initTools() {
        progressDialog = ProgressDialog(activity)
        progressDialog.setCanceledOnTouchOutside(false)
//        progressDialog.setCancelable(false)
    }

    fun showProgressDialog(message: String) {
        progressDialog.setMessage(message)
        progressDialog.show()
    }

    fun hideProgressDialog() {
        progressDialog.dismiss()
    }
}