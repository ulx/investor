package ru.sberbank.network

import androidx.annotation.NonNull
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.mock.BehaviorDelegate
import retrofit2.mock.MockRetrofit

import retrofit2.mock.NetworkBehavior
import java.util.concurrent.TimeUnit


class Api(private var baseUrl: String = "", interceptors: List<Interceptor> = emptyList()) {

    private lateinit var api : InvestorService
    private lateinit var apiMock : InvestorService
    private val client : OkHttpClient

    init {
       val okHttpClient = OkHttpClient().newBuilder()
        interceptors.forEach{
            okHttpClient.addInterceptor(it)
        }
        if(BuildConfig.DEBUG) {
            okHttpClient.addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }
        client = okHttpClient.build()
        setRetrofit()
    }

    @NonNull
    fun getServiceApi(isMock : Boolean = false) : InvestorService {
       return if (isMock) {
            apiMock
        } else {
            api
        }
    }
    private fun setRetrofit() {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(client)
            .build()
       api = retrofit.create(InvestorService::class.java)

        initMock(retrofit)
    }

    private fun initMock(retrofit: Retrofit) {
        //TODO :  переодически может возвращать ошибки, поправить задежку и процент ошибок
        val behavior = NetworkBehavior.create()
        behavior.setDelay(500, TimeUnit.MILLISECONDS);
        val mockRetrofit = MockRetrofit.Builder(retrofit)
            .networkBehavior(behavior)
            .build()

        val delegate: BehaviorDelegate<InvestorService> = mockRetrofit.create(InvestorService::class.java)
        apiMock = InvestorServiceMock(delegate)
    }

}