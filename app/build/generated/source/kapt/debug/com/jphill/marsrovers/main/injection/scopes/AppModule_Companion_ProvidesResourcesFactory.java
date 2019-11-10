// Generated by Dagger (https://dagger.dev).
package com.jphill.marsrovers.main.injection.scopes;

import android.content.Context;
import android.content.res.Resources;

import com.jphill.marsrovers.main.injection.AppModule;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_Companion_ProvidesResourcesFactory implements Factory<Resources> {
  private final AppModule.Companion module;

  private final Provider<Context> contextProvider;

  public AppModule_Companion_ProvidesResourcesFactory(AppModule.Companion module,
      Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public Resources get() {
    return providesResources(module, contextProvider.get());
  }

  public static AppModule_Companion_ProvidesResourcesFactory create(AppModule.Companion module,
      Provider<Context> contextProvider) {
    return new AppModule_Companion_ProvidesResourcesFactory(module, contextProvider);
  }

  public static Resources providesResources(AppModule.Companion instance, Context context) {
    return Preconditions.checkNotNull(instance.providesResources(context), "Cannot return null from a non-@Nullable @Provides method");
  }
}
