package id.jontilo.mytemplate.mvpkotlin.network

import id.jontilo.mytemplate.mvpkotlin.data.remote.MyModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

/**
 * Created by teddy on 4/6/18.
 */
interface ServiceApi {

    companion object {
        val BASE_URL = "https://private-0587b-apisample2.apiary-mock.com/"
    }

    @GET("myapisample")
    fun getDataFromServer(): Observable<MyModel>

}