package com.chenna.mvpexample.Activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chenna.mvpexample.DTO.LoginDTO;
import com.chenna.mvpexample.Model.LoginPresenterImpl;
import com.chenna.mvpexample.Presenter.LoginPresenter;
import com.chenna.mvpexample.R;
import com.chenna.mvpexample.Utils.UtilsClass;
import com.chenna.mvpexample.View.LoginView;

public class MainActivity extends Activity implements View.OnClickListener, LoginView {

    EditText username, password;
    TextView login_btn;
    LoginPresenter mloginpresenter;
    LoginDTO mlogindto;
    LoginView mloginView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        login_btn = (TextView) findViewById(R.id.login_btn);

        mlogindto = new LoginDTO();
        mloginpresenter = new LoginPresenterImpl(MainActivity.this);

        login_btn.setOnClickListener(this);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,GetActorsData.class));
            }
        });
    }

    @Override
    public void onClick(View view) {

        progressDialog = new ProgressDialog(MainActivity.this,R.style.MyAlertDialogStyle);
        String user = username.getText().toString();
        String pass = password.getText().toString();
        mloginpresenter.performLogin(user, pass);
        progressDialog.setMessage(UtilsClass.Loging);
        progressDialog.show();
    }

    @Override
    public void loginvalidation() {

        Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {

        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {

        Toast.makeText(this, "Please enter valid credentials", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideProgressDialog() {

        progressDialog.dismiss();
    }

    @Override
    public void showresult(LoginDTO result) {

        progressDialog.dismiss();
        Toast.makeText(this, ""+result.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
