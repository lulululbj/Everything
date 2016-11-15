package luyao.everything.enity.weather;

/**
 * Created by Lu
 * on 2016/11/15 14:15.
 */

public class FutureWeatherEnity {

//    "date":"2016-11-15",
//            "dayTime":"多云",
//            "night":"阴",
//            "temperature":"16°C / 9°C",
//            "week":"今天",
//            "wind":"东风 3～4级"

    private String date;
    private String dayTime;
    private String night;
    private String temperature;
    private String week;
    private String wind;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    @Override
    public String toString() {
        return "FutureWeatherEnity{" +
                "date='" + date + '\'' +
                ", dayTime='" + dayTime + '\'' +
                ", night='" + night + '\'' +
                ", temperature='" + temperature + '\'' +
                ", week='" + week + '\'' +
                ", wind='" + wind + '\'' +
                '}';
    }
}
