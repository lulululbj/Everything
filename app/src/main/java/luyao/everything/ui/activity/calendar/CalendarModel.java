package luyao.everything.ui.activity.calendar;

import luyao.everything.api.Api;
import luyao.everything.api.HttpResultFunc;
import luyao.everything.base.mvp.RxSchedulers;
import luyao.everything.enity.CalendarFortune;
import luyao.everything.utils.Constants;
import rx.Observable;

/**
 * Created by Lu
 * on 2017/04/10 17:12
 */

public class CalendarModel implements CalendarConstract.Model {
    @Override
    public Observable<CalendarFortune> getFortune(String date) {
        return Api.getInstance().getApiSerVice()
                .getTodayFortune(Constants.MOB_APPKEY,date)
                .map(new HttpResultFunc<CalendarFortune>())
                .compose(RxSchedulers.<CalendarFortune>switchThread());
    }
}
