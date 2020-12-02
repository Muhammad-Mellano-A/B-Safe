package com.machina.b_safe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onGenderChosen(View view) {
    }

    public void onAgreementClicked(View view) {
    }

    public void registerNowFromRegister(View view) {
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void loginNowFromRegister(View view) {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        finish();
    }
}