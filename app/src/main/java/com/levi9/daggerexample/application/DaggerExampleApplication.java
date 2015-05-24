package com.levi9.daggerexample.application;

import android.app.Application;

import com.levi9.daggerexample.dagger.DaggerExampleComponent;
import com.levi9.daggerexample.dagger.ExampleComponent;
import com.levi9.daggerexample.dagger.ExampleModule;

/**
 * Created by Major on 5/24/2015.
 */
public class DaggerExampleApplication extends Application {

    private ExampleComponent mExampleComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (mExampleComponent == null) {
            mExampleComponent = DaggerExampleComponent.builder().exampleModule(new ExampleModule(this)).build();
        }
    }


    public ExampleComponent getComponent() {
        return mExampleComponent;
    }
}
