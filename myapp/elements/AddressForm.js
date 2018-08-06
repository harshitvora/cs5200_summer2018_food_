import React from 'react';
import {View} from 'react-native';
import {Text, FormLabel, FormInput, FormValidationMessage} from 'react-native-elements';

class AddressInput extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            address: ''
        }
    }

    updateForm(newState) {
        this.newState(newState)
    }

    render() {
        return(
            <View>
                <Text h5 style={{padding: 15}}>Let us know where to send your order. Please enter an address or city name.</Text>
                <FormLabel>Street Address</FormLabel>
                <FormInput onChangeText={text => this.updateForm({address: text})}/>
            </View>
        )
    }
}

export default AddressInput