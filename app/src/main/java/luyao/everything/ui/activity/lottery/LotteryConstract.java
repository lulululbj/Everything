package luyao.everything.ui.activity.lottery;

import java.util.List;

import luyao.everything.base.mvp.BaseModel;
import luyao.everything.base.mvp.BasePresenter;
import luyao.everything.base.mvp.BaseView;
import rx.Observable;

/**
 * Created by Lu
 * on 2017/04/06 16:54
 */

public interface LotteryConstract {

    interface View extends BaseView{
        void getLotteryList(List<String> list);
    }

    interface Model extends BaseModel{
       Observable<List<String>>  getLotteryList();
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        abstract void getLotteryList();
    }
}
