package com.free.zhou.guide.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zskzh on 2017/5/1.
 */

public class GuidePic implements Serializable {


    private List<CreativesBean> creatives;

    public List<CreativesBean> getCreatives() {
        return creatives;
    }

    public void setCreatives(List<CreativesBean> creatives) {
        this.creatives = creatives;
    }

    public static class CreativesBean {
        /**
         * url : https://pic4.zhimg.com/v2-e78323f847d52e2e3c7db6107b09f533.jpg
         * start_time : 1493606500
         * impression_tracks : ["https://sugar.zhihu.com/track?vs=1&ai=3957&ut=&cg=2&ts=1493606500.21&si=a8852224efdc4a58b49967f0061082b7&lu=0&hn=ad-engine.ad-engine.882b0684&at=impression&pf=PC&az=11&sg=fe04ea0404729419da286b40bdfb340a"]
         * type : 0
         * id : 3957
         */

        private String url;
        private int start_time;
        private int type;
        private String id;
        private List<String> impression_tracks;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getStart_time() {
            return start_time;
        }

        public void setStart_time(int start_time) {
            this.start_time = start_time;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getImpression_tracks() {
            return impression_tracks;
        }

        public void setImpression_tracks(List<String> impression_tracks) {
            this.impression_tracks = impression_tracks;
        }
    }
}
