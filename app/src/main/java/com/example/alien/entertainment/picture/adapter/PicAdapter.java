package com.example.alien.entertainment.picture.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.alien.entertainment.R;
import com.example.alien.entertainment.picture.entity.Pic;
import com.example.alien.entertainment.picture.entity.PicList;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Alien on 2016/8/17.
 */
public class PicAdapter  extends RecyclerView.Adapter {

    private ArrayList<PicList> datalist;
    public PicAdapter(ArrayList<PicList> datalist){
        this.datalist=datalist;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder=new viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.pic_item,null));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        viewholder viewHolder= (viewholder) holder;
        ImageLoader.getInstance().displayImage(datalist.get(position).getPicurl(),viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }
    public class viewholder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        public viewholder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.pic_image);
        }
    }
}
