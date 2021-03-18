package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.roomdatabase.adapter.UserInfoAdapter;
import com.example.roomdatabase.database.DatabaseClient;
import com.example.roomdatabase.model.UserInfo;

import java.util.List;

public class UserListActivity extends AppCompatActivity {
RecyclerView userListView;
TextView empty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        initVariables();
        initView();
        initListener();
        initFunction();
    }

    private void initVariables() {


    }
    private void initView() {

        empty = findViewById(R.id.empty);
        userListView = findViewById(R.id.userListView);
        userListView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initFunction() {
        getUserInfo();
    }

    private void initListener() {

    }

    private void getUserInfo() {
        class GetTasks extends AsyncTask<Void, Void, List<UserInfo>> {

            @Override
            protected List<UserInfo> doInBackground(Void... voids) {
                List<UserInfo> taskList = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .taskDao()
                        .getAll();
                return taskList;
            }

            @Override
            protected void onPostExecute(List<UserInfo> tasks) {
                super.onPostExecute(tasks);
                empty.setVisibility(View.GONE);
                userListView.setVisibility(View.VISIBLE);
                UserInfoAdapter adapter = new UserInfoAdapter(UserListActivity.this, tasks);
                userListView.setAdapter(adapter);
            }
        }

        GetTasks gt = new GetTasks();
        gt.execute();
    }

}