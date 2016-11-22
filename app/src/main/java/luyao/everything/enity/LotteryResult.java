package luyao.everything.enity;

import java.util.List;

/**
 * Created by Lu
 * on 2016/11/22 18:26.
 */

public class LotteryResult {

    /**
     * awardDateTime : 2016-11-21 20:30
     * lotteryDetails : [{"awardNumber":2,"awardPrice":10000000,"awards":"一等奖"},{"awardNumber":0,"awardPrice":0,"awards":"一等奖","type":"追加"},{"awardNumber":63,"awardPrice":119261,"awards":"二等奖"},{"awardNumber":14,"awardPrice":71556,"awards":"二等奖","type":"追加"},{"awardNumber":766,"awardPrice":3582,"awards":"三等奖"},{"awardNumber":264,"awardPrice":2149,"awards":"三等奖","type":"追加"},{"awardNumber":34941,"awardPrice":200,"awards":"四等奖"},{"awardNumber":10590,"awardPrice":100,"awards":"四等奖","type":"追加"},{"awardNumber":604177,"awardPrice":10,"awards":"五等奖"},{"awardNumber":203195,"awardPrice":5,"awards":"五等奖","type":"追加"},{"awardNumber":5256234,"awardPrice":5,"awards":"六等奖"}]
     * lotteryNumber : ["07","20","23","29","34","02","10"]
     * name : 大乐透
     * period : 16137
     * pool : 3.8072204459E9
     * sales : 181006344
     */

    private String awardDateTime;
    private String name;
    private String period;
    private double pool;
    private int sales;
    private List<LotteryDetailsBean> lotteryDetails;
    private List<String> lotteryNumber;
    private String number;

    public String getNumber() {
        StringBuffer stringBuffer = new StringBuffer();
        for (String s : lotteryNumber) {
            stringBuffer.append(s+"  ");
        }
        return stringBuffer.toString();
    }

    public String getAwardDateTime() {
        return awardDateTime;
    }

    public void setAwardDateTime(String awardDateTime) {
        this.awardDateTime = awardDateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public double getPool() {
        return pool;
    }

    public void setPool(double pool) {
        this.pool = pool;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public List<LotteryDetailsBean> getLotteryDetails() {
        return lotteryDetails;
    }

    public void setLotteryDetails(List<LotteryDetailsBean> lotteryDetails) {
        this.lotteryDetails = lotteryDetails;
    }

    public List<String> getLotteryNumber() {
        return lotteryNumber;
    }

    public void setLotteryNumber(List<String> lotteryNumber) {
        this.lotteryNumber = lotteryNumber;
    }

    public static class LotteryDetailsBean {
        /**
         * awardNumber : 2
         * awardPrice : 10000000
         * awards : 一等奖
         * type : 追加
         */

        private int awardNumber;
        private int awardPrice;
        private String awards;
        private String type;

        public int getAwardNumber() {
            return awardNumber;
        }

        public void setAwardNumber(int awardNumber) {
            this.awardNumber = awardNumber;
        }

        public int getAwardPrice() {
            return awardPrice;
        }

        public void setAwardPrice(int awardPrice) {
            this.awardPrice = awardPrice;
        }

        public String getAwards() {
            return awards;
        }

        public void setAwards(String awards) {
            this.awards = awards;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

}
