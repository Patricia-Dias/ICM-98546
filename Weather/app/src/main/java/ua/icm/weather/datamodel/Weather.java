package ua.icm.weather.datamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Weather {

    @Expose
    private int globalIdLocal;

    @Expose
    @SerializedName( "forecastDate")
    private String forecastDate;

    @Expose
    @SerializedName( "precipitaProb")
    private double precipitaProb;

    @Expose
    @SerializedName("tMin")
    private double tMin;

    @Expose
    @SerializedName("tMax")
    private double tMax;

    @Expose
    @SerializedName("predWindDir")
    private String predWindDir;

    @Expose
    @SerializedName("idWeatherType")
    private int idWeatherType;

    @Expose
    @SerializedName("classWindSpeed")
    private int classWindSpeed;

    private Date lastRefresh;

    public Weather(String forecastDate, double precipitaProb, double tMin, double tMax, String predWindDir, int idWeatherType, int classWindSpeed)
    {
        this.forecastDate = forecastDate;
        this.precipitaProb = precipitaProb;
        this.tMin = tMin;
        this.tMax = tMax;
        this.predWindDir = predWindDir;
        this.idWeatherType = idWeatherType;
        this.classWindSpeed = classWindSpeed;
        this.globalIdLocal = 0;
    }

    public int getGlobalIdLocal() {
        return globalIdLocal;
    }

    public void setGlobalIdLocal( int globalIdLocal) {
        this.globalIdLocal = globalIdLocal;
    }

    public String getForecastDate() {
        return forecastDate;
    }

    public void setForecastDate(String forecastDate) {
        this.forecastDate = forecastDate;
    }

    public double getPrecipitaProb() {
        return precipitaProb;
    }

    public void setPrecipitaProb(double precipitaProb) {
        this.precipitaProb = precipitaProb;
    }

    public double getTMin() {
        return tMin;
    }

    public void settMin(double tMin) {
        this.tMin = tMin;
    }

    public double getTMax() {
        return tMax;
    }

    public void setTMax(double tMax) {
        this.tMax = tMax;
    }

    public String getPredWindDir() {
        return predWindDir;
    }

    public void setPredWindDir(String predWindDir) {
        this.predWindDir = predWindDir;
    }

    public int getIdWeatherType() {
        return idWeatherType;
    }

    public void setIdWeatherType(int idWeatherType) {
        this.idWeatherType = idWeatherType;
    }

    public int getClassWindSpeed() {
        return classWindSpeed;
    }

    public void setClassWindSpeed(int classWindSpeed) {
        this.classWindSpeed = classWindSpeed;
    }

    public void setLastRefresh(Date lastRefresh) { this.lastRefresh = lastRefresh; }

    public Date getLastRefresh() { return lastRefresh; }

    @Override
    public String toString() {
        return "\n\t\t"+forecastDate + "\n\n"+
                "Precipitation\t\t\t" + precipitaProb +"%\n"+
                "T Max\t\t\t\t\t\t\t\t\t\t" + tMax +"ºC\n"+
                "T Min\t\t\t\t\t\t\t\t\t\t\t" + tMin +"ºC\n"+
                "Wind Direction\t\t\t" + predWindDir + "\n\n";
    }
}