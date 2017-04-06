package luyao.everything.ui.activity.lottery;

import java.util.List;

import luyao.everything.api.Api;
import luyao.everything.api.HttpResultFunc;
import luyao.everything.base.mvp.RxSchedulers;
import luyao.everything.utils.Constants;
import rx.Observable;

/**
 * Created by Lu
 * on 2017/04/06 17:00
 */

public class LotteryModel implements LotteryConstract.Model {

    @Override
    public Observable<List<String>> getLotteryList() {
        return Api.getInstance()
                .getApiSerVice()
                .getLotteryList(Constants.MOB_APPKEY)
                .map(new HttpResultFunc<List<String>>())
                .compose(RxSchedulers.<List<String>>switchThread());
    }
}
