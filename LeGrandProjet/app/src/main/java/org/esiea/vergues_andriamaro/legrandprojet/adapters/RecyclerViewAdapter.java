package org.esiea.vergues_andriamaro.legrandprojet.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.esiea.vergues_andriamaro.legrandprojet.model.JSONmh4u;
import org.esiea.vergues_andriamaro.legrandprojet.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<JSONmh4u> mData;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<JSONmh4u> mData) {
        this.mContext = mContext;
        this.mData = mData;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.json_mh4u_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_en_name.setText(mData.get(position).getEn_name());
        holder.tv_jp_name.setText(mData.get(position).getJp_name());
        holder.tv_fr_name.setText(mData.get(position).getFr_name());

        Glide.with(mContext).load(mData.get(position).getImg_url()).apply(option).into(holder.img_image);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_en_name;
        TextView tv_jp_name;
        TextView tv_fr_name;
        ImageView img_image;


        public MyViewHolder(View itemView) {
            super(itemView);

            tv_en_name = itemView.findViewById(R.id.mh4u_en);
            tv_jp_name = itemView.findViewById(R.id.mh4u_jp);
            tv_fr_name = itemView.findViewById(R.id.mh4u_fr);
            img_image = itemView.findViewById(R.id.image_monster_mh4u);
        }
    }
}
