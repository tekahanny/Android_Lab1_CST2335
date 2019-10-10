package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    private String emailAddress;
    private SharedPreferences prefs;
    private EditText editText;
    private static final String ACTIVITY_NAME="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_file);
        Log.e(ACTIVITY_NAME,"onCreate");


        editText = findViewById(R.id.Temail);
        prefs= getSharedPreferences("FileName", MODE_PRIVATE);
        emailAddress = prefs.getString("Email", "");
        editText.setText(emailAddress);

        Button button = findViewById(R.id.button1);
        button.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                Intent goToPage2 = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(goToPage2);
            }
        });


    }

    @Override
    protected void onPause(){
        super.onPause();
        emailAddress=editText.getText().toString();
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Email", emailAddress);
        Log.e(ACTIVITY_NAME,"onPause");
        editor.commit();
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.e(ACTIVITY_NAME,"onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.e(ACTIVITY_NAME,"onResume");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.e(ACTIVITY_NAME,"onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.e(ACTIVITY_NAME,"onDestroy");
    }

    protected void onActivityResult(){
        Log.e(ACTIVITY_NAME,"onActivityResult");
    }
}
