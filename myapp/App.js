import React, {Component} from 'react';
import { StyleSheet, Button, Text } from 'react-native';
import { Container, View, Content } from 'native-base';
import {createStackNavigator, StackNavigator} from 'react-navigation';
import HuskyEatsInfo from './elements/HuskyEatsInfo';
import GreetingPage from './elements/GreetingPage';
import SignIn from './elements/SignIn';
import SignUp from './elements/SignUp';
import AddressForm from './elements/AddressForm';
import ConfirmAddress from './elements/ConfirmAddress';
import Browse from './elements/Browse';
import Addresses from './elements/Addresses';
import Restaurants from './elements/Restaurants';
import Filter from './elements/Filter';
import ProfileInformation from './elements/ProfileInformation';

import { Constants } from 'expo';
import RefineLocation from "./elements/RefineLocation";

class Home extends Component {
    static navigationOptions = ({ navigation }) => {
        const params = navigation.state.params || {};

        return {
            headerTitle: (
                <Text style={{color: '#f23151', fontSize: 20, fontWeight: 'bold'}}>HuskyEats</Text>
            ),
            headerLeft: (
                <Button
                    onPress={() => navigation.navigate('HuskyEatsInfo')}
                    title="Info"
                    color="#f23151"
                />
            ),
        };
    };

    constructor(props) {
        super(props)
    }

    render() {
        const images = [
            {
                id: '1',
                source: {
                    uri: '../images/orderfood.jpg',
                },
            },
            {
                id: '2',
                source: {
                    uri: '../images/payment.jpg',
                },
            },
            {
                id: '3',
                source: {
                    uri: '../images/deliveryuncle.jpg',
                },
            },
            {
                id: '4',
                source: {
                    uri: '../images/customerservice.jpg',
                },
            }
        ];
        return(
            <Container>
                <Content>
                    <GreetingPage navigation={this.props.navigation}/>
                </Content>
            </Container>
        )}
}

const MainStack = createStackNavigator(
    {
        Home, SignIn, SignUp, AddressForm, ConfirmAddress, RefineLocation
    },
    {
        initialRouteName: 'Home',
        navigationOptions: {
            headerStyle: {
                backgroundColor: '#fcfcfc',
            },
            headerTintColor: '#f23151',
            headerTitleStyle: {
                fontWeight: 'bold',
            },
        },
    }
);

const AnoyStack = createStackNavigator(
    {
        Browse, Addresses, AddressForm, ConfirmAddress, RefineLocation, Filter, ProfileInformation,
    },
    {
        navigationOptions: {
            headerStyle: {
                backgroundColor: '#fcfcfc',
            },
            headerTintColor: '#f23151',
            headerTitleStyle: {
                fontWeight: 'bold',
            },
        },
    }
);

const RootStack = createStackNavigator(
    {
        MainStack, HuskyEatsInfo, AnoyStack
    },
    {
        mode: 'modal',
        headerMode: 'none',
    }
);

export default class App extends React.Component {
    render() {
        return <RootStack/>;
    }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
    paddingTop: Constants.statusBarHeight
  }
});
