package com.example.alien.entertainment.picture.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alien on 2016/8/17.
 */
public class PicList {
//    "newslist": {
//    "ctime": "2015-07-17",
//            "title": "那个抱走王明涵的，你上微信吗？看完这个你会心软吗？",
//            "description": "中国传统文化",
//            "picUrl": "http://zxpic.gtimg.com/infonew/0/wechat_pics_-667708.jpg/640",
//            "url": "http://mp.weixin.qq.com/s?__biz=MzA3OTg2NjEwNg==&amp;idx=5&amp;mid=209313388&amp;sn=7e30bd2851d22f69580e202c31fc7ecf&amp;qb_mtt_show_type=1"
//}
    @SerializedName("ctime")
    private String time;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("picUrl")
    private String picurl;
    @SerializedName("url")
    private String url;

    public String getTime() {
        return time;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPicurl() {
        return picurl;
    }

    public String getUrl() {
        return url;
    }
}
