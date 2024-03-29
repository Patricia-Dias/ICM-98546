package ua.icm.weather.datamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;


public class WeatherType {

    @Expose
    @SerializedName( "idWeatherType")
    private int idWeatherType;

    @Expose
    @SerializedName( "descIdWeatherTypePT")
    private String descIdWeatherTypePT;

    @Expose
    @SerializedName( "descIdWeatherTypeEN")
    private String descIdWeatherTypeEN;

    private Date lastRefresh;


    public WeatherType( int idWeatherType, String descIdWeatherTypePT, String descIdWeatherTypeEN) {
        this.idWeatherType = idWeatherType;
        this.descIdWeatherTypePT = descIdWeatherTypePT;
        this.descIdWeatherTypeEN = descIdWeatherTypeEN;
    }

    public int getIdWeatherType() {
        return idWeatherType;
    }

    public void setIdWeatherType(int idWeatherType) {
        this.idWeatherType = idWeatherType;
    }

    public String getDescIdWeatherTypePT() {
        return descIdWeatherTypePT;
    }

    public void setDescIdWeatherTypePT(String descIdWeatherTypePT) {
        this.descIdWeatherTypePT = descIdWeatherTypePT;
    }

    public String getDescIdWeatherTypeEN() {
        return descIdWeatherTypeEN;
    }

    public void setDescIdWeatherTypeEN(String descIdWeatherTypeEN) {
        this.descIdWeatherTypeEN = descIdWeatherTypeEN;
    }

    public Date getLastRefresh() {
        return lastRefresh;
    }

    public void setLastRefresh(Date lastRefresh) {
        this.lastRefresh = lastRefresh;
    }

    @Override
    public String toString() {
        return "WeatherType{" +
                "idWeatherType=" + idWeatherType +
                ", descIdWeatherTypePT='" + descIdWeatherTypePT + '\'' +
                ", descIdWeatherTypeEN='" + descIdWeatherTypeEN + '\'' +
                '}';
    }
}