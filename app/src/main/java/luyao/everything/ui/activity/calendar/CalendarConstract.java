package luyao.everything.ui.activity.calendar;

import luyao.everything.base.mvp.BaseModel;
import luyao.everything.base.mvp.BasePresenter;
import luyao.everything.base.mvp.BaseView;
import luyao.everything.enity.CalendarFortune;
import rx.Observable;

/**
 * Created by Lu
 * on 2017/04/10 17:09
 */

public interface CalendarConstract {

    interface View extends BaseView{
        void getFortune(CalendarFortune fortune);
    }

    interface Model extends BaseModel{
        Observable<CalendarFortune> getFortune(String date);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        abstract void getFortune(String date);
    }
}
