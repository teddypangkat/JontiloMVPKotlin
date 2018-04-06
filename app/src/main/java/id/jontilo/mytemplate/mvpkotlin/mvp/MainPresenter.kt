package id.jontilo.mytemplate.mvpkotlin.mvp

import id.gits.sariroti.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by teddy on 4/6/18.
 */

class MainPresenter(view: MainView) : BasePresenter<MainView>() {

    init {
        super.attachView(view)
    }


    fun callDataToAPi() {
        addSubscribe(serviceApi!!.getDataFromServer()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { response ->
                            view!!.successGetFromServer(response)

                        },

                        { error ->
                            view!!.errorGetFromServer(error.message!!)

                        }

                ))
    }


}
