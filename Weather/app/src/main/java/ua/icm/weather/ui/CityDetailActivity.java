package ua.icm.weather.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ua.icm.weather.R;
import ua.icm.weather.datamodel.City;
import ua.icm.weather.ui.content.CityUtils;
import android.content.Intent;

import androidx.core.app.NavUtils;
import androidx.appcompat.app.ActionBar;
import android.view.MenuItem;


public class CityDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_detail);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (savedInstanceState == null) {
            int selectedCity =
                    getIntent().getIntExtra("selectedCity", 0);
            CityDetailFragment fragment =
                    CityDetailFragment.newInstance(selectedCity);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.song_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown.
            // NavUtils allows users to navigate up one level in the
            // application structure.
            NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
