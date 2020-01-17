package com.myapp.belajarmvpandroid;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.myapp.belajarmvpandroid.Presenter.LoginPresenter;
import com.myapp.belajarmvpandroid.Presenter.LoginPresenterImp;
import com.myapp.belajarmvpandroid.Presenter.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.et_username)
    TextInputEditText username;
    @BindView(R.id.et_pass)
    TextInputEditText password;
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new LoginPresenterImp(this);
    }

    @OnClick(R.id.bt_login)
    void klik_login() {
        presenter.login(username.getText().toString(), password.getText().toString());
    }

    @Override
    public void showValidationError() {
        Toast.makeText(this, "username dan password tidak valid", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Berhasil login", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "gagal login", Toast.LENGTH_SHORT).show();
    }
}
