package luyao.everything.enity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Lu
 * on 2016/11/24 10:23.
 */

public class NumberEnity implements Serializable {

    private String kind;
    private int resId;
    private List<NumberDetail> numberDetailList;


    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public List<NumberDetail> getNumberDetailList() {
        return numberDetailList;
    }

    public void setNumberDetailList(List<NumberDetail> numberDetailList) {
        this.numberDetailList = numberDetailList;
    }

    public static class NumberDetail implements Serializable {
        private String brand;
        private String name1;
        private String number1;
        private String name2;
        private String number2;

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getName1() {
            return name1;
        }

        public void setName1(String name1) {
            this.name1 = name1;
        }

        public String getNumber1() {
            return number1;
        }

        public void setNumber1(String number1) {
            this.number1 = number1;
        }

        public String getName2() {
            return name2;
        }

        public void setName2(String name2) {
            this.name2 = name2;
        }

        public String getNumber2() {
            return number2;
        }

        public void setNumber2(String number2) {
            this.number2 = number2;
        }
    }
}
