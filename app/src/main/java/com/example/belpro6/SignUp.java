package com.example.belpro6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {

    Button btnDaftar;
    TextView punyaakun;
    EditText etEmail, etKatasandi,etKonfirmasiKatasandi;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btnDaftar = findViewById(R.id.btnDaftar);
        punyaakun = findViewById(R.id.punyaakun);
        etEmail = findViewById(R.id.etEmail);
        etKatasandi = findViewById(R.id.etKatasandi);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String password= etKatasandi.getText().toString();
//                String konfirmasi = etKonfirmasiKatasandi.getText().toString();

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Intent act=new Intent(SignUp.this, Login.class);
                            startActivity(act);
                            finish();
                        }
                    }
                });
            }
        });

        punyaakun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act=new Intent(SignUp.this, Login.class);
                startActivity(act);
            }
        });
    }
}