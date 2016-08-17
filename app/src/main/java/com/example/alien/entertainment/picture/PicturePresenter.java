package com.example.alien.entertainment.picture;

import android.widget.Toast;

import com.example.alien.entertainment.net.NetClient;
import com.example.alien.entertainment.picture.entity.Pic;
import com.example.alien.entertainment.picture.entity.PicList;
import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alien on 2016/8/17.
 */
public class PicturePresenter extends MvpNullObjectBasePresenter<PictureView> {
    private Call<Pic> call;


    public void getPic(){
        if (call!=null)call.cancel();
        call= NetClient.getNetClient().getPictureapi().getPic();
        call.enqueue(PicCallback);
        getView().showProgress();
    }
    private Callback<Pic> PicCallback=new Callback<Pic>() {
        @Override
        public void onResponse(Call<Pic> call, Response<Pic> response) {
//            getView().hideProgress();
            getView().reFreshOver();
            if (response!=null&&response.isSuccessful()){
                Pic pic = response.body();
                if (pic==null){getView().showErrorMessage("未知错误");return;}
                getView().showErrorMessage(pic.getMsg());
                if(pic.getCode()==200){
                    List<PicList> result=pic.getList();
                    getView().setData(result);
                    return;
                }
            }
        }

        @Override
        public void onFailure(Call<Pic> call, Throwable t) {
//            getView().hideProgress();
            getView().reFreshOver();
            getView().showErrorMessage(t.getMessage());
        }
    };
//    private Callback<Pic> PicCallback=new Callback<Pic>() {
//        @Override
//        public void onResponse(Call<Pic> call, Response<Pic> response) {
//            getView().hideProgress();
//            if (response!=null&&response.isSuccessful()){
//                List<Pic> result = response.body();
//                if (result==null){
//                    getView().showErrorMessage("未知错误");
//                    return;
//                }
//            getView().setData(result);
//            }
//        }
//
//        @Override
//        public void onFailure(Call<List<Pic>> call, Throwable t) {
//            getView().hideProgress();
//            getView().showErrorMessage(t.getMessage());
//        }
//    };

}
