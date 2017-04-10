package luyao.everything.ui.activity.calendar;

import android.widget.TextView;

import butterknife.BindView;
import cn.aigestudio.datepicker.cons.DPMode;
import cn.aigestudio.datepicker.views.DatePicker;
import luyao.everything.R;
import luyao.everything.base.mvp.BaseMvpActivity;
import luyao.everything.enity.CalendarFortune;
import luyao.everything.utils.LogUtils;
import luyao.everything.utils.TimeUtils;

/**
 * 万年历
 * Created by Lu
 * on 2016/11/18 14:15.
 */

public class CalendarActivty extends BaseMvpActivity<CalendarPresenter> implements CalendarConstract.View {

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
    protected CalendarPresenter createPresenter() {
        return new CalendarPresenter(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_calendar;
    }

    @Override
    protected void initView() {

//        CrashReport.testJavaCrash();
        title_tv.setText(R.string.calendar);
        datePicker.setDate(TimeUtils.getNowYear(), TimeUtils.getNowMonth() + 1);
        datePicker.setMode(DPMode.SINGLE);
        mPresenter.getFortune(TimeUtils.LongToTime(Long.toString(System.currentTimeMillis()), "yyyy-MM-dd"));
    }

    @Override
    protected void initData() {
        datePicker.setOnDatePickedListener(new DatePicker.OnDatePickedListener() {
            @Override
            public void onDatePicked(String date) {
                mPresenter.getFortune(date);
            }
        });
    }

    @Override
    protected void clickBack() {
        onBackPressed();
    }


    @Override
    public void getFortune(CalendarFortune calendarFortune) {
        LogUtils.e("calendar", calendarFortune.toString());
        lunar.setText(calendarFortune.getLunar());
        lunarYear.setText(String.format("%s年", calendarFortune.getLunarYear()));
        avoid.setText(String.format("宜：%s", calendarFortune.getAvoid()));
        suit.setText(String.format("忌：%s", calendarFortune.getSuit()));
        zodiac.setText(calendarFortune.getZodiac());
    }
}
