package luyao.everything.ui.activity.currencyexchange;

import luyao.everything.api.BaseSubscriber2;
import luyao.everything.enity.ExcangeResult;
import rx.Subscription;

/**
 * Created by Lu
 * on 2017/04/06 15:39
 */

public class ExchangePresenter extends ExchangeConstract.Presenter {

    public ExchangePresenter(ExchangeConstract.View view) {
        mView = view;
        mModel = new ExchangeModel();
    }


    @Override
    void getExchange(String code) {
        Subscription subscription = mModel.getExchange(code)
                .subscribe(new BaseSubscriber2<ExcangeResult>(mView) {
                    @Override
                    public void onNext(ExcangeResult result) {
                        mView.getExchange(result);
                    }
                });

        addSubscribe(subscription);
    }
}
