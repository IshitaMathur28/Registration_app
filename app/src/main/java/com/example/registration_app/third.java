package com.example.registration_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class third extends AppCompatActivity {

    Button b4,b5;
    EditText e5,e6,e7;
    FirebaseAuth fa;
    FirebaseDatabase fd;
    DatabaseReference dr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        b4=(Button) findViewById(R.id.button4);
        b5=(Button)findViewById(R.id.button5);
        e5=(EditText)findViewById(R.id.editTextTextPersonName5);
        e6=(EditText)findViewById(R.id.editTextTextPersonName6);
        e7=(EditText)findViewById(R.id.editTextTextPersonName7);
        fd=FirebaseDatabase.getInstance();
        fa= FirebaseAuth.getInstance();
        b4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fa.signOut();
                Intent k=new Intent(third.this,MainActivity.class);
                startActivity(k);
                finish();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dr= fd.getReference("Users");
                String s1=e5.getText().toString();
                String s2=e6.getText().toString();
                String s3=e7.getText().toString();
                if(s3.length()!=10){
                    Toast.makeText(third.this, "phone length not correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    Users users = new Users(s1,s2,s3);
                    dr.child(s3).setValue(users);
                    Toast.makeText(third.this, "database stored", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}