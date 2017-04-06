package luyao.everything.ui.activity.currencyexchange;



import luyao.everything.api.Api;
import luyao.everything.api.HttpResultFunc;
import luyao.everything.base.mvp.RxSchedulers;
import luyao.everything.enity.ExcangeResult;
import luyao.everything.utils.Constants;
import rx.Observable;

/**
 * Created by Lu
 * on 2017/04/06 15:26
 */

public class ExchangeModel implements ExchangeConstract.Model {


    @Override
    public Observable<ExcangeResult> getExchange(String code) {
        return Api.getInstance()
                .getApiSerVice()
                .getExchangeResult(Constants.MOB_APPKEY, code)
                .map(new HttpResultFunc<ExcangeResult>())
                .compose(RxSchedulers.<ExcangeResult>switchThread());
    }
}
