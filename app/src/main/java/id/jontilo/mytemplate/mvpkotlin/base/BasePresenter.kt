package id.gits.sariroti.base

import id.jontilo.mytemplate.mvpkotlin.network.ApiClient
import id.jontilo.mytemplate.mvpkotlin.network.ServiceApi
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by irfanirawansukirman on 13/01/18.
 */

open class BasePresenter<V> {

    protected var view: V? = null

    var compositeDisposable: CompositeDisposable? = null
    var serviceApi : ServiceApi? = null

    //==============================================================================================

    /**
     * When this fun attached, do init view and create instance api service.
     *
     * @param view app
     */
    fun attachView(view: V) {
        this.view = view
        serviceApi = ApiClient.request().create(ServiceApi::class.java)
    }

    /**
     * This fun for clearing view and all subscribe when app destroyed
     */
    fun dettachView() {
        this.view = view

        clearSubscribe()
    }

    /**
     * Register subscribe in app
     *
     * @param disposable
     */
    fun addSubscribe(disposable: Disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = CompositeDisposable()

            compositeDisposable!!.add(disposable)
        }
    }


    /**
     * Clear all subscribers active in app
     */
    fun clearSubscribe() {
        if (compositeDisposable != null) {
            compositeDisposable!!.clear()
        }
    }
}