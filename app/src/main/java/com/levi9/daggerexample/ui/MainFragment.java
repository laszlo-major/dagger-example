package com.levi9.daggerexample.ui;

import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import javax.inject.Inject;

import com.levi9.daggerexample.R;
import com.levi9.daggerexample.application.DaggerExampleApplication;
import com.levi9.daggerexample.communication.CommunicationManager;
import com.levi9.daggerexample.communication.WeatherResponseListener;
import com.levi9.daggerexample.model.WeatherData;
import com.levi9.daggerexample.util.Constants;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.RetrofitError;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment implements WeatherResponseListener {

    @InjectView(R.id.example_tv)
    TextView mExampleTv;

    @InjectView(R.id.example_checkbox)
    CheckBox mCheckBox;

    @InjectView(R.id.temp_tv)
    TextView mTempTv;

    @InjectView(R.id.city_tv)
    TextView mCityTv;

    @Inject
    CommunicationManager mCommunicationManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DaggerExampleApplication)getActivity().getApplication()).getComponent().inject(this);
    }

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.inject(this, rootView);
        initializeCheckBox();

        mCommunicationManager.getCurrentWeather("london", this);

        mExampleTv.setText("Module in use: " + mCommunicationManager.getCurrentVersion());
        return rootView;
    }

    private void initializeCheckBox() {
        mCheckBox.setChecked(PreferenceManager.getDefaultSharedPreferences(getActivity()).getBoolean(Constants.USE_FAKE_MODULE_KEY, false));
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                PreferenceManager.getDefaultSharedPreferences(getActivity()).edit().putBoolean(Constants.USE_FAKE_MODULE_KEY, isChecked).apply();
            }
        });
    }

    @Override
    public void onGetWeatherSuccess(WeatherData weatherData) {
        mCityTv.setText(weatherData.getName());
        mTempTv.setText(weatherData.getMain().getTemp());
    }

    @Override
    public void onGetWeatherError(RetrofitError error) {
        new AlertDialog.Builder(getActivity()).setMessage(error.getMessage()).setTitle("Error").create().show();
    }
}
