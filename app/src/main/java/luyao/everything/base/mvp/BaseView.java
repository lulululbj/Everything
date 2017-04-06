package luyao.everything.base.mvp;

/**
 * Created by Lu
 * on 2017/04/06 15:08
 */

public interface BaseView {

    void onRequestStart();

    void onRequestError(String msg);

    void onRequestEnd();

    void onNetError();
}
