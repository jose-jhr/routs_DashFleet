package com.ingenieria.rutasdashfleet.firebase.model

import com.google.firebase.database.DatabaseError

interface ActivityContract {

    interface View{
        fun showLoading()
        fun hideLoading()
        fun exceptionData(message: String, positionView: Int)
        fun successRegister()
        fun showErrorDatabase(error: DatabaseError)
    }

    interface Presenter{

    }

}