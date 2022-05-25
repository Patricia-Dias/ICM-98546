package ua.icm.weather.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.icm.weather.R;
import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import ua.icm.weather.datamodel.City;
import ua.icm.weather.datamodel.CityGroup;
import ua.icm.weather.network.IpmaApiEndpoints;
import ua.icm.weather.network.RetrofitInstance;
import ua.icm.weather.ui.content.CityUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private boolean mTwoPane = false;
    private CityRecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);

        getCitiesFromAPI();

        if (findViewById(R.id.city_detail_container) != null) {
            mTwoPane = true;
        }
    }

    private void getCitiesFromAPI(){
        IpmaApiEndpoints service = RetrofitInstance.getRetrofitInstance().create(IpmaApiEndpoints.class);
        Call<CityGroup> call = service.getCityParent();
        call.enqueue(new Callback<CityGroup>() {
            @Override
            public void onResponse(Call<CityGroup> call, Response<CityGroup> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<CityGroup> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void generateDataList(CityGroup cityGroup) {
        RecyclerView recyclerView = findViewById(R.id.song_list);
        adapter = new CityRecyclerViewAdapter(cityGroup.getCities());
        recyclerView.setAdapter(adapter);
    }

    class CityRecyclerViewAdapter
            extends RecyclerView.Adapter
            <CityRecyclerViewAdapter.ViewHolder> {

        private final List<City> mValues;

        CityRecyclerViewAdapter(List<City> items) {
            mValues = items;
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.city_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setText(String.valueOf(position + 1));
            holder.mContentView.setText(mValues.get(position).getLocal());
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        int selectedCity= holder.getAdapterPosition();
                        CityDetailFragment fragment =
                                CityDetailFragment.newInstance(selectedCity);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.city_detail_container, fragment)
                                .addToBackStack(null)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, CityDetailActivity.class);
                        intent.putExtra("selectedCity",
                                holder.mItem.getGlobalIdLocal());
                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            final View mView;
            final TextView mIdView;
            final TextView mContentView;
            City mItem;

            ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.id);
                mContentView = (TextView) view.findViewById(R.id.content);
            }
        }
    }

}