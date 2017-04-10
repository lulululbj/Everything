package luyao.everything.api;

import luyao.everything.base.mvp.BaseView;
import rx.Subscriber;

/**
 * Created by Lu
 * on 2017/04/06 16:09
 */

public abstract class BaseSubscriber2<T> extends Subscriber<T> {

    private BaseView v;

    public BaseSubscriber2(BaseView v) {
        this.v = v;
    }

    @Override
    public void onCompleted() {
        v.onRequestEnd();
    }

    @Override
    public void onError(Throwable e) {
        v.onRequestError(e.getMessage());
    }

    @Override
    public void onNext(T t) {
    }

    @Override
    public void onStart() {
        v.onRequestStart();
    }
}

