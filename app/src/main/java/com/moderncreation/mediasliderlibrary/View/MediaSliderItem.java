package com.moderncreation.mediasliderlibrary.View;

/**
 * Created by lyo on 2017. 11. 24..
 */

public interface MediaSliderItem {

    void setURL(String url);
    MEDIA getType();

    enum MEDIA {
        IMAGE,
        VIDEO
    }

    abstract void imageLoad();

}
