package com.example.roomdatabase.adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase.R;
import com.example.roomdatabase.database.DatabaseClient;
import com.example.roomdatabase.listeners.ClickListener;
import com.example.roomdatabase.model.UserInfo;

import java.util.List;

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.TasksViewHolder> {

    private Context mCtx;
    private List<UserInfo> taskList;
    private ClickListener  clickListener;

    public UserInfoAdapter(Context mCtx, List<UserInfo> taskList) {
        this.mCtx = mCtx;
        this.taskList = taskList;
    }

    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_user, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {
        UserInfo t = taskList.get(position);
        holder.email.setText(t.getName());
        holder.password.setText(t.getPassword());

        holder.imvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //adding to database
              taskList.remove(position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return taskList.size();
    }

    static class TasksViewHolder extends RecyclerView.ViewHolder {

        TextView email, password;
        ImageView imvDelete;

        public TasksViewHolder(View itemView) {
            super(itemView);

            email = itemView.findViewById(R.id.email);
            password = itemView.findViewById(R.id.password);
            imvDelete = itemView.findViewById(R.id.imvDelete);

        }
    }
    public void setClickListener(ClickListener clickListener){
        this.clickListener = clickListener;

    }
}
