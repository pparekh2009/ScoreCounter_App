package com.priyanshparekh.scorecounter;

import android.app.Activity;
import android.content.Context;
import android.widget.RelativeLayout;

import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;

public class UnityAd {

    String unityGameId = "4402543";
    String adUnitId = "Banner_Android";
    boolean testMode = true;
    boolean enableLoad = true;

    BannerView bannerView;
    RelativeLayout bannerLayout;

    UnityBannerListener bannerListener = new UnityBannerListener();

    public void loadAd(Activity activity, int layoutId) {

        UnityAds.initialize(activity, unityGameId, null, testMode, enableLoad);

        bannerView = new BannerView(activity, adUnitId, new UnityBannerSize(320, 50));
        bannerView.setListener(bannerListener);
        bannerView.load();

        bannerLayout = activity.findViewById(layoutId);
        bannerLayout.addView(bannerView);
    }

    private class UnityBannerListener implements BannerView.IListener, IUnityAdsListener {

        @Override
        public void onUnityAdsReady(String s) {

        }

        @Override
        public void onUnityAdsStart(String s) {

        }

        @Override
        public void onUnityAdsFinish(String s, UnityAds.FinishState finishState) {

        }

        @Override
        public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String s) {

        }

        @Override
        public void onBannerLoaded(BannerView bannerView) {

        }

        @Override
        public void onBannerClick(BannerView bannerView) {

        }

        @Override
        public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {

        }

        @Override
        public void onBannerLeftApplication(BannerView bannerView) {

        }
    }
}
