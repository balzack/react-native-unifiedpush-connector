# react-native-unifiedpush-connector

UnifiedPush library connector for react-native

## Installation

```sh
npm install react-native-unifiedpush-connector
```

## Usage

```js

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

...

```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

Apache-2

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
