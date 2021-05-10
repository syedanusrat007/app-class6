package com.ccc.mist.classproject2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ccc.mist.classproject2.R;
import com.ccc.mist.classproject2.model.HoldObject;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentView> {
    protected  Context context;
    private List<HoldObject> list = new ArrayList<HoldObject>();

    public StudentAdapter(Context context,List<HoldObject> list){
        this.context =context;
        this.list =list;
    }


public class StudentView extends RecyclerView.ViewHolder{

      protected ImageView proImage;
      protected TextView tvName, tvMobile;
      private View mRodView;

    public StudentView(View itemView) {
        super(itemView);
        proImage = (ImageView)  itemView.findViewById(R.id.ivProf);
        tvName = (TextView) itemView.findViewById(R.id.tvName);
        tvMobile = (TextView) itemView.findViewById(R.id.tvMobile);
        mRodView =itemView;
    }
}

    @Override
    public void onBindViewHolder(StudentView holder, int position) {

        HoldObject holdObject = list.get(position);

        holder.tvName.setText(holdObject.getName());
        holder.tvMobile.setText(holdObject.getReg());


        holder.mRodView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"click here",Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public StudentView onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_row,parent,false);


        return new StudentView(view);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
