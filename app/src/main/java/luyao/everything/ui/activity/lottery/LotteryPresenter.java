package luyao.everything.ui.activity.lottery;

import java.util.List;

import luyao.everything.api.BaseSubscriber2;
import rx.Subscription;

/**
 * Created by Lu
 * on 2017/04/06 17:04
 */

public class LotteryPresenter extends LotteryConstract.Presenter {

    public LotteryPresenter(LotteryConstract.View view) {
        mView = view;
        mModel = new LotteryModel();
    }

    @Override
    void getLotteryList() {
        Subscription subscription = mModel.getLotteryList()
                .subscribe(new BaseSubscriber2<List<String>>(mView) {
                    @Override
                    public void onNext(List<String> strings) {
                        mView.getLotteryList(strings);
                    }
                });
        addSubscribe(subscription);
    }
}
