package com.mark.oo;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdabter extends RecyclerView.Adapter<CustomAdabter.MyViewHolder> implements View.OnClickListener{
List<ModelClass> mList;
Context context;

    public CustomAdabter(List<ModelClass> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
      View view = layoutInflater.inflate(R.layout.layoutfile,parent,false);

        return new MyViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
            holder.imageView.setImageResource(mList.get(position).getImage());
            holder.textView.setText(mList.get(position).getText());
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent mainintent =new Intent(view.getContext(),Main2Activity.class);
        mainintent.putExtra("image",mList.get(position).getImage());
        mainintent.putExtra("text",mList.get(position).getText());
        mainintent.putExtra("text2",mList.get(position).getText2());
        mainintent.putExtra("code3",mList.get(position).getCode3());
        mainintent.putExtra("image2",mList.get(position).getImage2());
        mainintent.putExtra("type",mList.get(position).getType());
        mainintent.putExtra("name",mList.get(position).getName());
        Log.e("text",mList.get(position).getText());

        view.getContext().startActivity(mainintent);
    }
});

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
       ImageView imageView;
       TextView textView;
        OnItemListener onItemListener;
        public MyViewHolder(@NonNull View itemView ) {
            super(itemView);
            imageView=itemView.findViewById(R.id.ProjjectImageView);
            textView=itemView.findViewById(R.id.ProjectnameTextView);

           itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
    public interface OnItemListener{
        void onItemClick(int position);
    }
}
