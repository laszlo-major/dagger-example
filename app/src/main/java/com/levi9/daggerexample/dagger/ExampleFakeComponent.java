package com.levi9.daggerexample.dagger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by l.major on 5/25/2015.
 */
@Singleton
@Component (modules = ExampleFakeModule.class)
public interface ExampleFakeComponent extends ExampleComponent {

}
