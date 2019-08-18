/**
 * Copyright (C) 2016 Hyphenate Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hyphenate.chatuidemo.ui

import android.app.ProgressDialog
import android.content.DialogInterface
import android.content.DialogInterface.OnCancelListener
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import com.hyphenate.EMCallBack
import com.hyphenate.chat.EMClient
import com.hyphenate.chatuidemo.DemoApplication
import com.hyphenate.chatuidemo.DemoHelper
import com.hyphenate.chatuidemo.R
import com.hyphenate.chatuidemo.db.DemoDBManager
import com.hyphenate.easeui.utils.EaseCommonUtils

/**
 * Login screen
 *
 */
class LoginActivity : BaseActivity() {
    private var usernameEditText: EditText? = null
    private var passwordEditText: EditText? = null

    private var progressShow: Boolean = false
    private var autoLogin = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // enter the main activity if already logged in
        if (DemoHelper.getInstance().isLoggedIn) {
            autoLogin = true
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))

            return
        }
        setContentView(R.layout.em_activity_login)
        usernameEditText = findViewById<View>(R.id.username) as EditText
        passwordEditText = findViewById<View>(R.id.password) as EditText

        // if user changed, clear the password
        usernameEditText!!.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                passwordEditText!!.text = null
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable) {

            }
        })

        passwordEditText!!.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE || event.keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_DOWN) {
                login(null)
                true
            } else {
                false
            }
        }

        if (DemoHelper.getInstance().currentUsernName != null) {
            usernameEditText!!.setText(DemoHelper.getInstance().currentUsernName)
        }

        val serviceCheckTV = findViewById<View>(R.id.txt_service_ckeck) as TextView
        serviceCheckTV.paint.flags = Paint.UNDERLINE_TEXT_FLAG

    }

    /**
     * login
     *
     * @param view
     */
    fun login(view: View?) {
        if (!EaseCommonUtils.isNetWorkConnected(this)) {
            Toast.makeText(this, R.string.network_isnot_available, Toast.LENGTH_SHORT).show()
            return
        }
        val currentUsername = usernameEditText!!.text.toString().trim { it <= ' ' }
        val currentPassword = passwordEditText!!.text.toString().trim { it <= ' ' }

        if (TextUtils.isEmpty(currentUsername)) {
            Toast.makeText(this, R.string.User_name_cannot_be_empty, Toast.LENGTH_SHORT).show()
            return
        }
        if (TextUtils.isEmpty(currentPassword)) {
            Toast.makeText(this, R.string.Password_cannot_be_empty, Toast.LENGTH_SHORT).show()
            return
        }

        progressShow = true
        val pd = ProgressDialog(this@LoginActivity)
        pd.setCanceledOnTouchOutside(false)
        pd.setOnCancelListener {
            Log.d(TAG, "EMClient.getInstance().onCancel")
            progressShow = false
        }
        pd.setMessage(getString(R.string.Is_landing))
        pd.show()

        // After logout，the DemoDB may still be accessed due to async callback, so the DemoDB will be re-opened again.
        // close it before login to make sure DemoDB not overlap
        DemoDBManager.getInstance().closeDB()

        // reset current user name before login
        DemoHelper.getInstance().setCurrentUserName(currentUsername)

        val start = System.currentTimeMillis()
        // call login method
        Log.d(TAG, "EMClient.getInstance().login")
        EMClient.getInstance().login(currentUsername, currentPassword, object : EMCallBack {

            override fun onSuccess() {
                Log.d(TAG, "login: onSuccess")


                // ** manually load all local groups and conversation
                EMClient.getInstance().groupManager().loadAllGroups()
                EMClient.getInstance().chatManager().loadAllConversations()

                // update current user's display name for APNs
                val updatenick = EMClient.getInstance().pushManager().updatePushNickname(
                    DemoApplication.currentUserNick.trim { it <= ' ' })
                if (!updatenick) {
                    Log.e("LoginActivity", "update current user nick fail")
                }

                if (!this@LoginActivity.isFinishing && pd.isShowing) {
                    pd.dismiss()
                }

                // get user's info (this should be get from App's server or 3rd party service)
                DemoHelper.getInstance().userProfileManager.asyncGetCurrentUserInfo()

                val intent = Intent(
                    this@LoginActivity,
                    MainActivity::class.java
                )
                startActivity(intent)

                finish()
            }

            override fun onProgress(progress: Int, status: String) {
                Log.d(TAG, "login: onProgress")
            }

            override fun onError(code: Int, message: String) {
                Log.d(TAG, "login: onError: $code")
                if (!progressShow) {
                    return
                }
                runOnUiThread {
                    pd.dismiss()
                    Toast.makeText(
                        applicationContext, getString(R.string.Login_failed) + message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

    /**
     * register
     *
     * @param view
     */
    fun register(view: View) {
        startActivityForResult(Intent(this, RegisterActivity::class.java), 0)
    }

    /**
     * SDK service check
     *
     * @param v
     */
    fun serviceCheck(v: View) {
        startActivity(Intent(this, ServiceCheckActivity::class.java))
    }

    override fun onResume() {
        super.onResume()
        if (autoLogin) {
            return
        }
    }

    companion object {
        private val TAG = "LoginActivity"
        val REQUEST_CODE_SETNICK = 1
    }
}
