package com.free.zhou.news.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.free.zhou.guide.contract.GuideImageContract;
import com.free.zhou.mvpzhihunews.R;
import com.free.zhou.news.bean.DailyNews;
import com.free.zhou.news.bean.StoriesBean;
import com.free.zhou.news.contract.StoryContract;
import com.free.zhou.news.fragment.ImageFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zskzh on 2017/5/12.
 */

public class StoryRvAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ITEM_IMAGE = 1;
    private static final int ITEM_STORY = 2;
    private static final int ITEM_FOOT = 3;
    private List<Object> list = new ArrayList<>();
    private Context context;
    private LayoutInflater layoutInflater;
    private AppCompatActivity activity;

    private OnClickListen onClickListen;


    public void setOnClickListen(OnClickListen onClickListen) {

        this.onClickListen = onClickListen;

    }


    public StoryRvAdapter(List<Object> list, Context context, AppCompatActivity activity) {
        this.list = list;
        this.context = context;
        this.activity = activity;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_IMAGE) {
            View view = layoutInflater.inflate(R.layout.item_view_pager, parent, false);
            return new ImageViewHolder(view);
        }
        if (viewType == ITEM_STORY) {
            View view = layoutInflater.inflate(R.layout.item_story, parent, false);
            return new StoryViewHolder(view);
        }
        if (viewType == ITEM_FOOT) {
            View view = layoutInflater.inflate(R.layout.footer, parent, false);
            return new FooterViewHolder(view);
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case ITEM_IMAGE:
                ImageViewHolder imageViewHolder = (ImageViewHolder) holder;
                List<DailyNews.TopStoriesBean> topStoriesBean = (List<DailyNews.TopStoriesBean>) list.get(position);
                getPagerView(imageViewHolder.viewGroup, imageViewHolder.viewPager, topStoriesBean);
                break;
            case ITEM_STORY:
                StoryViewHolder storyViewHolder = (StoryViewHolder) holder;
                StoriesBean bean = ((StoriesBean) list.get(position));
                storyViewHolder.tv_title.setText(bean.getTitle());
                storyViewHolder.bindView(bean);
                storyViewHolder.setOnClickInterface(onClickListen1);

                Glide.with(context).load(bean.getImages().get(0)).into(storyViewHolder.iv_title);
                break;
            case ITEM_FOOT:
                break;
        }
    }

    OnClickListen onClickListen1 = new OnClickListen() {
        @Override
        public void onClick(StoriesBean storiesBean, int position, View view) {
            onClickListen.onClick(storiesBean, position, view);
        }
    };


    /**
     * 显示viewPager
     */
    private void getPagerView(ViewGroup viewGroup, ViewPager viewPager, List<DailyNews.TopStoriesBean> topStoriesBeanList) {

        // List<DailyNews.TopStoriesBean> topStoriesBeanList = (List<DailyNews.TopStoriesBean>) list.get(position);

        ImageView[] imageViews = new ImageView[topStoriesBeanList.size()];

        List<Fragment> topImageViewlist = new ArrayList<>();
        viewGroup.removeAllViews(); //
        for (int i = 0; i < topStoriesBeanList.size(); i++) {


          /*  *//** 图片显示*//*
            ViewGroup.LayoutParams lps = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            ImageView imageViewForPic = new ImageView(context);
            imageViewForPic.setLayoutParams(lps);
            Glide.with(context).load(topStoriesBeanList.get(i).getImage()).centerCrop().into(imageViewForPic);
         */

            ImageFragment imageFragment = ImageFragment.newInstance(topStoriesBeanList.get(i).getImage(), topStoriesBeanList.get(i).getTitle(),
                    topStoriesBeanList.get(i).getId() + "");
            topImageViewlist.add(imageFragment);

            /** 图片指示器的显示*/
            ImageView imageViewForDot = new ImageView(context);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(15, 15);
            params.setMargins(5, 0, 5, 0);
            imageViewForDot.setLayoutParams(params);
            imageViewForDot.setClickable(false);
            imageViews[i] = imageViewForDot;
            if (i == 0) {
                imageViews[i]
                        .setBackgroundResource(R.drawable.point_sel);
            } else {
                imageViews[i].setBackgroundResource(R.drawable.point_nor);
            }
            viewGroup.addView(imageViews[i]);
        }

        //  ChangePageAdapter changePageAdapter = new ChangePageAdapter(topImageViewlist);
        FragmentPagerAdapter adapter = new ImageFragmentPagerAdapter(activity.getSupportFragmentManager(), topImageViewlist);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new PagerListener(topImageViewlist, imageViews, viewPager));


    }


    class PagerListener implements ViewPager.OnPageChangeListener {

        private List<Fragment> list = new ArrayList<>();
        private ImageView[] imageViews;

        private ViewPager viewPager;

        public PagerListener(List<Fragment> list, ImageView[] imageViews, ViewPager viewPager) {
            this.list = list;
            this.imageViews = imageViews;
            this.viewPager = viewPager;
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            if (position == list.size()) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() == (list
                        .size() - 1) ? 0 : (viewPager.getCurrentItem() + 1));
            }
            for (int i = 0; i < imageViews.length; i++) {
                if (position != i) {
                    imageViews[i].setImageResource(R.drawable.point_nor);
                } else {
                    imageViews[i].setImageResource(R.drawable.point_sel);
                }
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }


    @Override
    public int getItemViewType(int position) {
        if (list.get(position) instanceof StoriesBean) {
            return ITEM_STORY;
        } else if (list.get(position) instanceof String) {
            return ITEM_FOOT;
        } else {
            return ITEM_IMAGE;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.viewPager)
        ViewPager viewPager;
        @Bind(R.id.linearLayout)
        ViewGroup viewGroup;

        public ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class StoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.iv_title)
        ImageView iv_title;
        @Bind(R.id.tv_title)
        TextView tv_title;

        OnClickListen onClickInterface;

        public StoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void setOnClickInterface(OnClickListen clickInterface) {
            this.onClickInterface = clickInterface;
        }

        public void bindView(StoriesBean storiesBean) {
            itemView.setTag(storiesBean);
        }

        @Override
        public void onClick(View v) {
            onClickInterface.onClick((StoriesBean) v.getTag(), getLayoutPosition(), v);
        }
    }

    class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }

    public interface OnClickListen {
        void onClick(StoriesBean storiesBean, int position, View view);
    }
}
