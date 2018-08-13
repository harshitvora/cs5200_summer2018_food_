import React, {Component} from 'react';
import {StyleSheet, View} from 'react-native';
import { FormLabel, FormInput } from 'react-native-elements';
import { Container, Content, Button, Icon, Segment, Text } from 'native-base';
import SignUp from './SignUp';

class HeaderSegment extends React.Component {

    render() {
        this.state = {
            seg: 2
        };
        return (
            <Segment style={{backgroundColor: '#fff'}}>
                <Button
                    first
                    title="SignUp"
                    style={{
                        backgroundColor: this.state.seg === 1 ? '#f23151' : '#fff',
                        borderColor: '#f23151',
                    }}
                    active={this.state.seg === 1}
                    onPress={() => this.setState({ seg: 1 })}
                ><Text style={{color: this.state.seg === 1 ? '#fff' : '#f23151'}}>Sign Up</Text>
                </Button>
                <Button
                    last
                    title="SignIn"
                    style={{
                        backgroundColor: this.state.seg === 2 ? '#f23151' : '#fff',
                        borderColor: '#f23151',
                    }}
                    active={this.state.seg === 2}
                    onPress={() => this.setState({ seg: 2 })}
                ><Text style={{color: this.state.seg === 1 ? '#f23151' : '#fff'}}>Sign In</Text>
                </Button>
            </Segment>
        );
    }
}

export default class SignIn extends Component {

    constructor(props) {
        super(props);
        this.state = {
            email: '',
            password: '',
        }
    }

    static navigationOptions = ({ navigation }) => {
        const { params } = navigation.state;

        return {
            headerTitle: (
                <HeaderSegment/>
            ),
        };
    };

    updateForm(newState) {
        this.setState(newState)
    }

    render() {
        return(
            <Container>
                <Content>
                    <FormLabel>Email</FormLabel>
                    <FormInput onChangeText={text => this.updateForm({email: text})}/>
                    <FormLabel>Password</FormLabel>
                    <FormInput secureTextEntry={true} onChangeText={text => this.updateForm({password: text})}/>
                    <View style={styles.container}>
                        <View style={styles.loginButton}>
                            <Button block
                                    title="SignIn"
                                    style={{backgroundColor: '#f23151'}}
                                    onPress={() => this.setState({selectedTab: 'signin'})}>
                                <Text style={{color: '#FFFFFF'}}>Sign In</Text>
                            </Button>
                        </View>
                    </View>
                </Content>
            </Container>
        )
    }
}

const styles = StyleSheet.create({
    container: {
        justifyContent: 'center',
        alignItems: 'center',
        display: 'flex',
    },
    loginButton: {
        width: '80%',
        margin: 10,
        justifyContent: 'center',
        alignItems: 'center'
    }
});