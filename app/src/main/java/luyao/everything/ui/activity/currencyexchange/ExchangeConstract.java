package luyao.everything.ui.activity.currencyexchange;


import luyao.everything.base.mvp.BaseModel;
import luyao.everything.base.mvp.BasePresenter;
import luyao.everything.base.mvp.BaseView;
import luyao.everything.enity.ExcangeResult;
import rx.Observable;

/**
 * 契约类，约定功能方法
 * 定义View，Model接口和Presenter抽象类
 * Created by Lu
 * on 2017/04/06 15:20
 */

public interface ExchangeConstract {

    interface View extends BaseView {
        void getExchange(ExcangeResult result);
    }

    interface Model extends BaseModel {
        Observable<ExcangeResult> getExchange(String code);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        abstract void getExchange(String code);
    }

}
