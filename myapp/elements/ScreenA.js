import React, {Component} from 'react';
import { Button, View } from 'react-native';
import {Text} from 'react-native-elements';

class ScreenA extends Component {
    static navigationOptions = {
        title: "Screen A"
    }

    constructor(props) {
        super(props)
    }

    render() {
        return(
            <View style={{padding: 15}}>
                <Text h3>Screen A</Text>
            </View>
        )
    }
}

export default ScreenA