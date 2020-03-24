package ru.sberbank.network

import androidx.annotation.NonNull
import okhttp3.CertificatePinner
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.mock.BehaviorDelegate
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior
import ru.sberbank.network.api.InvestorService
import ru.sberbank.network.api.InvestorServiceExecutor
import ru.sberbank.network.api.InvestorServiceMock
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSession


class Api(private var baseUrl: String = "", interceptors: List<Interceptor> = emptyList()) {

    private lateinit var apiMock: InvestorServiceMock
    private lateinit var apiRest: InvestorService
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

        //TODO временное решение пока не сделаем проверку для ssl pinning
        okHttpClient.hostnameVerifier(object : HostnameVerifier {
            override fun verify(p0: String?, p1: SSLSession?): Boolean {
                return true
            }

        })
        // TODO добавление сертификатов, но это не помогло
        val certificatePinner = CertificatePinner.Builder()
            .add("185.157.97.135", "sha256/dVayQSamPa7XBbai2q3WzHYuBYBW98e77bKf6y2vWWc=")
            .add("web-si20.sberbank.ru", "sha256/dVayQSamPa7XBbai2q3WzHYuBYBW98e77bKf6y2vWWc=")
            .add("auth-si20.sberbank.ru", "sha256/dVayQSamPa7XBbai2q3WzHYuBYBW98e77bKf6y2vWWc=")
            .build()

        client = okHttpClient
            .certificatePinner(certificatePinner)
            .build()
        setRetrofit()
    }

    @NonNull
    fun getServiceApi(isMock : Boolean = false) : InvestorServiceExecutor {
       return InvestorServiceExecutor(
           isMock = isMock,
           api = apiRest,
           mock = apiMock
       )
    }

    private fun setRetrofit() {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(client)
            .build()
        apiRest = retrofit.create(InvestorService::class.java)
        apiMock = initMock(retrofit)
    }

    private fun initMock(retrofit: Retrofit) : InvestorServiceMock {
        //TODO :  переодически может возвращать ошибки, поправить задежку и процент ошибок
        val behavior = NetworkBehavior.create()
        behavior.setDelay(500, TimeUnit.MILLISECONDS);
        val mockRetrofit = MockRetrofit.Builder(retrofit)
            .networkBehavior(behavior)
            .build()

        val delegate: BehaviorDelegate<InvestorService> = mockRetrofit.create(
            InvestorService::class.java)
        return InvestorServiceMock(delegate)
    }

}