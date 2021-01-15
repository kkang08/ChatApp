package com.example.chatapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CustomViewHolder> {

    //final static private String URL = "http://kkang.dothome.co.kr/imformation.php";

    private ArrayList<UserData> arrayList;
    public RecyclerAdapter(ArrayList<UserData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_image,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.CustomViewHolder holder, int position) {

        holder.itemview(arrayList.get(position));

    }

    @Override
    public int getItemCount() {
        return null!=arrayList ?arrayList.size():0;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView et_name, et_email;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            et_name = itemView.findViewById(R.id.et_name);
            et_email = itemView.findViewById(R.id.et_email);
        }

        public void itemview(UserData userData) {
            image.setImageResource(userData.getImage());
            et_name.setText(userData.getEt_name());
            et_email.setText(userData.getEt_email());
        }
    }


    /*@NonNull
    @Override
    public RecyclerAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_image,parent,true);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.CustomViewHolder holder, int position) {

        holder.image.setImageResource(arrayList.get(position).getImage());
        holder.et_name.setText(arrayList.get(position).getEt_name());
        holder.et_email.setText(arrayList.get(position).getEt_email());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curName = holder.et_name.getText().toString();
                Toast.makeText(v.getContext(),curName,Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                remove(holder.getAdapterPosition());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null!=arrayList ?arrayList.size():0);
    }

    public void remove(int position){
        try{
            arrayList.remove(position);
            notifyItemRemoved(position);

        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView image;
        protected TextView et_name, et_email;

        public CustomViewHolder(@NonNull View itemView)
        {
            super(itemView);
            this.image = (ImageView)itemView.findViewById(R.id.image);
            this.et_name = (TextView)itemView.findViewById(R.id.et_name);
            this.et_email = (TextView)itemView.findViewById(R.id.et_email);

            et_name.setText(arrayList.get(URL.indexOf("userName")).getEt_name());
            et_email.setText(arrayList.get(URL.indexOf("userEmail")).getEt_email());

           // return;
        }
    }
*/
}
