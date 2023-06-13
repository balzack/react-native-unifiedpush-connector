# react-native-unifiedpush-connector

UnifiedPush library connector for react-native

## Installation

```sh
npm install react-native-unifiedpush-connector
```

## Usage

```js

// Javascript App

import { Platform, PermissionsAndroid } from 'react-native';
import { initUnifiedPush } from 'react-native-unifiedpush-connector';

...

  React.useEffect(() => {
    if (Platform.OS !== 'ios') {
      PermissionsAndroid.request(
        PermissionsAndroid.PERMISSIONS.POST_NOTIFICATIONS
      );
      initUnifiedPush()
    }
  }, []);

...

  useEffect(() => {
    DeviceEventEmitter.addListener('unifiedPushURL', (e) => {
      // register push url
      // pushURL = e.endpoint;
    });


// AndroidManifest

...

    <uses-permission android:name="android.permission.POST_NOTIFICATIONS" />

...

        <receiver
            android:enabled="true"
            android:name="com.unifiedpushconnector.CustomReceiver"
            android:exported="true">
            <intent-filter>
                <action android:name="org.unifiedpush.android.connector.MESSAGE"/>
                <action android:name="org.unifiedpush.android.connector.UNREGISTERED"/>
                <action android:name="org.unifiedpush.android.connector.NEW_ENDPOINT"/>
                <action android:name="org.unifiedpush.android.connector.REGISTRATION_FAILED"/>
                <action android:name="org.unifiedpush.android.connector.REGISTRATION_REFUSED"/>
            </intent-filter>
        </receiver>

```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

Apache-2

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
