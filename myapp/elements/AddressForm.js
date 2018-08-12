import React, {Component} from 'react';
import { View } from 'react-native';
import { FormLabel, FormInput } from 'react-native-elements';
import { Container, Content, Button, Icon, Segment, Text } from 'native-base';
import Restaurants from './Restaurants';

export default class AddressInput extends Component {
    constructor(props) {
        super(props)
        this.state = {
            address: ''
        }
    }

    static navigationOptions = ({ navigation }) => {
        const { params } = navigation.state;

        return {
            headerTitle: (
                <Text style={{color: '#fff', fontSize: 20, fontWeight: 'bold'}}>Enter Address</Text>
            ),
            headerRight: (
                <Button
                    disabled
                    transparent
                    onPress={() => this.props.navigation.navigate('Restaurants')}
                >
                    <Text style={{color: '#fff'}}>Next</Text>
                </Button>
            ),
        };
    };

    updateForm(newState) {
        this.newState(newState)
    }

    render() {
        return(
            <View>
                <Text style={{color: '#616161', padding: 15}}>Let us know where to send your order. Please enter an address or city name.</Text>
                <FormLabel>Street Address</FormLabel>
                <FormInput style={{border: 1}} onChangeText={text => this.updateForm({address: text})}/>
            </View>
        )
    }
}