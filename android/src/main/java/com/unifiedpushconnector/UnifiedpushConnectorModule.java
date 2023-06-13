package com.unifiedpushconnector;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

import java.util.ArrayList;
import java.lang.Thread;

import android.app.Activity;
import android.content.Context;
import org.unifiedpush.android.connector.UnifiedPush;
import org.unifiedpush.android.connector.RegistrationDialogContent;

@ReactModule(name = UnifiedpushConnectorModule.NAME)
public class UnifiedpushConnectorModule extends ReactContextBaseJavaModule {
  public static final String NAME = "UnifiedpushConnector";
  private static final Integer DELAY_COUNT = 5;
  private static final Integer DELAY = 100;
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

  private Activity getActivity() {
    try {
      // activity takes longer than js engine to be set
      for (Integer i = 0; i < DELAY_COUNT; i++) {
        Activity activity = getCurrentActivity();
        if (activity != null) {
          return activity;
        }
        Thread.sleep(DELAY);
      }
    }
    catch(Exception e) {
      System.out.println(e.toString());
    }
    return null;
  }

  @ReactMethod
  public void initUnifiedPush(Promise promise) {
    Activity activity = getActivity();
    if (activity == null) {
      promise.reject("could not obtain activity");
      return;
    }

    activity.getSharedPreferences("unifiedpush.connector", Context.MODE_PRIVATE).edit().putBoolean("unifiedpush.no_distrib_dialog", true).apply();

    UnifiedPush.registerAppWithDialog(
        activity,
        "default",
        new RegistrationDialogContent(),
        new ArrayList<String>(),
        packageName
    );
    promise.resolve(null);
  }
}
