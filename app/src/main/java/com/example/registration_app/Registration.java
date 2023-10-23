package com.example.registration_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registration extends AppCompatActivity {
        EditText e1,e2;
        Button b1,b2;
        ProgressBar p1;
        FirebaseAuth fa;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registration);
            e1=(EditText) findViewById(R.id.editTextTextPersonName);
            e2=(EditText) findViewById(R.id.editTextTextPersonName4);
            e2.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
            b1=(Button) findViewById(R.id.button);
            b2=(Button) findViewById(R.id.button3);
            p1=(ProgressBar) findViewById(R.id.progressBar2);
            fa=FirebaseAuth.getInstance();
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i=new Intent(Registration.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            });

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s1=e1.getText().toString();
                    String s2=e2.getText().toString();
                    if(s1.isEmpty())
                    {
                        e1.setError("fill email id ");
                    }
                    else {
                        if(s2.isEmpty()){
                            e2.setError("fill password");
                            return;
                        }
                        else{
                            p1.setVisibility(View.VISIBLE);
                            fa.createUserWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful())
                                    {
                                        Toast.makeText(Registration.this, "database updated", Toast.LENGTH_SHORT).show();
                                        p1.setVisibility(View.INVISIBLE);
                                        Intent k=new Intent(Registration.this,MainActivity.class);
                                        startActivity(k);
                                        finish();
                                    }
                                    else{
                                        Toast.makeText(Registration.this, "database not updated", Toast.LENGTH_SHORT).show();
                                        p1.setVisibility(View.VISIBLE);
                                    }


                                }
                            });
                        }
                    }


                }
            });
        }
    }
