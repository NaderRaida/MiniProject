package com.goldcode.naderwalid.miniproject;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {
    Button login;
    EditText email, password;
    ImageView logo;
    private static final int INTENT_AUTH_CODE = 130;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        login = findViewById(R.id.login_btn);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        logo = findViewById(R.id.logo);

        // Property animator
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.property_animator);
        set.setTarget(logo);
        set.start();
        //
        // Property animator
        AnimatorSet set1 = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.property_animator2);
        set1.setTarget(findViewById(R.id.secondSection));
        set1.start();
        //

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (email.getText().toString().isEmpty()) {
                    email.setError("This field is required");
                } else if (!email.getText().toString().contains("@") || !email.getText().toString().contains(".com")) {
                    email.setError("Invalid email address");
                }else if(password.getText().toString().isEmpty()){
                    password.setError("This field is required");
                }else if (password.getText().toString().length() <= 3) {
                    password.setError("This password is too short");
                } else {
                    Intent intent = new Intent(LoginActivity.this, AuthActivity.class);
                    intent.putExtra("email", email.getText().toString());
                    intent.putExtra("password", password.getText().toString());
                    startActivityForResult(intent,INTENT_AUTH_CODE);

                }


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (INTENT_AUTH_CODE == requestCode && resultCode == RESULT_CANCELED) {
            password.setError("Incorrect Email or Password !");
        }else if(resultCode == RESULT_OK){
            finish();
        }
    }
}
