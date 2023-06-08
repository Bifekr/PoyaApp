package ir.minicartoon.poyaapp.home

import androidx.lifecycle.LiveData
import ir.minicartoon.poyaapp.model.Codes
import ir.minicartoon.poyaapp.model.Cource
import ir.minicartoon.poyaapp.model.User

class HomeRepository {

    private val homeApiClient = HomeApiClient()
    fun getBestUser(): LiveData<List<User>> {
        return homeApiClient.getUsers()
    }

    fun getBestCourse(): LiveData<List<Cource>> {
        return homeApiClient.getBestCourse()
    }

    fun getCodes(): LiveData<List<Codes>> {
        return homeApiClient.getCodes()
    }
}
