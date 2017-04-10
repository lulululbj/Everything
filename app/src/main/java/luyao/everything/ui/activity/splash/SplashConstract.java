package luyao.everything.ui.activity.splash;



import java.util.List;

import luyao.everything.base.mvp.BaseModel;
import luyao.everything.base.mvp.BasePresenter;
import luyao.everything.base.mvp.BaseView;
import luyao.everything.enity.BingImageBean;
import luyao.everything.enity.area.Province;
import rx.Observable;

/**
 * Created by Lu
 * on 2017/04/10 15:07
 */

public interface SplashConstract {

    interface View extends BaseView{
        void getBingImg(BingImageBean bingImage);
        void getCityList(List<Province> list);
    }

    interface Model extends BaseModel{
        Observable<BingImageBean> getBingImg();
        Observable<List<Province>> getCityList();
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        abstract void getBingImg();
        abstract void getCityList();
    }
}
