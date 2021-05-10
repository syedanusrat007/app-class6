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
import com.ccc.mist.classproject2.model.Flower;
import com.ccc.mist.classproject2.model.HoldObject;
import com.ccc.mist.classproject2.utils.AppConstant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.StudentView> {
    protected  Context context;
    private List<Flower> fList = new ArrayList<Flower>();

    public FlowerAdapter(Context context, List<Flower> fList){
        this.context =context;
        this.fList =fList;
    }


public class StudentView extends RecyclerView.ViewHolder{

      protected ImageView ivFlower;
      protected TextView tvFlowerName, tvFlowerdesc;
      private View mRodView;

    public StudentView(View itemView) {
        super(itemView);
        ivFlower = (ImageView)  itemView.findViewById(R.id.ivFlower);
        tvFlowerName = (TextView) itemView.findViewById(R.id.tvFlowerName);
        tvFlowerdesc = (TextView) itemView.findViewById(R.id.tvFlowerdesc);
        mRodView =itemView;
    }
}

    @Override
    public void onBindViewHolder(StudentView holder, int position) {

        Flower fObject = fList.get(position);


        holder.tvFlowerName.setText(fObject.getName());
        holder.tvFlowerdesc.setText(fObject.getInstructions());

        Picasso.with(context).load(AppConstant.BASE_URL+""+fObject.getPhoto()).fit()
                .placeholder(R.drawable.app_icon)
                .error(R.drawable.app_icon)
                .into(holder.ivFlower);


    }

    @Override
    public StudentView onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flower_row,parent,false);


        return new StudentView(view);
    }

    @Override
    public int getItemCount() {
        return fList.size();
    }

}
