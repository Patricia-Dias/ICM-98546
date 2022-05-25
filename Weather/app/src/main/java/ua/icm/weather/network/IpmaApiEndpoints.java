package ua.icm.weather.network;

import ua.icm.weather.datamodel.CityGroup;
import ua.icm.weather.datamodel.WeatherGroup;
import ua.icm.weather.datamodel.WeatherTypeGroup;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 *  return value is always a parameterized Call<T> object such as Call<User>
 */
public interface IpmaApiEndpoints {

    @GET("open-data/distrits-islands.json")
    Call<CityGroup> getCityParent();

    @GET("open-data/forecast/meteorology/cities/daily/{localId}.json")
    Call<WeatherGroup> getWeatherParent(@Path("localId") int localId);

    @GET("open-data/weather-type-classe.json")
    Call<WeatherTypeGroup> getWeatherTypes();

}
