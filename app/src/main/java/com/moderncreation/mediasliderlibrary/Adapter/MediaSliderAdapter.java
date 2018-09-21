package com.moderncreation.mediasliderlibrary.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.google.android.youtube.player.YouTubePlayer;
import com.moderncreation.mediasliderlibrary.SimpleImageFragment;
import com.moderncreation.mediasliderlibrary.View.MediaSliderItem;
import com.moderncreation.mediasliderlibrary.Youtube.YouTubePlayerSupportCustomFragment;

import java.util.ArrayList;
import java.util.List;

public class MediaSliderAdapter extends FragmentStatePagerAdapter implements IconPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();
    private List<YouTubePlayer> players = new ArrayList<>();
    private ViewPager.OnPageChangeListener mChangeListener;
    private boolean isInit = true;


    public MediaSliderAdapter(FragmentManager fm) {
        super(fm);
        setChangeListener();
    }

    private void setChangeListener() {
        mChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < getCount(); i++) {
                    if (i != position && ((MediaSliderItem) fragments.get(i)).getType() == MediaSliderItem.MEDIA.VIDEO) {
                        YouTubePlayerSupportCustomFragment f = (YouTubePlayerSupportCustomFragment) fragments.get(i);
                        if (f.isLoading()) {
                            f.onRelease();
                        }
                    }
                }
                if (((MediaSliderItem) fragments.get(position)).getType() == MediaSliderItem.MEDIA.VIDEO) {
                    YouTubePlayerSupportCustomFragment mFregment = (YouTubePlayerSupportCustomFragment) fragments.get(position);
                    mFregment.onLoad();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
    }

    @Override

    public int getItemPosition(Object object) {


        return POSITION_NONE;
    }

    public ViewPager.OnPageChangeListener getChangeListener() {
        if (null == mChangeListener) {
            setChangeListener();
        }
        return mChangeListener;
    }

    public void addMedia(String url, MediaSliderItem.MEDIA type) {

        Fragment f = null;

        if (MediaSliderItem.MEDIA.IMAGE == type) {
            f = new SimpleImageFragment();
        } else if (MediaSliderItem.MEDIA.VIDEO == type) {
            f = new YouTubePlayerSupportCustomFragment();
        }


        ((MediaSliderItem) f).setURL(url);
        fragments.add(f);

        notifyDataSetChanged();

    }

    public void remove(MediaSliderItem.MEDIA type) {

        List<Fragment> tmp = new ArrayList<>(fragments);
        for (Fragment f : tmp) {
            if (type == MediaSliderItem.MEDIA.IMAGE && ((MediaSliderItem) f).getType() == MediaSliderItem.MEDIA.IMAGE) {
                fragments.remove(f);
            } else if (type == MediaSliderItem.MEDIA.VIDEO && ((MediaSliderItem) f).getType() == MediaSliderItem.MEDIA.VIDEO) {
                fragments.remove(f);
            }

        }


    }

    @Override
    public Fragment getItem(int position) {
        MediaSliderItem mFregment = null;

        if (((MediaSliderItem) fragments.get(position)).getType() == MediaSliderItem.MEDIA.VIDEO) {
            mFregment = (MediaSliderItem) fragments.get(position);

            if (isInit) {
                ((YouTubePlayerSupportCustomFragment) mFregment).onLoad();
                isInit = false;
            }

        }
//        else if(((MediaSliderItem)fragments.get(position)).getType() == MediaSliderItem.MEDIA.IMAGE){
//            mFregment = (MediaSliderItem) fragments.get(position);
//        }

        return fragments.get(position);
    }


    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

    @Override
    public int getIconResId(int index) {
        return -1;
    }

    public void setCount(int count) {

        if (count > 0 && count <= 10) {
//            mCount = count;
//            notifyDataSetChanged();
        }
    }


}


