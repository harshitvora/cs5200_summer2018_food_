import React, {Component} from 'react';
import { Button, View, ScrollView } from 'react-native';
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
            <ScrollView style={{padding: 15}}>
                <Text h3>Screen A</Text>
                <Button title="Go Home" onPress={() => this.props.navigation.goBack()}/>
            </ScrollView>
        )
    }
}

export default ScreenA