package id.jontilo.mytemplate.mvpkotlin.mvp

import id.gits.sariroti.base.BaseView
import id.jontilo.mytemplate.mvpkotlin.data.remote.MyModel

/**
 * Created by teddy on 4/6/18.
 */
interface MainView {

    fun successGetFromServer(myModel: MyModel)
    fun errorGetFromServer(error: String)
}