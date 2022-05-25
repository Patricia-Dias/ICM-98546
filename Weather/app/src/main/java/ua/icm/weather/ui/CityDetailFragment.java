package ua.icm.weather.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.icm.weather.R;
import ua.icm.weather.datamodel.City;
import ua.icm.weather.datamodel.CityGroup;
import ua.icm.weather.datamodel.Weather;
import ua.icm.weather.datamodel.WeatherGroup;
import ua.icm.weather.network.IpmaApiEndpoints;
import ua.icm.weather.network.RetrofitInstance;
import ua.icm.weather.ui.content.CityUtils;

public class CityDetailFragment extends Fragment {
    public int cityID;

    public CityDetailFragment() {}

    public static CityDetailFragment newInstance (int selectedCity) {
        CityDetailFragment fragment = new CityDetailFragment();
        // Set the bundle arguments for the fragment.
        Bundle arguments = new Bundle();
        arguments.putInt("selectedCity", selectedCity);
        fragment.setArguments(arguments);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey("selectedCity")) {
            cityID = getArguments().getInt("selectedCity");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.city_detail, container, false);
        /*if (mSong != null) {
            ((TextView) rootView.findViewById(R.id.song_detail))
                    .setText(mSong.details);
        }*/
        getCityWeatherFromAPI(rootView);

        return rootView;
    }
    private void getCityWeatherFromAPI(View rootView){
        IpmaApiEndpoints service = RetrofitInstance.getRetrofitInstance().create(IpmaApiEndpoints.class);
        Call<WeatherGroup> call = service.getWeatherParent(cityID);
        call.enqueue(new Callback<WeatherGroup>() {
            @Override
            public void onResponse(Call<WeatherGroup> call, Response<WeatherGroup> response) {
                generateData(rootView, response.body());
            }

            @Override
            public void onFailure(Call<WeatherGroup> call, Throwable t) {
                //Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateData(View rootView, WeatherGroup weatherGroup) {

        TextView day1 = rootView.findViewById(R.id.day1);
        List<Weather> five_days_weather = weatherGroup.getForecasts();
        day1.setText(five_days_weather.get(0).toString());

        TextView day2 = rootView.findViewById(R.id.day2);
        day2.setText(five_days_weather.get(1).toString());

        TextView day3 = rootView.findViewById(R.id.day3);
        day3.setText(five_days_weather.get(2).toString());

        TextView day4 = rootView.findViewById(R.id.day4);
        day4.setText(five_days_weather.get(3).toString());

        TextView day5 = rootView.findViewById(R.id.day5);
        day5.setText(five_days_weather.get(4).toString());
    }
}