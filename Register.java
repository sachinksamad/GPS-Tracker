package com.e.gpstracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity implements  View.OnClickListener{

    EditText email, password;
    Button RegBtn;
    TextView textSignin;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();

        email = (EditText)findViewById(R.id.editText3);
        password = (EditText)findViewById(R.id.editText5);
        RegBtn = (Button)findViewById(R.id.button4);
        textSignin = (TextView) findViewById(R.id.textView2);

        RegBtn.setOnClickListener(this);
        textSignin.setOnClickListener(this);
    }

    private void registerUser(){
        String emailT = email.getText().toString().trim();
        String passwordT =  password.getText().toString().trim();

        if(TextUtils.isEmpty(emailT)){
            //email is empty
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            //stop function
            return;
        }

        if(TextUtils.isEmpty(passwordT)){
            //password is empty
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            //stop function
            return;
        }
        auth.createUserWithEmailAndPassword(emailT, passwordT)
        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                     Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Failed to register, please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v){
        if(v == RegBtn){
            registerUser();
        }

        if(v == textSignin){

        }
    }
}
