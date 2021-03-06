package com.moderncreation.mediasliderlibrary;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.moderncreation.mediasliderlibrary.View.MediaSliderItem;
import com.moderncreation.mediasliderlibrary.databinding.FragmentSimpleImageBinding;


/**
 * A simple {@link Fragment} subclass.
 */
 public class SimpleImageFragment extends Fragment implements MediaSliderItem {

    private String sURL;
    public final MEDIA MEDIA_TYPE;
    private ImageView imageView;
    private int placeholderImage;


    public SimpleImageFragment() {
        MEDIA_TYPE = MEDIA.IMAGE;
        // Required empty public constructor
    }


    @Override
    public MEDIA getType() {
        return MEDIA_TYPE;
    }

    @Override
    public void setURL(String url) {
        sURL = url;
    }
    public String getURL() {
        return sURL;
    }

    public int getPlaceholderImage() {
        return placeholderImage;
    }

    public void setPlaceholderImage(int placeholderImage) {
        this.placeholderImage = placeholderImage;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentSimpleImageBinding binding = FragmentSimpleImageBinding.inflate(inflater, container, false);
        imageView = binding.sliderImg;


        Glide.with(getContext())
                .load(sURL)
                .apply(RequestOptions.fitCenterTransform().fitCenter())
                .into(imageView);

        return binding.getRoot();

    }

    public ImageView getImageView() {
        return imageView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}
