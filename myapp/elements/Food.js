import React, { Component } from 'react';
import { View, Image } from 'react-native';
import { Container, Content, Item, Input, Icon, Button, Text } from 'native-base';
import Addresses from './Addresses';

export default class Food extends Component {

    constructor(props) {
        super(props);
        this.state = {
        }
    }

    static navigationOptions = ({ navigation }) => {
        const { params } = navigation.state;

        return {
            headerLeft: (
                <Text style={{color: '#000000', fontWeight: 'bold', fontSize: '20'}}>Search</Text>
            ),
        };
    };

    render() {

        const address = this.props.navigation.getParam('address', 'no address');

        return (
            <Container>
                <Content style={styles.container}>
                    <Text style={{ color: '#595959', paddingTop: 10, fontSize: 12, fontWeight: 'bold' }}
                          onPress={() => this.props.navigation.navigate('Addresses', {'address': address})}>ADDRESS</Text>
                    <Text style={{ color: '#f23151', paddingBottom: 10 }}
                          onPress={() => this.props.navigation.navigate('Addresses', {'address': address})}>{address}</Text>

                    <View style={{ borderColor: '#eaeae7', borderWidth: 0.5, margin:10 }}/>
                    <Image source={require('../images/freedelivery.jpg')}
                           style={{height: 200, width: 300, flex: 1}}/>

                    <Text style={{ color: '#595959', paddingTop: 10, fontWeight: 'bold' }}>CUISINES</Text>
                    <View style={{ borderColor: '#f23151', borderWidth: 2, width: 30 }}/>

                    <Text style={{ color: '#595959', paddingTop: 10, fontWeight: 'bold' }}>ALL RESTAURANTS</Text>
                    <View style={{ borderColor: '#f23151', borderWidth: 2, width: 30 }}/>

                    <Text style={{ color: '#595959', paddingTop: 10, fontWeight: 'bold' }}>CUISINES</Text>
                    <View style={{ borderColor: '#f23151', borderWidth: 2, width: 30 }}/>

                    <View style={{ borderColor: '#eaeae7', borderWidth: 0.5, margin:10 }}
                    />
                </Content>
            </Container>
        );
    }
}

const styles = {
    container: {
        margin:10
    },
};