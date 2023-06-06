package ir.minicartoon.poyaapp.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ir.minicartoon.poyaapp.model.User

class HomeViewModel : ViewModel() {
    private val homeRepository = HomeRepository();
    fun getBestUser(): LiveData<List<User>> {
        return homeRepository.getBestUser();
    }
}