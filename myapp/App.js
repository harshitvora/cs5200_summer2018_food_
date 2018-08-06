import React from 'react';
import { StyleSheet, Text, View, StatusBar } from 'react-native';
import FixedHeader from './elements/FixedHeader';
import TextHeadings from './elements/TextHeadings';
import AddressForm from './elements/AddressForm';
import {createStackNavigator} from 'react-navigation';
import {Button} from 'react-native-elements';
import ScreenA from './elements/ScreenA';
import ScreenB from './elements/ScreenB';

class Home extends React.Component {
    static navigationOptions = {
        title:'Home'
    }

    constructor(props) {
        super(props)
    }

    render() {
        return(
            <View>
                <StatusBar barStyle="light-content"/>
                <FixedHeader/>
                <TextHeadings/>
                <AddressForm/>
                <Button title="Go to Screen A" onPress={() => this.props.navigation.navigate('ScreenA')}/>
                <Button title="Go to Screen B" onPress={() => this.props.navigation.navigate('ScreenB')}/>
            </View>)}
}

const App = createStackNavigator({
    Home: {screen: Home},
    ScreenA: {screen: ScreenA},
    ScreenB: {screen: ScreenB}
});

export default App;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
