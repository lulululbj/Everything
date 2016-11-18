package luyao.everything.ui.activity;

import android.widget.TextView;

import butterknife.BindView;
import luyao.everything.R;
import luyao.everything.api.Api;
import luyao.everything.api.BaseSubscriber;
import luyao.everything.base.BaseActivity;
import luyao.everything.enity.CalendarFortune;
import rx.Subscriber;

/**
 * 万年历
 * Created by Lu
 * on 2016/11/18 14:15.
 */

public class CalendarActivty extends BaseActivity {

    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_calendar;
    }

    @Override
    protected void initView() {
        Api.getInstance().getTodayFortune(subscriber,"2016-11-18");
        title_tv.setText(R.string.calendar);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void clickBack() {
        finish();
    }

    Subscriber<CalendarFortune> subscriber=new BaseSubscriber<CalendarFortune>() {
        @Override
        public void onNext(CalendarFortune calendarFortune) {
             tv.setText(calendarFortune.toString());
        }
    };
}
