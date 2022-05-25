package ua.icm.weatherforecast.network;

import java.util.HashMap;

import ua.icm.weatherforecast.datamodel.WeatherType;

public interface WeatherTypesResultsObserver {
    public void receiveWeatherTypesList(HashMap<Integer, WeatherType> descriptorsCollection);
    public void onFailure(Throwable cause);
}
