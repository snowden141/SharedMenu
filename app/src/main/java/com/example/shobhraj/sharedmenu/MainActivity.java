package com.example.shobhraj.sharedmenu;

import android.app.ActionBar;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RelativeLayout background;
    EditText user_name, pass_word, set_container;
    Button submitdata, seedata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_name = findViewById(R.id.username);
        pass_word = findViewById(R.id.pword);

        submitdata = findViewById(R.id.submit);
        set_container = findViewById(R.id.container);
        background = findViewById(R.id.back);
    }

    //method for saving users login information
    public void saveinfo(View view) {

        //userinfo is the file name where the user login data will be stored. and it is shared in the
        //private mode which means no one else outside the application can access it.

        SharedPreferences sharedpref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();

        if (user_name.getText().length() == 0) {
            user_name.setError("username cant be empty !! ");
        }
        //store the username in file
        editor.putString("username", user_name.getText().toString());

        if (pass_word.getText().length() == 0) {
            pass_word.setError("password cant be empty !!");
        }

        //store the password in the file
        editor.putString("password", pass_word.getText().toString());
        editor.apply();

        //imitate the user that the data has been stored successfully
        Toast.makeText(this, "hola !! saved your data !!", Toast.LENGTH_LONG).show();
    }

    //method to print the saved user data
    public void displaydata(View view) {
        //similar to the saveinfo function file (for storing the user login data)
        SharedPreferences sharedpref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);

        //retrieve the username from the file userinfo
        String name = sharedpref.getString("username", "");

        //retrieve the password from the file userinfo
        String pw = sharedpref.getString("password", "");
        set_container.setText(name + " " + pw);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.item1:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                background.setBackgroundColor(Color.MAGENTA);
                return true;

            case R.id.item2:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                background.setBackgroundColor(Color.YELLOW);
                return true;

            case R.id.item3:
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                background.setBackgroundColor(Color.GREEN);
                return true;

            case R.id.item4:
                Intent intent=new Intent(this,About.class);
                startActivity(intent);

                default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
