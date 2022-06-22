package com.example.homekliring.ui.Auth.Authentication.login

import android.app.Activity
import android.os.Handler
import androidx.appcompat.app.AlertDialog
import com.example.homekliring.R

class LoadingDialog(val activity: Activity) {
    private lateinit var dialog: AlertDialog

    fun startLoading() {
        val inflater = activity.layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_progress_bar, null)
        val builder = AlertDialog.Builder(activity)
        builder.setView(dialogView)
        builder.setCancelable(false)
        dialog = builder.create()
        dialog.show()
    }

    fun isDismiss(){
        dialog.dismiss()
    }
}