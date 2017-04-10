package luyao.everything.base.mvp;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Lu
 * on 2017/04/06 15:09
 */

public class BasePresenter<V extends BaseView, M extends BaseModel> {

    protected V mView;
    protected M mModel;

    private CompositeSubscription mSubscription;

    protected void addSubscribe(Subscription subscription) {
        if (mSubscription == null)
            mSubscription = new CompositeSubscription();
        mSubscription.add(subscription);
    }

    public void unSubscribe() {
        if (mView != null)
            mView = null;
        if (mSubscription != null && mSubscription.hasSubscriptions())
            mSubscription.clear();
    }
}
