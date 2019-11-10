package com.jphill.marsrovers.main.injection.qualifiers

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MainThreadScheduler