package com.teamif.justhear.apis;

public class LoginRequest
{
    final String email;
    final String pass;

    public LoginRequest(String email, String pw)
    {
        this.email = email;
        this.pass = pw;
    }
}
