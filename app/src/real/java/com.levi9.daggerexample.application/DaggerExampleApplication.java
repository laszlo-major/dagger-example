package com.levi9.daggerexample.application;

import android.app.Application;
import android.preference.PreferenceManager;

import com.levi9.daggerexample.dagger.DaggerExampleComponent;
import com.levi9.daggerexample.dagger.DaggerMockExampleComponent;
import com.levi9.daggerexample.dagger.ExampleComponent;
import com.levi9.daggerexample.dagger.MockExampleModule;
import com.levi9.daggerexample.dagger.ExampleModule;
import com.levi9.daggerexample.util.Constants;

/**
 * Created by Major on 5/24/2015.
 */
public class DaggerExampleApplication extends Application {

    private ExampleComponent mExampleComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        //This is only called if the application was killed/restarted
        boolean useFakeModule = PreferenceManager.getDefaultSharedPreferences(this).getBoolean(Constants.USE_FAKE_MODULE_KEY, false);
        if (mExampleComponent == null) {
            if (useFakeModule) {
                mExampleComponent = DaggerMockExampleComponent.builder().exampleFakeModule(new MockExampleModule(this)).build();
            } else {
                mExampleComponent = DaggerExampleComponent.builder().exampleModule(new ExampleModule(this)).build();
            }
        }
    }


    public ExampleComponent getComponent() {
        return mExampleComponent;
    }
}
