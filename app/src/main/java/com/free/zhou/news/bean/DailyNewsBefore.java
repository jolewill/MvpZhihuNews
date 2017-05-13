package com.free.zhou.news.bean;

import java.util.List;

/**
 * Created by zskzh on 2017/5/1.
 */

public class DailyNewsBefore {


    /**
     * date : 20170228
     * stories : [{"images":["http://pic3.zhimg.com/5e8fc9a52a484ee12977ade71bcf9a9e.jpg"],"type":0,"id":9255939,"ga_prefix":"022822","title":"小事 · 人生如逆旅，我亦是行人"},{"images":["http://pic2.zhimg.com/25640c853303d4306946177e120b7499.jpg"],"type":0,"id":9255735,"ga_prefix":"022821","title":"奥斯卡 · 最佳动画长片《疯狂动物城》，隔了一年再看小动物还是只有服"},{"images":["http://pic1.zhimg.com/63c1cc81f90ca57e09f7166c30e39dc8.jpg"],"type":0,"id":9256088,"ga_prefix":"022820","title":"压着怒火哄孩子说没事儿，渐渐变得不管用了"},{"images":["http://pic2.zhimg.com/568bb270f57f4c21a05d7c80b5f16505.jpg"],"type":0,"id":9256190,"ga_prefix":"022819","title":"不好看也不健康的 X／O型腿应该如何「防与治」？"},{"title":"数学中有哪些巧合让人眼前一亮？","ga_prefix":"022818","images":["http://pic1.zhimg.com/d55638d4d13740bf082949771400f1ac.jpg"],"multipic":true,"type":0,"id":9255310},{"images":["http://pic2.zhimg.com/62749744d6aef3b1f87ff2b9587d0cad.jpg"],"type":0,"id":9256044,"ga_prefix":"022818","title":"谁能成为第四届「知乎盐 Club 荣誉会员」，就看你了"},{"images":["http://pic3.zhimg.com/d391fd54bf0da7b244561d2300b8738a.jpg"],"type":0,"id":9256058,"ga_prefix":"022817","title":"诸葛亮想和曹操猜拳，可两人身处异地无法见面"},{"images":["http://pic4.zhimg.com/80bed5feba33a1c2e8eba540349d7b9f.jpg"],"type":0,"id":9255960,"ga_prefix":"022816","title":"2013 年小米做了很多事，官方编年史上却一片空白"},{"images":["http://pic3.zhimg.com/04b1e2bdaff37058eea45ca38b04d6f6.jpg"],"type":0,"id":9255787,"ga_prefix":"022815","title":"我们离电影《终结者》中的人形机器人还有多远？"},{"images":["http://pic3.zhimg.com/f5eff1f35620087dd414e80c7637560a.jpg"],"type":0,"id":9255432,"ga_prefix":"022814","title":"浓妆和淡妆哪个更好，这是科学家们的研究"},{"images":["http://pic2.zhimg.com/552cfcbdf5b22d1838778c272a542cb5.jpg"],"type":0,"id":9244950,"ga_prefix":"022813","title":"人人都应该知道的妇科常识有哪些？"},{"images":["http://pic1.zhimg.com/7030eb90d16264414932205d2aa48e08.jpg"],"type":0,"id":9255165,"ga_prefix":"022812","title":"大误 · 二月二是个好日子"},{"title":"建立预期，选好搭配，对牛油果「路转粉」之后就停不下来","ga_prefix":"022811","images":["http://pic4.zhimg.com/33e42614637e81a5746d7d84bf9dfc87.jpg"],"multipic":true,"type":0,"id":9254457},{"images":["http://pic2.zhimg.com/d8f36004628c4d1a3b6d1e2be7e81591.jpg"],"type":0,"id":9251246,"ga_prefix":"022810","title":"真正的吃货，一口就尝出冷鲜奶和常温奶的区别"},{"title":"我在洛杉矶找到了《爱乐之城》里关于爱的 15 个地点","ga_prefix":"022809","images":["http://pic3.zhimg.com/b0df0cc5e98fbac6ff7fd821b4057426.jpg"],"multipic":true,"type":0,"id":9254337},{"images":["http://pic3.zhimg.com/a66e7586025c20eadda9350a5ced1d2a.jpg"],"type":0,"id":9253808,"ga_prefix":"022808","title":"作为一名眼科医生，我想说「洗眼液」真的没什么用"},{"images":["http://pic3.zhimg.com/2a9a83a7a5a2c69d887c63cccb2a2a16.jpg"],"type":0,"id":9253270,"ga_prefix":"022807","title":"偏远的奥特莱斯，难用的录像机，都是为了赚钱专门设计的"},{"images":["http://pic2.zhimg.com/d3642908f3881056cd969eae16d025fd.jpg"],"type":0,"id":9254324,"ga_prefix":"022807","title":"奥斯卡 · 本届影帝有个很红的哥哥，还有更多的爱和更清醒的「任性」"},{"images":["http://pic2.zhimg.com/2bc3ef8df694da1ba2a29674b7d40d25.jpg"],"type":0,"id":9253384,"ga_prefix":"022807","title":"巨头出手，共享单车领域的决定性战役即将开启？"},{"images":["http://pic2.zhimg.com/6f924666559fd601d02a219b4eace4d9.jpg"],"type":0,"id":9244327,"ga_prefix":"022806","title":"瞎扯 · 如何正确地吐槽"}]
     */

    private String date;
    private List<StoriesBean> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

   /* public static class StoriesBean {
        *//**
         * images : ["http://pic3.zhimg.com/5e8fc9a52a484ee12977ade71bcf9a9e.jpg"]
         * type : 0
         * id : 9255939
         * ga_prefix : 022822
         * title : 小事 · 人生如逆旅，我亦是行人
         * multipic : true
         *//*

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

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

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }*/
}
