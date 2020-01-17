package com.myapp.belajarmvpandroid.Presenter;

public interface LoginView {

    void showValidationError(); // validasi ketika login
    void loginSuccess();        //validasi ketika succes
    void loginError();          //validasi ketika error
}
