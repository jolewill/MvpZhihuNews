package com.free.zhou.news.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.free.zhou.mvpzhihunews.R;
import com.free.zhou.newsinfo.NewsInfoActivity;
import com.yuyh.library.imgsel.bean.Image;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "url";
    private static final String ARG_PARAM2 = "text";
    private static final String ARG_PARAM3 = "id";
    private static final String TITLE = "title";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String id;
    private String title;

    @Bind(R.id.tv_title)
    TextView textView;
    @Bind(R.id.iv_image)
    ImageView imageView;


    public ImageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ImageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ImageFragment newInstance(String param1, String param2, String id, String title) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, id);
        args.putString(TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            id = getArguments().getString(ARG_PARAM3);
            title = getArguments().getString(TITLE);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =
                inflater.inflate(R.layout.fragment_image, container, false);

        ButterKnife.bind(this, view);
        textView.setText(title);
        textView.setText(mParam2);
        Glide.with(this).load(mParam1).centerCrop().into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), NewsInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("ID", id);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        return view;

    }

}
