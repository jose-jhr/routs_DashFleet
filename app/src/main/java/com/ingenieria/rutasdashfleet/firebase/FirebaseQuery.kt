package com.ingenieria.rutasdashfleet.firebase

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener
import com.ingenieria.rutasdashfleet.firebase.model.OnSearchCompleteQuery

class FirebaseQuery {

    fun search(query:Query,listener:OnSearchCompleteQuery){
        query.addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.d("msgLis", snapshot.toString())
                listener.onSuccess(snapshot)
            }
            override fun onCancelled(error: DatabaseError) {
                listener.error(error)
            }

        })
    }

}