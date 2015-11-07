package com.bozidar.labas.dagger2github.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by Bozidar on 06.11.2015..
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface UseMockBackend {
}
