package com.levi9.daggerexample.dagger;

import javax.inject.Singleton;

import dagger.Component;

import com.levi9.daggerexample.communication.CommunicationManager;
import com.levi9.daggerexample.ui.MainFragment;

/**
 * Created by Major on 5/24/2015.
 */
@Singleton
@Component (modules = ExampleModule.class)
public interface ExampleComponent {

    void inject(MainFragment mainFragment);

    void inject(CommunicationManager communicationManager);
}
