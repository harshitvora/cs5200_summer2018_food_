import React, {Component} from 'react';
import { View } from 'react-native';
import { FormLabel, FormInput } from 'react-native-elements';
import { Container, Content, Button, Icon, Segment, Text } from 'native-base';

class HeaderSegment extends React.Component {
    render() {
        this.state = {
            seg: 2
        }
        return (
            <Segment style={{backgroundColor: '#f23151'}}>
                <Button
                    first
                    style={{
                        backgroundColor: this.state.seg === 1 ? '#eee' : '#f23151',
                        borderColor: '#eee',
                    }}
                    active={this.state.seg === 1 ? true : false}
                    onPress={() => this.setState({ seg: 1 })}
                ><Text style={{color: this.state.seg === 1 ? '#f23151' : '#eee'}}>Sign Up</Text>
                </Button>
                <Button
                    last
                    style={{
                        backgroundColor: this.state.seg === 2 ? '#eee' : '#f23151',
                        borderColor: '#eee',
                    }}
                    active={this.state.seg === 2 ? true : false}
                    onPress={() => this.setState({ seg: 2 })}
                ><Text style={{color: this.state.seg === 1 ? '#eee' : '#f23151'}}>Sign In</Text>
                </Button>
            </Segment>
        );
    }
}

export default class SignIn extends Component {

    constructor(props) {
        super(props)
        this.state = {
            email: '',
            password: ''
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
                            <Button block style={{backgroundColor: '#f23151'}}>
                                <Text style={{color: '#FFFFFF'}}>Sign In</Text>
                            </Button>
                        </View>
                    </View>
                </Content>
            </Container>
        )
    }
}

const styles = {
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
}