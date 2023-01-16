package com.ingenieria.rutasdashfleet

import android.content.Context
import android.graphics.Color
import cn.pedant.SweetAlert.SweetAlertDialog

class SweetAlertFactory {

    fun createLoadingDialog(context: Context): SweetAlertDialog {
        val pDialog = SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE)
        pDialog.progressHelper.barColor = Color.parseColor("#A5DC86")
        pDialog.titleText = "Loading"
        pDialog.setCancelable(false)
        return pDialog
    }

    fun createSuccessDialog(context: Context): SweetAlertDialog {
        val pDialog = SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
        pDialog.titleText = "Operación exitosa"
        pDialog.contentText = "Continuar"
        pDialog.confirmText = "Ok"
        return pDialog
    }
}