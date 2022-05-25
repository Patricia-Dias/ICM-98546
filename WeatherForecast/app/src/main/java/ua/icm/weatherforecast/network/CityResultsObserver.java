package ua.icm.weatherforecast.network;

import java.util.HashMap;

import ua.icm.weatherforecast.datamodel.City;

public interface  CityResultsObserver {
    public void receiveCitiesList(HashMap<String, City> citiesCollection);
    public void onFailure(Throwable cause);
}
