package ir.minicartoon.poyaapp.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ir.minicartoon.poyaapp.api.ApiClient
import ir.minicartoon.poyaapp.api.ApiService
import ir.minicartoon.poyaapp.model.Codes
import ir.minicartoon.poyaapp.model.Cource
import ir.minicartoon.poyaapp.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeApiClient {

    private val apiService: ApiService = ApiClient.instance().create(ApiService::class.java)


    fun getUsers(): MutableLiveData<List<User>> {
        val mutableLivedata = MutableLiveData<List<User>>()
        apiService.getBestUser().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                mutableLivedata.value = (response.body()!!)
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

                Log.i("tag", t.toString())

            }
        })

        return mutableLivedata
    }

    fun getBestCourse(): MutableLiveData<List<Cource>> {

        val getCourseMutableLiveData = MutableLiveData<List<Cource>>()

        apiService.getCourse().enqueue(object : Callback<List<Cource>> {
            override fun onResponse(call: Call<List<Cource>>, response: Response<List<Cource>>) {
                getCourseMutableLiveData.value = (response.body()!!)
            }

            override fun onFailure(call: Call<List<Cource>>, t: Throwable) {
                Log.i("tag", t.toString())
            }


        })
        return getCourseMutableLiveData

    }

    fun getCodes(): MutableLiveData<List<Codes>> {
        val codesMutable = MutableLiveData<List<Codes>>()
        apiService.getCodes().enqueue(object : Callback<List<Codes>> {
            override fun onFailure(call: Call<List<Codes>>, t: Throwable) {
                //  Toast.makeText(context,"خطای ناشناخته",Toast.LENGTH_SHORT).show()
                Log.i("LOG", t.toString())
            }

            override fun onResponse(call: Call<List<Codes>>, response: Response<List<Codes>>) {
                codesMutable.value = response.body()
            }

        })

        return codesMutable
    }
}