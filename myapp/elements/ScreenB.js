import React, {Component} from 'react';
import { Button, View, ScrollView } from 'react-native';
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
            <ScrollView style={{padding: 15}}>
                <Text h3>Screen B</Text>
                <Button title="Go Home" onPress={() => this.props.navigation.goBack()}/>
            </ScrollView>
        )
    }
}

export default ScreenB