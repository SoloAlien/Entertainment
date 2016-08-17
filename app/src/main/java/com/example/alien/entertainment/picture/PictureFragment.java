package com.example.alien.entertainment.picture;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.alien.entertainment.R;
import com.example.alien.entertainment.picture.adapter.PicAdapter;
import com.example.alien.entertainment.picture.entity.Pic;
import com.example.alien.entertainment.picture.entity.PicList;
import com.hannesdorfmann.mosby.mvp.MvpFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Alien on 2016/8/16.
 */
public class PictureFragment extends MvpFragment<PictureView,PicturePresenter> implements PictureView, SwipeRefreshLayout.OnRefreshListener {
    private View view;
    private ProgressDialog progress;
    @BindView(R.id.picturerecyclerview)RecyclerView recyclerview;
    @BindView(R.id.swipefresh)
    SwipeRefreshLayout refresh;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_picture,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        refresh.setColorSchemeColors(getResources().getColor(android.R.color.holo_red_light),
                getResources().getColor(android.R.color.holo_green_light),
                getResources().getColor(android.R.color.holo_blue_bright),
                getResources().getColor(android.R.color.holo_orange_light));
        refresh.setOnRefreshListener(this);
        getPresenter().getPic();
    }

    @Override
    public PicturePresenter createPresenter() {
        return new PicturePresenter();
    }


    @Override
    public void reFreshOver() {
        refresh.setRefreshing(false);
    }

    @Override
    public void reLoad() {

    }

    @Override
    public void showErrorMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
        Log.e("TAG", "showErrorMessage: "+msg );
    }

    @Override
    public void showProgress() {
        refresh.setRefreshing(true);
//        progress=ProgressDialog.show(getContext(),"","加载中，请稍后...");
    }

//    @Override
//    public void hideProgress() {
//        progress.dismiss();
//    }

    @Override
    public void setData(List<PicList> data) {
//        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        GridLayoutManager manager=new GridLayoutManager(getContext(),2);
//        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(manager);
        PicAdapter adapter=new PicAdapter((ArrayList<PicList>)data);
        recyclerview.setAdapter(adapter);
    }

    @Override
    public void onRefresh() {
        getPresenter().getPic();
    }
}
