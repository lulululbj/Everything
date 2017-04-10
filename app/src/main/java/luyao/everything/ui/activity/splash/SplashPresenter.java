package luyao.everything.ui.activity.splash;

import java.util.List;

import luyao.everything.api.BaseSubscriber2;
import luyao.everything.enity.BingImageBean;
import luyao.everything.enity.area.Province;
import rx.Subscription;

/**
 * Created by Lu
 * on 2017/04/10 15:13
 */

public class SplashPresenter extends SplashConstract.Presenter {


    public SplashPresenter(SplashConstract.View view) {
        mView = view;
        mModel = new SplashModel();
    }

    @Override
    void getBingImg() {
        Subscription subscription = mModel.getBingImg()
                .subscribe(new BaseSubscriber2<BingImageBean>(mView) {
                    @Override
                    public void onNext(BingImageBean bingImageBean) {
                        mView.getBingImg(bingImageBean);
                    }
                });
        addSubscribe(subscription);
    }

    @Override
    void getCityList() {
        Subscription subscription = mModel.getCityList()
                .subscribe(new BaseSubscriber2<List<Province>>(mView) {
                    @Override
                    public void onNext(List<Province> list) {
                        mView.getCityList(list);
                    }
                });
        addSubscribe(subscription);
    }
}
