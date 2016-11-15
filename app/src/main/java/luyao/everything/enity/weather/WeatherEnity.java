package luyao.everything.enity.weather;

import java.util.List;

import luyao.everything.enity.weather.FutureWeatherEnity;

/**
 * Created by Lu
 * on 2016/11/15 13:37.
 */

public class WeatherEnity {

//            "airCondition":"轻度污染",
//            "city":"南京",
//            "coldIndex":"易发期",
//            "date":"2016-11-15",
//            "distrct":"南京",
//            "dressingIndex":"夹衣类",
//            "exerciseIndex":"不适宜",
//            "future":Array[10],
//            "humidity":"湿度：51%",
//            "pollutionIndex":"107",
//            "province":"江苏",
//            "sunrise":"06:33",
//            "sunset":"17:05",
//            "temperature":"16℃",
//            "time":"12:41",
//            "updateTime":"20161115130135",
//            "washIndex":"不适宜",
//            "weather":"多云",
//            "week":"周二",
//            "wind":"东风3级"

    private String airCondition;
    private String city;
    private String coldIndex;
    private String date;
    private String distrct;
    private String dressingIndex;
    private String exerciseIndex;
    private String humidity;
    private String pollutionIndex;
    private String province;
    private String sunrise;
    private String sunset;
    private String temperature;
    private String time;
    private String updateTime;
    private String washIndex;
    private String weather;
    private String week;
    private String wind;
    private List<FutureWeatherEnity> future;


    public String getAirCondition() {
        return airCondition;
    }

    public void setAirCondition(String airCondition) {
        this.airCondition = airCondition;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getColdIndex() {
        return coldIndex;
    }

    public void setColdIndex(String coldIndex) {
        this.coldIndex = coldIndex;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDistrct() {
        return distrct;
    }

    public void setDistrct(String distrct) {
        this.distrct = distrct;
    }

    public String getDressingIndex() {
        return dressingIndex;
    }

    public void setDressingIndex(String dressingIndex) {
        this.dressingIndex = dressingIndex;
    }

    public String getExerciseIndex() {
        return exerciseIndex;
    }

    public void setExerciseIndex(String exerciseIndex) {
        this.exerciseIndex = exerciseIndex;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPollutionIndex() {
        return pollutionIndex;
    }

    public void setPollutionIndex(String pollutionIndex) {
        this.pollutionIndex = pollutionIndex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getWashIndex() {
        return washIndex;
    }

    public void setWashIndex(String washIndex) {
        this.washIndex = washIndex;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
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

    public List<FutureWeatherEnity> getFuture() {
        return future;
    }

    public void setFuture(List<FutureWeatherEnity> future) {
        this.future = future;
    }

    @Override
    public String toString() {
        return "WeatherEnity{" +
                "airCondition='" + airCondition + '\'' +
                ", city='" + city + '\'' +
                ", coldIndex='" + coldIndex + '\'' +
                ", date='" + date + '\'' +
                ", distrct='" + distrct + '\'' +
                ", dressingIndex='" + dressingIndex + '\'' +
                ", exerciseIndex='" + exerciseIndex + '\'' +
                ", humidity='" + humidity + '\'' +
                ", pollutionIndex='" + pollutionIndex + '\'' +
                ", province='" + province + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                ", temperature='" + temperature + '\'' +
                ", time='" + time + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", washIndex='" + washIndex + '\'' +
                ", weather='" + weather + '\'' +
                ", week='" + week + '\'' +
                ", wind='" + wind + '\'' +
                ", future=" + future +
                '}';
    }
}
