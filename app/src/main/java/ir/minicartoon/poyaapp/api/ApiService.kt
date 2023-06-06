package ir.minicartoon.poyaapp.api

import ir.minicartoon.poyaapp.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("user.php")
    fun getBestUser(): Call<List<User>>
}