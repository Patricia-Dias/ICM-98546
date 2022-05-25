package ua.icm.weather.network;

import java.util.HashMap;

import ua.icm.weather.datamodel.City;

public interface  CityResultsObserver {
    public void receiveCitiesList(HashMap<String, City> citiesCollection);
    public void onFailure(Throwable cause);
}
