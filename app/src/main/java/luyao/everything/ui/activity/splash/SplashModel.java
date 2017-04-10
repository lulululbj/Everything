package luyao.everything.ui.activity.splash;


import java.util.List;

import luyao.everything.api.Api;
import luyao.everything.api.HttpResultFunc;
import luyao.everything.base.mvp.RxSchedulers;
import luyao.everything.enity.BingImageBean;
import luyao.everything.enity.area.Province;
import luyao.everything.utils.Constants;
import rx.Observable;

/**
 * Created by Lu
 * on 2017/04/10 15:10
 */

public class SplashModel implements SplashConstract.Model {
    @Override
    public Observable<BingImageBean> getBingImg() {
        return Api.getInstance().getApiSerVice()
                .getBingImage()
                .compose(RxSchedulers.<BingImageBean>switchThread());
    }

    @Override
    public Observable<List<Province>> getCityList() {
        return Api.getInstance().getApiSerVice()
                .getCity(Constants.MOB_APPKEY)
                .map(new HttpResultFunc<List<Province>>())
                .compose(RxSchedulers.<List<Province>>switchThread());
    }
}
