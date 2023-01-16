package com.ingenieria.rutasdashfleet.firebase.model

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import java.lang.Error

interface OnSearchCompleteQuery {

    fun onSuccess(snapshot: DataSnapshot)
    fun error(error: DatabaseError)

}