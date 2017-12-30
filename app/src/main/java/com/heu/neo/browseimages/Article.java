package com.heu.neo.browseimages;

/**
 * Created by neo on 2017/12/29.
 */

public class Article {
    private String id;
    private String title;
    private String date;
    private String imgurl;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String data) {
        this.date = data;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
