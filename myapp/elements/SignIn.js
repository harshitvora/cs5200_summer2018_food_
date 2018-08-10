import React, {Component} from 'react';
import { View, TextInput } from 'react-native';
import { FormLabel, FormInput } from 'react-native-elements';
import { Container, Header, Content, Left, Body, Right, Button, Icon, Segment, Text, Form, Item, Input, Label } from 'native-base';
import AddressForm from "./AddressForm";

class HeaderSegment extends React.Component {
    render() {
        return (
            <Header hasSegment>
                {/*<Left>*/}
                    {/*<Button transparent>*/}
                        {/**/}
                    {/*</Button>*/}
                {/*</Left>*/}
                <Body>
                <Segment>
                    <Button first><Text>Sign Up</Text></Button>
                    <Button last active><Text>Sign In</Text></Button>
                </Segment>
                </Body>
                <Right>
                    {/*<Button transparent>*/}
                        {/*<Text>Skip</Text>*/}
                    {/*</Button>*/}
                </Right>
            </Header>
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
        const params = navigation.state.params || {};
        this.state = {
            seg: 2
        }

        return {
            headerTitle: (
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
            ),
            headerLeft: (
                <Button
                    transparent
                    onPress={() => this.props.navigation.goBack()}
                >
                    <Icon name="arrow-back" style={{color: '#fff'}} />
                </Button>
            ),
            headerRight: (
                <Button
                    onPress={() => this.props.navigation.navigate('AddressForm')}
                    title="Skip"
                    style={{backgroundColor: '#f23151'}}
                >
                    <Text style={{color: '#fff'}}>Skip</Text>
                </Button>
            ),
        };
    };

    updateForm(newState) {
        this.newState(newState)
    }

    render() {
        return(
            <Container>
                <Content padder first>
                    <View style={styles.container}>
                        <View style={styles.loginSquare}>
                            <View style={styles.loginHeader}>
                                <Text style={styles.loginText}>Login</Text>
                            </View>
                            <View style={styles.loginEmail}>
                                <TextInput style={styles.inputText} placeholder="Email"/>
                            </View>
                            <View style={styles.loginPassword}>
                                <TextInput style={styles.inputText} placeholder="Password"/>
                            </View>
                            <View style={styles.loginButton}>
                                <Button block style={{backgroundColor: '#f23151'}}>
                                    <Text style={styles.loginText}>Sign In</Text>
                                </Button>
                            </View>
                        </View>
                        <FormLabel style={styles.loginEmail}>Email</FormLabel>
                        <FormInput style={styles.inputText} onChangeText={text => this.updateForm({email: text})}/>
                        <FormLabel style={styles.loginPassword}>Password</FormLabel>
                        <FormInput style={styles.inputText} onChangeText={text => this.updateForm({password: text})}/>
                    </View>
                    <Field name="email" component={this.renderInput} />
                    <Field name="name" component={this.renderInput} />
                    <Button block primary onPress= {reset}>
                        <Text>Submit</Text>
                    </Button>
                </Content>
            </Container>

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
    loginEmail: {
        width: '100%',
        height: 50,
        marginTop: 5,
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