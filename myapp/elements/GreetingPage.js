import React, { Component } from 'react';
import { Image, Text } from 'react-native';
import { Container, Header, View, DeckSwiper, Card, CardItem, Button, FooterTab, Content } from 'native-base';
import SignIn from "./SignIn";
import SignInSignUpSegment from "./SignInSignUpSegment";

const cards = [
    {
        text: 'Card One',
        name: 'One',
        image: require('../images/orderfood.jpg'),
    },
    {
        text: 'Card Two',
        name: 'Two',
        image: require('../images/payment.jpg'),
    },
    {
        text: 'Card Three',
        name: 'Three',
        image: require('../images/deliveryuncle.jpg'),
    },
    {
        text: 'Card Four',
        name: 'Four',
        image: require('../images/customerservice.jpg'),
    }
];

export default class GreetingPage extends Component {

    constructor(props) {
        super(props)
    }

    render() {
        return (
            <Container>
                <Header>
                    <Text h2 style={{textAlign: 'center', color: '#f23151'}}>Welcome to HuskyEats!</Text>
                </Header>
                <Content>
                    <View>
                        <DeckSwiper
                            dataSource={cards}
                            looping= 'false'
                            renderItem={item =>
                                <Card style={{ elevation: 2 }}>
                                    <CardItem cardBody>
                                        <Image style={{ height: 300, flex: 1 }} source={item.image} />
                                    </CardItem>
                                </Card>
                            }
                        />
                    </View>
                </Content>
                <FooterTab>
                    <View style={styles.loginButton}>
                        <Button block style={{backgroundColor: '#eeeeee'}} title="Sign In" onPress={() => this.props.navigation.navigate('SignIn')}>
                            <Text style={styles.loginText}>Sign In</Text>
                        </Button>
                    </View>
                    <View style={styles.getStartedButton}>
                        <Button block active style={{backgroundColor: '#f23151'}} title="Get Started" onPress={() => this.props.navigation.navigate('SignInSignUpSegment')}>
                            <Text style={styles.getStartedText}>Get Started</Text>
                        </Button>
                    </View>
                </FooterTab>
            </Container>
        );
    }
}

const styles = {
    loginText: {
        color: '#616161'
    },
    getStartedText: {
        color: '#FFFFFF'
    },
    loginButton: {
        marginTop: 10,
        marginRight: 5,
        marginBottom: 20,
        marginLeft: 10,
        width: '45%',
        justifyContent: 'center',
        alignItems: 'center'
    },
    getStartedButton: {
        marginTop: 10,
        marginRight: 10,
        marginBottom: 20,
        marginLeft: 5,
        width: '45%',
        justifyContent: 'center',
        alignItems: 'center'
    }
}