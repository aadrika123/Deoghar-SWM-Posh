import React, {useEffect, useState} from 'react';
import {NativeModules, Text, View, StyleSheet} from 'react-native';

interface MyModule {
  myMethod(callback: (msg: string) => void): void;
}

const {MyModule} = NativeModules as {MyModule: MyModule};

const App: React.FC = () => {
  const [message, setMessage] = useState<string>('');

  useEffect(() => {
    MyModule.myMethod((msg: string) => {
      setMessage(msg);
    });
  }, []);

  return (
    <View style={styles.container}>
      <Text>{message}</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
});

export default App;
