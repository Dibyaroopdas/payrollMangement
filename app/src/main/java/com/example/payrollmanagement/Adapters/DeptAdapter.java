package com.example.payrollmanagement.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.payrollmanagement.R;
import com.example.payrollmanagement.models.DeptModel;

import java.util.List;

public class DeptAdapter extends RecyclerView.Adapter<DeptAdapter.MyViewHolder>{

    Context context;
    List<DeptModel> list;

    public DeptAdapter(Context context, List<DeptModel> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(List<DeptModel> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DeptAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.dept_cardview,parent,false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull DeptAdapter.MyViewHolder holder, int position) {
        holder.deptName.setText(list.get(position).getDept_name().toString());
    }

    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView deptName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            deptName = itemView.findViewById(R.id.dept_name_cardview);
        }
    };
}
