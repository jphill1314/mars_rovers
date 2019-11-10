package com.jphill.marsrovers.main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/jphill/marsrovers/main/MainApplication;", "Landroid/app/Application;", "Ldagger/android/HasAndroidInjector;", "()V", "androidInjector", "Ldagger/android/AndroidInjector;", "", "getAndroidInjector", "()Ldagger/android/AndroidInjector;", "setAndroidInjector", "(Ldagger/android/AndroidInjector;)V", "component", "Lcom/jphill/marsrovers/main/injection/AppComponent;", "getComponent", "()Lcom/jphill/marsrovers/main/injection/AppComponent;", "setComponent", "(Lcom/jphill/marsrovers/main/injection/AppComponent;)V", "onCreate", "", "app_debug"})
public final class MainApplication extends android.app.Application implements dagger.android.HasAndroidInjector {
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Inject()
    public dagger.android.AndroidInjector<java.lang.Object> androidInjector;
    @org.jetbrains.annotations.NotNull()
    public com.jphill.marsrovers.main.injection.AppComponent component;
    
    @org.jetbrains.annotations.NotNull()
    public final dagger.android.AndroidInjector<java.lang.Object> getAndroidInjector() {
        return null;
    }
    
    public final void setAndroidInjector(@org.jetbrains.annotations.NotNull()
    dagger.android.AndroidInjector<java.lang.Object> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jphill.marsrovers.main.injection.AppComponent getComponent() {
        return null;
    }
    
    public final void setComponent(@org.jetbrains.annotations.NotNull()
    com.jphill.marsrovers.main.injection.AppComponent p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public dagger.android.AndroidInjector<java.lang.Object> androidInjector() {
        return null;
    }
    
    public MainApplication() {
        super();
    }
}