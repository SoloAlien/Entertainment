package com.example.alien.entertainment.picture;

import com.example.alien.entertainment.picture.entity.Pic;
import com.example.alien.entertainment.picture.entity.PicList;
import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.List;

/**
 * Created by Alien on 2016/8/17.
 */
public interface PictureView extends MvpView{
    void reFreshOver();
    void reLoad();
    void showErrorMessage(String msg);
    void showProgress();
//    void hideProgress();
    void setData(List<PicList> data);
}
