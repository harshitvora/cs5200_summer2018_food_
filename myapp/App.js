import React, {Component} from 'react';
import { StyleSheet, ScrollView, Dimensions, Button } from 'react-native';
import { Container, View, Content } from 'native-base';
import {createStackNavigator, StackNavigator} from 'react-navigation';
import HuskyEatsInfo from './elements/HuskyEatsInfo';
import ScreenA from './elements/ScreenA';
import ScreenB from './elements/ScreenB';
import SignIn from './elements/SignIn';
import SignUp from './elements/SignUp';
import SignInSignUpSegment from './elements/SignInSignUpSegment';
import GreetingPage from './elements/GreetingPage';
import GreetingCarousel from './elements/GreetingCarousel';
import { Constants } from 'expo';

const { width } = Dimensions.get('window');
const height = 300;

class Home extends Component {
    static navigationOptions = ({ navigation }) => {
        const params = navigation.state.params || {};

        return {
            headerTitle: 'HuskyEats',
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
                        {/*<SignInSignUpSegment/>*/}
                        {/*<StatusBar barStyle="light-content"/>*/}
                        {/*<FixedHeader/>*/}
                        {/*<AddressForm/>*/}
                        {/*<Button title="Go to Screen A" onPress={() => this.props.navigation.navigate('ScreenA')}/>*/}
                        {/*<Button title="Go to Screen B" onPress={() => this.props.navigation.navigate('ScreenB')}/>*/}
                        {/*<Button title="Sign In" onPress={() => this.props.navigation.navigate('SignIn')}/>*/}
                        {/*<Button title="Sign Up" onPress={() => this.props.navigation.navigate('SignUp')}/>*/}
                    </ScrollView>
                </Content>
            </Container>
        )}
}

const MainStack = createStackNavigator(
    {
        Home, GreetingPage, ScreenA, ScreenB, SignIn, SignUp, SignInSignUpSegment
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
