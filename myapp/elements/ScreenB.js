import React, {Component} from 'react';
import { Button, View } from 'react-native';
import {Text} from 'react-native-elements';

class ScreenB extends Component {
    static navigationOptions = {
        title: "Screen B"
    }

    constructor(props) {
        super(props)
    }

    render() {
        return(
            <View style={{padding: 15}}>
                <Text h3>Screen B</Text>
            </View>
        )
    }
}

export default ScreenB