package iesnervion.macal.mo_practicafinal.viewModels

import androidx.lifecycle.MutableLiveData
import iesnervion.macal.mo_practicafinal.clases.*

class UserVM {

    val userModel = MutableLiveData<User>()

    fun getUserVM (position:Int){

        val currentUser = UserProvider.userList.get(position)
        userModel.postValue(currentUser)
    }
}