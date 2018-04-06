package id.jontilo.mytemplate.mvpkotlin.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by teddy on 4/6/18.
 */

class ApiClient {


    companion object {
        var mRetrofit: Retrofit? = null
        fun request(): Retrofit {
            if (mRetrofit == null) {
                val loggingInterceptor = HttpLoggingInterceptor()
                loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY


                val client = OkHttpClient.Builder()
                        .addInterceptor(loggingInterceptor) //  todo for debug
                        .readTimeout(300, TimeUnit.SECONDS)
                        .connectTimeout(300, TimeUnit.SECONDS)
                        .build()

                mRetrofit = Retrofit.Builder()
                        .baseUrl(ServiceApi.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(client)
                        .build()
            }
            return mRetrofit!!
        }
    }


}
