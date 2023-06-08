package ir.minicartoon.poyaapp.api

import ir.minicartoon.poyaapp.model.Codes
import ir.minicartoon.poyaapp.model.Cource
import ir.minicartoon.poyaapp.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("user.php")
    fun getBestUser(): Call<List<User>>

    @GET("Course.php")
    fun getCourse(): Call<List<Cource>>

    @GET("codes.php")
    fun getCodes(): Call<List<Codes>>
}