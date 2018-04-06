package id.jontilo.mytemplate.mvpkotlin.mvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import id.gits.sariroti.base.BaseActivity
import id.gits.sariroti.base.BasePresenter
import id.jontilo.mytemplate.mvpkotlin.R
import id.jontilo.mytemplate.mvpkotlin.data.remote.MyModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>(), MainView {


    override fun successGetFromServer(myModel: MyModel) {
        toastMessage("GET DATA SUKSES")
        txtStatus.text = myModel.menu.value
    }

    override fun errorGetFromServer(error: String) {
        toastMessage("GET DATA ERROR")
        txtStatus.text = error

    }

    override val initPresenter: MainPresenter
        get() = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView(R.layout.activity_main)
        presenter!!.callDataToAPi()
    }
}
