package com.chenna.mvpexample.View;

import com.chenna.mvpexample.DTO.LoginDTO;

/**
 * Created by chinn on 02/10/18.
 */

public interface LoginView {

    void loginvalidation();

    void loginSuccess();

    void loginError();

    void hideProgressDialog();

    void showresult(LoginDTO result);
}
