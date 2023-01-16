package com.ingenieria.rutasdashfleet

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import cn.pedant.SweetAlert.SweetAlertDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.ingenieria.rutasdashfleet.firebase.model.ActivityContract
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private lateinit var pDialog: SweetAlertDialog
    private val factory = SweetAlertFactory()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //color bar notification
        window.statusBarColor = resources.getColor(R.color.color_app)
        startActivity(Intent(this@MainActivity,MainRoutes::class.java))


        btn_login.setOnClickListener {

            val activityPresenter = ActivityPresenter(this,edt_celular.text.toString(),edt_clave.text.toString(),object :ActivityContract.View{
                override fun showLoading() {
                    pDialog = factory.createLoadingDialog(this@MainActivity)
                    pDialog.show()
                }

                override fun hideLoading() {
                    if (pDialog!=null){
                        pDialog.dismiss()
                    }

                }

                override fun exceptionData(message: String, positionView: Int) {
                    when(positionView){
                        0->edt_celular.error = message
                        1->edt_clave.error = message
                    }
                }

                override fun successRegister() {
                    pDialog = factory.createSuccessDialog(this@MainActivity)
                    pDialog.show()
                    pDialog.setOnDismissListener {
                        startActivity(Intent(this@MainActivity,MainRoutes::class.java))
                    }

                }

                override fun showErrorDatabase(error: DatabaseError) {
                    Toast.makeText(this@MainActivity, "${error.message}", Toast.LENGTH_SHORT).show()
                }

            })

            activityPresenter.valideData()

        }
        

    






    }


}