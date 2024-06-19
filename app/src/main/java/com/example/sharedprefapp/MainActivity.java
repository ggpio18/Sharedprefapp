package com.example.sharedprefapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2, et3;
    Button bt;

    public static final String myPreferences = "MyPrefs";
    public static final String name = "nameKey";
    public static final String password = "passKey";
    public static final String email = "emailKey";

    SharedPreferences sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        bt = (Button) findViewById(R.id.button);

        sharedpref = getSharedPreferences(myPreferences, Context.MODE_PRIVATE);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = et1.getText().toString();
                String pw = et2.getText().toString();
                String e = et3.getText().toString();

                SharedPreferences.Editor editor = sharedpref.edit();

                editor.putString(name, n);
                editor.putString(password, pw);
                editor.putString(email, e);
                editor.commit();
                Toast.makeText(MainActivity.this,"Thanks",Toast.LENGTH_LONG).show();

            }
        });
    }
}