package ir.minicartoon.poyaapp.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ir.minicartoon.poyaapp.model.Codes
import ir.minicartoon.poyaapp.model.Cource
import ir.minicartoon.poyaapp.model.User

class HomeViewModel : ViewModel() {
    private val homeRepository = HomeRepository();
    fun getBestUser(): LiveData<List<User>> {
        return homeRepository.getBestUser();
    }

    fun getBestCourse(): LiveData<List<Cource>> {
        return homeRepository.getBestCourse();
    }

    fun getCodes(): LiveData<List<Codes>> {
        return homeRepository.getCodes()
    }
}