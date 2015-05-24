package com.levi9.daggerexample.dagger;

import javax.inject.Singleton;

import dagger.Component;
import com.levi9.daggerexample.ui.MainActivityFragment;

/**
 * Created by Major on 5/24/2015.
 */
@Singleton
@Component (modules = ExampleModule.class)
public interface ExampleComponent {

    void inject(MainActivityFragment mainActivityFragment);
}
