package ua.icm.weatherforecast.network;

import java.util.List;

import ua.icm.weatherforecast.datamodel.Weather;

public interface ForecastForACityResultsObserver {
    public void receiveForecastList(List<Weather> forecast);
    public void onFailure(Throwable cause);
}
