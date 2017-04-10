package luyao.everything.ui.activity.calendar;

import luyao.everything.api.BaseSubscriber2;
import luyao.everything.enity.CalendarFortune;
import rx.Subscription;

/**
 * Created by Lu
 * on 2017/04/10 17:16
 */

public class CalendarPresenter extends CalendarConstract.Presenter {

    public CalendarPresenter(CalendarConstract.View view){
        mView=view;
        mModel=new CalendarModel();
    }
    @Override
    void getFortune(String date) {
        Subscription subscription=mModel.getFortune(date)
                .subscribe(new BaseSubscriber2<CalendarFortune>(mView) {
                    @Override
                    public void onNext(CalendarFortune fortune) {
                        mView.getFortune(fortune);
                    }
                });
    }
}
