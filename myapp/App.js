import React, {Component} from 'react';
import { StyleSheet, ScrollView, Dimensions, Button, Text } from 'react-native';
import { Container, View, Content } from 'native-base';
import {createStackNavigator, StackNavigator} from 'react-navigation';
import HuskyEatsInfo from './elements/HuskyEatsInfo';
import GreetingPage from './elements/GreetingPage';
import GreetingCarousel from './elements/GreetingCarousel';
import SignIn from './elements/SignIn';
import SignUp from './elements/SignUp';
import AddressForm from './elements/AddressForm';
import { Constants } from 'expo';

const { width } = Dimensions.get('window');
const height = 300;

class Home extends Component {
    static navigationOptions = ({ navigation }) => {
        const params = navigation.state.params || {};

        return {
            headerTitle: (
                <Text style={{color: '#fff', fontSize: 20, fontWeight: 'bold'}}>HuskyEats</Text>
            ),
            headerLeft: (
                <Button
                    onPress={() => navigation.navigate('HuskyEatsInfo')}
                    title="Info"
                    color="#fff"
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
                    <ScrollView>
                        <GreetingPage navigation={this.props.navigation}/>
                        <View style={styles.container}>
                            <GreetingCarousel images={images}/>
                        </View>
                        {/*<StatusBar barStyle="light-content"/>*/}
                        {/*<FixedHeader/>*/}
                    </ScrollView>
                </Content>
            </Container>
        )}
}

const MainStack = createStackNavigator(
    {
        Home, SignIn, SignUp, AddressForm
    },
    {
        initialRouteName: 'Home',
        navigationOptions: {
            headerStyle: {
                backgroundColor: '#f23151',
            },
            headerTintColor: '#fff',
            headerTitleStyle: {
                fontWeight: 'bold',
            },
        },
    }
);

const RootStack = createStackNavigator(
    {
        MainStack, HuskyEatsInfo
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
