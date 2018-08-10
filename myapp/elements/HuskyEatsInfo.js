import React, {Component} from 'react';
import {Button, Image, View, Text, StyleSheet} from 'react-native';

export default class HuskyEatsInfo extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        return (
            <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
                <Text style={{ color: '#6c6c6c', fontSize: 20, fontWeight: 'bold'}}>
                    Welcome to<Text style={{color: '#f23151'}}> HuskyEats!</Text></Text>
                <Text/>
                <Text style={styles.pinkFont}>
                    - Order from the best local restaurants with easy, on-demand delivery.
                </Text>
                <Text style={styles.grayFont}>
                    - HuskyEats regularly offers free delivery for new customers via Apple Pay.
                </Text>
                <Text style={styles.pinkFont}>
                    - Experience peace of mind while tracking your order in real time.
                </Text>
                <Text style={styles.grayFont}>
                    - Enjoy deliveries from a friendly vetted fleet.
                </Text>
                <Text/>
                <Image
                    source={require('../images/husky.jpg')}
                    style={{ width: '80%', height: '40%' }}
                />
                <View style={[{ width: "90%", margin: 5, backgroundColor: "#f23151" }]}>
                    <Button
                        onPress={() => this.props.navigation.goBack()}
                        title="Hungry? Click me!"
                        color="#FFFFFF"
                    />
                </View>
                <Text/>
                <Text style={{ color: '#6c6c6c', fontSize: 15, fontWeight: 'bold' }}>
                    Developers:
                </Text>
                <Text style={styles.grayFont}>
                    Aayushi Maheshwari
                </Text>
                <Text style={styles.grayFont}>
                    Chaitya Shah
                </Text>
                <Text style={styles.grayFont}>
                    Harshit Vora
                </Text>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    pinkFont: {
        fontSize: 15,
        color: '#f23151'
    },
    grayFont: {
        fontSize: 15,
        color: '#6c6c6c'
    }
});