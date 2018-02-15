package com.chenna.mvpexample.Model;

import android.app.ProgressDialog;
import android.content.Context;
import android.text.TextUtils;

import com.chenna.mvpexample.DTO.LoginDTO;
import com.chenna.mvpexample.Presenter.LoginPresenter;
import com.chenna.mvpexample.View.LoginView;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

/**
 * Created by chinn on 02/10/18.
 */

public class LoginPresenterImpl implements LoginPresenter {

    LoginView mloginView;
    ProgressDialog progressdialog;

    public LoginPresenterImpl(LoginView loginView) {
        this.mloginView = loginView;
    }

    @Override
    public void performLogin(String username, String password) {

        if (TextUtils.isEmpty(username) || (TextUtils.isEmpty(password))) {

            mloginView.hideProgressDialog();
            mloginView.loginvalidation();

        } else {

            Ion.with((Context) mloginView)
                    .load("http://streaklabs.in:90//api/Streaker/Login")
                    .setBodyParameter("email", username)
                    .setBodyParameter("password", password)
                    .as(new TypeToken<LoginDTO>() {
                    })
                    .setCallback(new FutureCallback<LoginDTO>() {
                        @Override
                        public void onCompleted(Exception e, LoginDTO result) {
                            if (result.getStatusCode().equals("1")) {
                                mloginView.hideProgressDialog();
                                mloginView.showresult(result);
                            } else {
                                mloginView.hideProgressDialog();
                                mloginView.loginError();
                            }
                        }
                    });
        }

    }
}
