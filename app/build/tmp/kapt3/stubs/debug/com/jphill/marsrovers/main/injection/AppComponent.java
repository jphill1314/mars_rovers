package com.jphill.marsrovers.main.injection;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/jphill/marsrovers/main/injection/AppComponent;", "Ldagger/android/AndroidInjector;", "", "Builder", "app_debug"})
@dagger.Component(modules = {dagger.android.support.AndroidSupportInjectionModule.class, com.jphill.marsrovers.main.injection.scopes.AppModule.class})
public abstract interface AppComponent extends dagger.android.AndroidInjector<java.lang.Object> {
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\'J\b\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/jphill/marsrovers/main/injection/AppComponent$Builder;", "", "application", "Lcom/jphill/marsrovers/main/MainApplication;", "build", "Lcom/jphill/marsrovers/main/injection/AppComponent;", "app_debug"})
    @dagger.Component.Builder()
    public static abstract interface Builder {
        
        @org.jetbrains.annotations.NotNull()
        @dagger.BindsInstance()
        public abstract com.jphill.marsrovers.main.injection.AppComponent.Builder application(@org.jetbrains.annotations.NotNull()
        com.jphill.marsrovers.main.MainApplication application);
        
        @org.jetbrains.annotations.NotNull()
        public abstract com.jphill.marsrovers.main.injection.AppComponent build();
    }
}