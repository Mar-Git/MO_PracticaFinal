package iesnervion.macal.mo_practicafinal.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import iesnervion.macal.mo_practicafinal.clases.*

class UserVM: ViewModel()  {

    var userModel = MutableLiveData<UserModel>()

    fun  getUserVM (): MutableLiveData<UserModel> {
        if (userModel == null) {
            userModel = MutableLiveData<UserModel>()
        }
        return userModel
    }
}