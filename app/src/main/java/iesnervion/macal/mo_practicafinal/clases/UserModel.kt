package iesnervion.macal.mo_practicafinal.clases

import android.text.Editable

class UserModel {
    val email: Editable?
        get() {
            return email
        }

    companion object{
        val user =
            User(
                "Usuario",
                "De Prueba",
                "",
                "usu",
                "123"
            )
    }
}