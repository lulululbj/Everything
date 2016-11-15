package luyao.everything.enity;

/**
 * Created by Lu
 * on 2016/11/15 14:05.
 */

public class HttpResult<T> {

    private String msg;
    private String retCode;
    private T result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
