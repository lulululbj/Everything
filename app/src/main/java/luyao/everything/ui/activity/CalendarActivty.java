package luyao.everything.ui.activity;

import android.provider.Settings;
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
import luyao.everything.utils.TimeUtils;
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
        title_tv.setText(R.string.calendar);
        datePicker.setDate(2016,11);
        datePicker.setMode(DPMode.SINGLE);
        getCalendarData(TimeUtils.LongToTime(Long.toString(System.currentTimeMillis()),"yyyy-MM-dd"));
    }

    @Override
    protected void initData() {
        datePicker.setOnDatePickedListener(new DatePicker.OnDatePickedListener() {
            @Override
            public void onDatePicked(String date) {
                getCalendarData(date);
            }
        });
    }

    @Override
    protected void clickBack() {
        onBackPressed();
    }

    private void getCalendarData(String date){
        Api.getInstance().getTodayFortune(new BaseSubscriber<CalendarFortune>() {
            @Override
            public void onNext(CalendarFortune calendarFortune) {
                LogUtils.e("calendar",calendarFortune.toString());
                lunar.setText(calendarFortune.getLunar());
                lunarYear.setText(String.format("%s年",calendarFortune.getLunarYear()));
                avoid.setText(String.format("宜：%s",calendarFortune.getAvoid()));
                suit.setText(String.format("忌：%s",calendarFortune.getSuit()));
                zodiac.setText(calendarFortune.getZodiac());
            }
        }, date);
    }

}
