import React, { Component } from 'react';
import { View } from 'react-native';
import { Container, Content, ListItem, Text, Radio, Right, Left, Icon, Button } from 'native-base';
import Browse from './Browse';
import AddressForm from './AddressForm';

export default class Addresses extends Component {

    constructor(props) {
        super(props);
        this.state = {
            addressSelected: 'addressOne',
        };
        this.selectionOnPress = this.selectionOnPress.bind(this)
    }

    static navigationOptions = ({ navigation }) => {
        const { params } = navigation.state;

        return {
            headerTitle: (
                <Text style={{color: '#595959', fontSize: 20, fontWeight: 'bold'}}>Addresses</Text>
            ),
            headerLeft: (
                <Button
                    transparent
                    onPress={() => navigation.navigate('Browse')}
                >
                    <Text style={{color: '#f23151'}}>Done</Text>
                </Button>
            ),
            headerRight: (
                <Button
                    transparent
                    onPress={() => navigation.navigate('AddressForm')}
                >
                    <Icon name="add-circle" style={{color: '#f23151'}}/>
                </Button>
            ),
        };
    };

    selectionOnPress(userType) {
        this.setState({ addressSelected: userType })
    }

    render() {

        const address = this.props.navigation.getParam('address', 'no address');

        return (
            <Container>
                <Content style={styles.container}>
                    <ListItem selected={this.state.addressSelected == 'addressOne'}>
                        <Left>
                            <Text style={{color: '#f23151'}}>{address}</Text>
                        </Left>
                        <Right>
                            <Radio
                                color={this.state.addressSelected === 'addressOne' ? '#595959' : '#f23151'}
                                onPress={() => this.selectionOnPress('addressOne')}
                                selected={this.state.addressSelected == 'addressOne'}
                                selectedColor={this.state.addressSelected === 'addressOne' ? '#f23151' : '#595959'}
                            />
                        </Right>
                    </ListItem>
                    <ListItem  selected={this.state.addressSelected == 'addressTwo'}>
                        <Left>
                            <Text style={{color: '#595959'}}>Snell Library</Text>
                        </Left>
                        <Right>
                            <Radio
                                color={this.state.addressSelected === 'addressOne' ? '#595959' : '#f23151'}
                                onPress={() => this.selectionOnPress('addressTwo')}
                                selected={this.state.addressSelected == 'addressTwo'}
                                selectedColor={this.state.addressSelected === 'addressTwo' ? '#f23151' : '#595959'}
                            />
                        </Right>
                    </ListItem>
                </Content>
            </Container>
        );
    }
}

const styles = {
    container: {
        margin:10
    },
};