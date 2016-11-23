package luyao.everything.enity;

/**
 * Created by Lu
 * on 2016/11/23 15:09.
 */

public class ExcangeResult {


    /**
     * buyPic : 1.1239    买入价
     * closePri : 1.1239  最新价
     * code : CNYHKD
     * currency : 人民币兑港元即期汇率
     * date : 2016-11-23
     * diffAmo : -0.0015 涨跌额
     * diffPer : -0.1333% 涨跌幅
     * highPic : 1.1254   最高价
     * lowPic : 1.1236    最低价
     * openPri : 1.1254   开盘价
     * range : 18         振幅
     * sellPic : 1.1249   卖出价
     * yesDayPic : 1.1254 昨收价
     */

    private String buyPic;
    private String closePri;
    private String code;
    private String currency;
    private String date;
    private String diffAmo;
    private String diffPer;
    private String highPic;
    private String lowPic;
    private String openPri;
    private String range;
    private String sellPic;
    private String yesDayPic;

    public String getBuyPic() {
        return buyPic;
    }

    public void setBuyPic(String buyPic) {
        this.buyPic = buyPic;
    }

    public String getClosePri() {
        return closePri;
    }

    public void setClosePri(String closePri) {
        this.closePri = closePri;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDiffAmo() {
        return diffAmo;
    }

    public void setDiffAmo(String diffAmo) {
        this.diffAmo = diffAmo;
    }

    public String getDiffPer() {
        return diffPer;
    }

    public void setDiffPer(String diffPer) {
        this.diffPer = diffPer;
    }

    public String getHighPic() {
        return highPic;
    }

    public void setHighPic(String highPic) {
        this.highPic = highPic;
    }

    public String getLowPic() {
        return lowPic;
    }

    public void setLowPic(String lowPic) {
        this.lowPic = lowPic;
    }

    public String getOpenPri() {
        return openPri;
    }

    public void setOpenPri(String openPri) {
        this.openPri = openPri;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getSellPic() {
        return sellPic;
    }

    public void setSellPic(String sellPic) {
        this.sellPic = sellPic;
    }

    public String getYesDayPic() {
        return yesDayPic;
    }

    public void setYesDayPic(String yesDayPic) {
        this.yesDayPic = yesDayPic;
    }
}
