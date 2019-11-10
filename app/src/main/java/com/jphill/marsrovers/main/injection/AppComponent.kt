package com.jphill.marsrovers.main.injection

import com.jphill.marsrovers.main.MainApplication
import com.jphill.marsrovers.main.injection.scopes.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class
])
interface AppComponent : AndroidInjector<Any> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MainApplication): AppComponent.Builder
        fun build(): AppComponent
    }
}