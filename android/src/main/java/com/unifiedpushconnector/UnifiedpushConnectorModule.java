package com.unifiedpushconnector;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import org.unifiedpush.android.connector.UnifiedPush;
import org.unifiedpush.android.connector.RegistrationDialogContent;

@ReactModule(name = UnifiedpushConnectorModule.NAME)
public class UnifiedpushConnectorModule extends ReactContextBaseJavaModule {
  public static final String NAME = "UnifiedpushConnector";
  private String packageName;
  
  public UnifiedpushConnectorModule(ReactApplicationContext reactContext) {
    super(reactContext);

    packageName = reactContext.getPackageName();
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }


  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  public void multiply(double a, double b, Promise promise) {
    promise.resolve(a * b);
  }


  @ReactMethod
  public void initUnifiedPush(Promise promise) {

    Activity activityContext = getCurrentActivity();

    activityContext.getSharedPreferences("unifiedpush.connector", Context.MODE_PRIVATE).edit().putBoolean("unifiedpush.no_distrib_dialog", true).apply();

    UnifiedPush.registerAppWithDialog(
        activityContext,
        "default",
        new RegistrationDialogContent(),
        new ArrayList<String>(),
        packageName
    );

    promise.resolve(null);
  }

}
