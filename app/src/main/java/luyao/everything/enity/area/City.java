package luyao.everything.enity.area;

import java.util.List;

/**
 * 市
 * Created by Lu
 * on 2016/11/18 00:15
 */

public class City {

    private String city;
    private List<District> district;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<District> getDistrict() {
        return district;
    }

    public void setDistrict(List<District> district) {
        this.district = district;
    }
}
