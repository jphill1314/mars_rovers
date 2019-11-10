package com.jphill.marsrovers.main.injection.scopes;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\b\u0010\u0007\u001a\u00020\bH\'\u00a8\u0006\n"}, d2 = {"Lcom/jphill/marsrovers/main/injection/scopes/AppModule;", "", "()V", "providesContext", "Landroid/content/Context;", "application", "Landroid/app/Application;", "providesMainActivity", "Lcom/jphill/marsrovers/MainActivity;", "Companion", "app_debug"})
@dagger.Module()
public abstract class AppModule {
    public static final com.jphill.marsrovers.main.injection.scopes.AppModule.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    @dagger.android.ContributesAndroidInjector()
    @PerActivity()
    public abstract com.jphill.marsrovers.MainActivity providesMainActivity();
    
    @org.jetbrains.annotations.NotNull()
    @PerActivity()
    @dagger.Binds()
    public abstract android.content.Context providesContext(@org.jetbrains.annotations.NotNull()
    android.app.Application application);
    
    public AppModule() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/jphill/marsrovers/main/injection/scopes/AppModule$Companion;", "", "()V", "providesResources", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "app_debug"})
    @dagger.Module()
    public static final class Companion {
        
        @PerActivity()
        @dagger.Provides()
        public final android.content.res.Resources providesResources(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}