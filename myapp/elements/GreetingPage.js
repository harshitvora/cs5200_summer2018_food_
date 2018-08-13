import React, { Component } from 'react';
import { Image, Text } from 'react-native';
import { Container, Header, View, DeckSwiper, Card, CardItem, Button, FooterTab, Content } from 'native-base';
import SignIn from "./SignIn";
import SignUp from "./SignUp";

const cards = [
    {
        name: 'Order all your favorites',
        text: 'Order from the best local restaurants with easy, on-demand delivery.',
        image: require('../images/orderfood.jpg'),
    },
    {
        name: 'Free delivery offers',
        text: 'HuskyEats regularly offers free delivery for new customers via Apple Pay.',
        image: require('../images/payment.jpg'),
    },
    {
        name: 'Unmatched Reliability',
        text: 'Experience peace of mind while tracking your order in real time.',
        image: require('../images/track.jpg'),
    },
    {
        name: 'Five start dashers',
        text: 'Enjoy deliveries from a friendly vetted fleet.',
        image: require('../images/deliveryuncle.jpg'),
    },
    {
        name: 'Here for you',
        text: 'Something come up? Talk to a real person. We\'re here to help.',
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
                <Content>
                    <View style={{justifyContent: 'center', backgroundColor: '#f23151'}}>
                        <Text style={{textAlign: 'center', color: '#fff', fontSize: 20, fontWeight: 'bold', padding: 25}}>Welcome to HuskyEats!</Text>
                    </View>
                    <View>
                        <DeckSwiper
                            dataSource={cards}
                            looping= 'false'
                            style={{ height: 500 }}
                            renderItem={item =>
                                <Card style={{ elevation: 3 }}>
                                    <CardItem>
                                        <Text style={{color: '#595959'}}>{item.name}</Text>
                                    </CardItem>
                                    <CardItem cardBody>
                                        <Image style={{ height: 300, flex: 1 }} source={item.image} />
                                    </CardItem>
                                    <CardItem>
                                        <Text style={{color: '#595959'}}>{item.text}</Text>
                                    </CardItem>
                                </Card>
                            }
                        />
                    </View>
                </Content>
                <FooterTab>
                    <View style={styles.loginButton}>
                        <Button block
                                style={{backgroundColor: '#eeeeee'}}
                                title="Sign In"
                                onPress={() => this.props.navigation.navigate('SignIn')}>
                            <Text style={{color: '#595959'}}>Sign In</Text>
                        </Button>
                    </View>
                    <View style={styles.getStartedButton}>
                        <Button block
                                style={{backgroundColor: '#f23151'}}
                                title="Get Started"
                                onPress={() => this.props.navigation.navigate('SignUp')}>
                            <Text style={{color: '#FFFFFF'}}>Get Started</Text>
                        </Button>
                    </View>
                </FooterTab>
            </Container>
        );
    }
}

const styles = {
    loginButton: {
        marginTop: 10,
        marginRight: 5,
        marginLeft: 10,
        width: '45%',
        justifyContent: 'center'
    },
    getStartedButton: {
        marginTop: 10,
        marginRight: 10,
        marginLeft: 5,
        width: '45%',
        justifyContent: 'center'
    }
};