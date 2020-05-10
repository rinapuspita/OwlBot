package com.jiayou.owlbot.model;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jiayou.owlbot.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class OwlBotAdapter extends RecyclerView.Adapter<OwlBotAdapter.ListViewHolder>{
    private ArrayList<OwlBotResponse> owlBotResponse;
    private Context context;
    private String example;

    public OwlBotAdapter(Context context, ArrayList<OwlBotResponse> owlBotResponse) {
        this.context = context;
        this.owlBotResponse = owlBotResponse;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.dictionary_item, parent, false);
        return new ListViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        String imageurl = owlBotResponse.get(position).getImage_url();
//        if (imageurl.equals("null")){
//            Picasso.get().load(R.drawable.owlbot).into(holder.imgPhoto);
//        } else{
            Picasso.get().load(imageurl).into(holder.imgPhoto);
//        }

        holder.type.setText(owlBotResponse.get(position).getType());
        holder.definitions.setText(owlBotResponse.get(position).getDefinition());
        holder.tvexample.setText(owlBotResponse.get(position).getExample());
        holder.image_url.setText(owlBotResponse.get(position).getImage_url());
//        example = owlBotResponse.get(position).getExample();
//        if(example.equals("null")) {
//            holder.tvexample.setText("");
//        } else{
//            holder.tvexample.setText(Html.fromHtml(owlBotResponse.get(position).getExample(), Html.FROM_HTML_MODE_LEGACY));
//        }
    }

    @Override
    public int getItemCount() {
        return owlBotResponse.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView type, definitions, tvexample, image_url;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.imageView);
            type = itemView.findViewById(R.id.txttype);
            definitions = itemView.findViewById(R.id.txtdefinition);
            tvexample = itemView.findViewById(R.id.txtexam);
            image_url = itemView.findViewById(R.id.txtimage);
        }
    }
}
