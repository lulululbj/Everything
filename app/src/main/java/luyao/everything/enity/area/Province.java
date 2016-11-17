package luyao.everything.enity.area;

import java.util.List;

/**
 * 省
 * Created by Lu
 * on 2016/11/18 00:14
 */

public class Province {

    private String province;
    private List<City> city;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }
}
