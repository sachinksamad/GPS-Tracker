package com.e.gpstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    private Button signin, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        signin = (Button) findViewById(R.id.button);
        signup = (Button) findViewById(R.id.button2);
        signin.setOnClickListener(new View.OnClickListener(){
                                      @Override
                                      public void onClick(View v) {
                                        openActivity1();
                                      }
                                  });

        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }
    public void openActivity1(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void openActivity2(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

}
