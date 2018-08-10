import React, {Component} from 'react';
import { View, Text, TextInput } from 'react-native';
import { FormLabel, FormInput } from 'react-native-elements';
import { Container, Header, Content, Form, Item, Input, Label, Button } from 'native-base';

export default class SignUp extends Component {

    constructor(props) {
        super(props)
    }

    render() {
        return(
            <View style={styles.container}>
                <View style={styles.loginSquare}>
                    <View style={styles.loginHeader}>
                        <Text style={styles.loginText}>Login</Text>
                    </View>
                    <View style={styles.loginFirstName}>
                        <TextInput style={styles.inputText} placeholder="First Name"/>
                    </View>
                    <View style={styles.loginForm}>
                        <TextInput style={styles.inputText} placeholder="Last Name"/>
                    </View>
                    <View style={styles.loginForm}>
                        <TextInput style={styles.inputText} placeholder="Email"/>
                    </View>
                    <View style={styles.loginForm}>
                        <TextInput style={styles.inputText} placeholder="Phone"/>
                    </View>
                    <View style={styles.loginPassword}>
                        <TextInput style={styles.inputText} placeholder="Password"/>
                    </View>
                    <View style={styles.loginButton}>
                        <Button block style={{backgroundColor: '#f23151'}}>
                            <Text style={styles.loginText}>Sign Up</Text>
                        </Button>
                    </View>
                </View>
            </View>
        )
    }
}

const styles = {
    container: {
        width: '100%',
        height: '100%',
        justifyContent: 'center',
        alignItems: 'center',
        display: 'flex',
    },
    loginSquare: {
        backgroundColor: '#FFFFFF',
        height: '100%',
        width: '100%',
        display: 'flex',
        justifyContent: 'flex-start',
        alignItems: 'center'
    },
    loginHeader: {
        backgroundColor: '#f23151',
        width: '100%',
        height: 75,
        justifyContent: 'center',
        alignItems: 'center'
    },
    loginText: {
        color: '#FFFFFF'
    },
    loginFirstName: {
        width: '100%',
        height: 50,
        marginTop: 5,
        borderColor: 'gray'
    },
    loginForm: {
        width: '100%',
        height: 50,
        borderColor: 'gray'
    },
    loginPassword: {
        width: '100%',
        height: 50,
        marginBottom: 5,
        borderColor: 'gray'
    },
    loginButton: {
        width: '80%',
        justifyContent: 'center',
        alignItems: 'center'
    },
    inputText: {
        borderWidth: 2,  // size/width of the border
        borderColor: 'lightgrey',  // color of the border
        paddingLeft: 10,
        height: 50
    }
}