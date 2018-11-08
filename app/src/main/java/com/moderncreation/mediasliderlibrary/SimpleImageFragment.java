package com.moderncreation.mediasliderlibrary;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.moderncreation.mediasliderlibrary.View.MediaSliderItem;
import com.moderncreation.mediasliderlibrary.databinding.FragmentSimpleImageBinding;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleImageFragment extends Fragment implements MediaSliderItem {

    private String sURL;
    public final MEDIA MEDIA_TYPE;
    ImageView imageView;


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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentSimpleImageBinding binding = FragmentSimpleImageBinding.inflate(inflater, container, false);
        imageView = binding.sliderImg;

        Picasso.with(getContext())
                .load(sURL)
                .into(imageView);


        Log.e("SimpleImageFragment", sURL);
        return binding.getRoot();

    }

}
