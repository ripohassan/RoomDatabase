package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.roomdatabase.database.DatabaseClient;
import com.example.roomdatabase.model.UserInfo;

public class MainActivity extends AppCompatActivity{
    Button register,userList;
    EditText email,password;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initVariables();
        initView();
        initListener();
        initFunction();
    }

    private void initVariables() {


    }
    private void initView() {
        userList = findViewById(R.id.userList);
        register = findViewById(R.id.register);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar);

    }

    private void initFunction() {

    }

    private void initListener() {
        userList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoActivity();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                makeLogin();
            }
        });

    }

    private void gotoActivity() {
        startActivity(new Intent(MainActivity.this,UserListActivity.class));

    }

    private void makeLogin() {
            final String userEmail = email.getText().toString().trim();
            final String userPassword = password.getText().toString().trim();

            if (userEmail.isEmpty()) {
                email.setError("Email required");
                email.requestFocus();
                return;
            }

            if (userPassword.isEmpty()) {
                password.setError("Password required");
                password.requestFocus();
                return;
            }
            class SaveTask extends AsyncTask<Void, Void, Void> {

                @Override
                protected Void doInBackground(Void... voids) {

                    //creating a task
                    UserInfo userInfo = new UserInfo();
                    userInfo.setName(userEmail);
                    userInfo.setPassword(userPassword);


                    //adding to database
                    DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                            .taskDao()
                            .insert(userInfo);
                    return null;
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                    //finish();
                    //startActivity(new Intent(getApplicationContext(), UserListActivity.class));
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                }
            }

            SaveTask st = new SaveTask();
            st.execute();
        }

}