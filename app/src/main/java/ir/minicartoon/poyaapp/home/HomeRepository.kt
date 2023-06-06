package ir.minicartoon.poyaapp.home

import androidx.lifecycle.LiveData
import ir.minicartoon.poyaapp.model.User

class HomeRepository {

    private val homeApiClient = HomeApiClient()
    fun getBestUser(): LiveData<List<User>> {
        return homeApiClient.getUsers()
    }
}