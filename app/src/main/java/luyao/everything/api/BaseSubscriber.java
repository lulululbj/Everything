package luyao.everything.api;

import rx.Subscriber;

/**
 * Created by Lu
 * on 2016/11/15 17:43.
 */

public abstract class BaseSubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(T t) {

    }
}
