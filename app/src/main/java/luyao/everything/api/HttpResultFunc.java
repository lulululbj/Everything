package luyao.everything.api;

/**
 * Created by Lu
 * on 2017/04/06 15:35
 */

import luyao.everything.enity.HttpResult;
import rx.functions.Func1;

/**
 * 用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
 *
 * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
 */
public class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

    @Override
    public T call(HttpResult<T> httpResult) {
//            if (httpResult.get() != 0) {
//                throw new ApiException(httpResult.getResultCode());
//            }
        return httpResult.getResult();
    }
}
