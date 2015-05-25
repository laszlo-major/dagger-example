package com.levi9.daggerexample.application;

import com.levi9.daggerexample.dagger.DaggerMockExampleComponent;
import com.levi9.daggerexample.dagger.ExampleComponent;
import com.levi9.daggerexample.dagger.MockExampleModule;

import android.app.Application;

/**
 * Created by Major on 5/24/2015.
 */
public class DaggerExampleApplication extends Application {

    private ExampleComponent mExampleComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mExampleComponent = DaggerMockExampleComponent.builder().mockExampleModule(new MockExampleModule(this)).build();
    }

    public ExampleComponent getComponent() {
        return mExampleComponent;
    }
}
