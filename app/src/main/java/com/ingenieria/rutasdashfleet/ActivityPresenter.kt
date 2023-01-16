package com.ingenieria.rutasdashfleet

import android.content.Context
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.ingenieria.rutasdashfleet.firebase.FirebaseQuery
import com.ingenieria.rutasdashfleet.firebase.model.ActivityContract
import com.ingenieria.rutasdashfleet.firebase.model.OnSearchCompleteQuery

class ActivityPresenter(val context: Context,val phone:String, val clave:String,private val view: ActivityContract.View) {

    private val rootRef = FirebaseDatabase.getInstance().reference
    private val userRef = rootRef.child("users")
    private val onSearchCompleteQuery = FirebaseQuery()
    private val sharedPreferences = UserPreferences(context)

    fun valideData(){
        view.showLoading()
        val runnable = Runnable {
            val valueDataError = valideAttrib()
            if (!valueDataError){
                val numberCellQuery = userRef.orderByChild("number").equalTo(phone.toDouble())
                val callbackNumberCell:(DataSnapshot?)->Unit={snapshot->
                    if (snapshot != null){
                        var claveChild = ""
                        var numberChild = ""
                        for (childSnapShot in snapshot.children){
                            claveChild = childSnapShot.child("key").value.toString()
                            numberChild = childSnapShot.child("number").value.toString()
                        }
                        //asumiendo que los numeros de celular no se puedan repetir
                        view.hideLoading()
                        if (clave==claveChild){
                            view.successRegister()
                            saveUser(numberChild,clave)
                        }else{
                            view.exceptionData("clave erronea",1)
                        }
                    }else{
                        view.exceptionData("Celular no encontrado",0)
                    }
                }
                querySend(numberCellQuery,callbackNumberCell)
            }
        }
        val handler = android.os.Handler()
        handler.postDelayed(runnable,1000)

    }

    private fun saveUser(numberCell: String, clave: String) {
        sharedPreferences.phone = numberCell
        sharedPreferences.key = clave
    }

    private fun valideAttrib(): Boolean {
        var error = false
        if (phone.isEmpty()){
            error = true
            view.exceptionData("Falta celular",0)
        }

        if (clave.isEmpty()){
            error = true
            view.exceptionData("Falta clave",1)
        }

        return error
    }


    private fun querySend(query: Query, callback: (DataSnapshot?) -> Unit){
        onSearchCompleteQuery.search(query,object :OnSearchCompleteQuery{
            override fun onSuccess(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    callback(snapshot)
                }else{
                    callback(null)
                }
            }

            override fun error(error: DatabaseError) {
                view.showErrorDatabase(error)
            }

        })
    }


}