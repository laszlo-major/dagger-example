package com.levi9.daggerexample.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.levi9.daggerexample.communication.CommunicationManager;

/**
 * Created by Major on 5/24/2015.
 */
@Module
public class ExampleModule {
    private Context mContext;
    public ExampleModule(Context context) {
        this.mContext = context;
    }

    @Singleton
    @Provides
    public CommunicationManager provideCommunication () {
        return new CommunicationManager();
    }
}
