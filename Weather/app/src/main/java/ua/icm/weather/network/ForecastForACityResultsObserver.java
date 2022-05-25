package ua.icm.weather.network;

import java.util.HashMap;
import java.util.List;

import ua.icm.weather.datamodel.Weather;
import ua.icm.weather.datamodel.WeatherType;

public interface ForecastForACityResultsObserver {
    public void receiveForecastList(List<Weather> forecast);
    public void onFailure(Throwable cause);
}
