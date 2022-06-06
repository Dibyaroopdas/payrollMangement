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
import com.example.payrollmanagement.models.GradeModel;

import java.util.List;

public class GradeAdapter extends RecyclerView.Adapter<GradeAdapter.MyViewHolder> {

    Context context;
    List<GradeModel> list;

    public GradeAdapter(Context context, List<GradeModel> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(List<GradeModel> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public GradeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grade_cardview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GradeAdapter.MyViewHolder holder, int position) {
        holder.gradeName.setText(list.get(position).getGrade_name().toString());
        holder.gradeID.setText(String.valueOf(list.get(position).getGrade_id()));
    }


    @Override
    public int getItemCount() {
        if(list != null){
            return list.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView gradeName,gradeID;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            gradeID =itemView.findViewById(R.id.grade_id_cardview);
            gradeName = itemView.findViewById(R.id.grade_name_cardview);
        }
    };

}
