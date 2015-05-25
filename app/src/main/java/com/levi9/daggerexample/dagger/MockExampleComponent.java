package com.levi9.daggerexample.dagger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by l.major on 5/25/2015.
 */
@Singleton
@Component (modules = MockExampleModule.class)
public interface MockExampleComponent extends ExampleComponent {

}
