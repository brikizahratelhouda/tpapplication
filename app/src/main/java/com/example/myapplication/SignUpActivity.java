package com.example.myapplication;

import androidx.annotation.NonNull;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends  HTTP{
    private EditText first_nameEditText;
    private EditText family_nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText ageEditText;
    private EditText addressEditText;
    private Button signUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page ="signup.php";
        setContentView(R.layout.activity_sign_up);
        first_nameEditText=findViewById(R.id.first_name);
        family_nameEditText=findViewById(R.id.family_name);   
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        ageEditText = findViewById(R.id.age);
        addressEditText = findViewById(R.id.address);
        signUpButton = findViewById(R.id.signup_button);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first_name=first_nameEditText.getText().toString();
                String family_name=family_name.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String age = ageEditText.getText().toString();
                String address = addressEditText.getText().toString();
                CONNECT(email,password,age,address);
            }
        });
    }



    @NonNull
    protected Map<String, String> getStringStringMap(String email, String password, String age, String address,String first_name,String family_name) {
        Map<String, String> params = new HashMap<>();
        params.put("first_name", first_name);
        params.put("family_name", family_name);
        params.put("email", email);
        params.put("password", password);
        params.put("age", age);
        params.put("address", address);
        return params;
    }

    protected void responseError2(VolleyError error) {
        Toast.makeText(SignUpActivity.this, "Error occurred: " + error.getMessage(), Toast.LENGTH_SHORT).show();
    }

    protected void responseError(String response) {
        Toast.makeText(SignUpActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
    }

    protected void response() {
        Toast.makeText(SignUpActivity.this, "Sign Up Success", Toast.LENGTH_SHORT).show();
    }


}
