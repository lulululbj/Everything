package luyao.everything.ui.activity;

import android.widget.TextView;

import butterknife.BindView;
import cn.aigestudio.datepicker.cons.DPMode;
import cn.aigestudio.datepicker.views.DatePicker;
import luyao.everything.R;
import luyao.everything.api.Api;
import luyao.everything.api.BaseSubscriber;
import luyao.everything.base.BaseActivity;
import luyao.everything.enity.CalendarFortune;
import luyao.everything.utils.LogUtils;
import luyao.everything.utils.ToastUtil;
import rx.Subscriber;

/**
 * 万年历
 * Created by Lu
 * on 2016/11/18 14:15.
 */

public class CalendarActivty extends BaseActivity {

    @BindView(R.id.datePicker)
    DatePicker datePicker;
    @BindView(R.id.lunar)
    TextView lunar;
    @BindView(R.id.lunarYear)
    TextView lunarYear;
    @BindView(R.id.zodiac)
    TextView zodiac;
    @BindView(R.id.suit)
    TextView suit;
    @BindView(R.id.avoid)
    TextView avoid;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_calendar;
    }

    @Override
    protected void initView() {
        datePicker.setDate(2016,11);
        datePicker.setMode(DPMode.SINGLE);

    }

    @Override
    protected void initData() {
        datePicker.setOnDatePickedListener(new DatePicker.OnDatePickedListener() {
            @Override
            public void onDatePicked(String date) {
                Api.getInstance().getTodayFortune(new BaseSubscriber<CalendarFortune>() {
                    @Override
                    public void onNext(CalendarFortune calendarFortune) {
                        LogUtils.e("calendar",calendarFortune.toString());
                        lunar.setText(calendarFortune.getLunar());
                        lunarYear.setText(calendarFortune.getLunarYear());
                        avoid.setText(calendarFortune.getAvoid());
                        suit.setText(calendarFortune.getSuit());
                        zodiac.setText(calendarFortune.getZodiac());
                    }
                }, date);
            }
        });
    }

}
