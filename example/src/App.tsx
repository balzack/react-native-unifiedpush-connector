import * as React from 'react';

import { StyleSheet, View, Text } from 'react-native';
import { Platform, PermissionsAndroid } from 'react-native';
import { initUnifiedPush } from 'react-native-unifiedpush-connector';

export default function App() {
  const [result, setResult] = React.useState<string | undefined>();

  React.useEffect(() => {
    if (Platform.OS !== 'ios') {
      PermissionsAndroid.request(
        PermissionsAndroid.PERMISSIONS.POST_NOTIFICATIONS
      );
      initUnifiedPush()
        .then(() => {
          setResult('Initialized!!!');
        })
        .catch((e) => {
          setResult(e.toString());
        });
    }
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: {result}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
