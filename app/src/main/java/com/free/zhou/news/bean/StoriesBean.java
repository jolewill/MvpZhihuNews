package com.free.zhou.news.bean;

import java.util.List;

/**
 * Created by zskzh on 2017/5/1.
 */

public  class StoriesBean {
    /**
     * title : 为什么陈凯歌再没拍出这样好的电影来？
     * ga_prefix : 050121
     * images : ["https://pic3.zhimg.com/v2-9cbb836d62367b202637c4e9320fc14a.jpg"]
     * multipic : true
     * type : 0
     * id : 9393089
     */

    private String title;
    private String ga_prefix;
    private boolean multipic;
    private int type;
    private int id;
    private List<String> images;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public boolean isMultipic() {
        return multipic;
    }

    public void setMultipic(boolean multipic) {
        this.multipic = multipic;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}

