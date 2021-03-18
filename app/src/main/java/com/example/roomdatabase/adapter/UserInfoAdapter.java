package com.example.roomdatabase.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.roomdatabase.R;
import com.example.roomdatabase.model.UserInfo;

import java.util.List;

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.TasksViewHolder> {

    private Context mCtx;
    private List<UserInfo> taskList;

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


    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    class TasksViewHolder extends RecyclerView.ViewHolder{

        TextView email, password;

        public TasksViewHolder(View itemView) {
            super(itemView);

            email = itemView.findViewById(R.id.email);
            password = itemView.findViewById(R.id.password);

        }
    }
}
