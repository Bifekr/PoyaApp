package ir.minicartoon.poyaapp.api

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {
        private var baseUrl: String = "http://192.168.1.6/poyaPhp/"
        private var retrofit: Retrofit? = null

        fun instance(): Retrofit {
            if (retrofit == null) {

                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
    }
}
