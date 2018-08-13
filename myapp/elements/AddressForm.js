import React, {Component} from 'react';
import { View } from 'react-native';
import { FormLabel, FormInput } from 'react-native-elements';
import { Container, Content, Button, Text } from 'native-base';
import ConfirmAddress from "./ConfirmAddress";

export default class AddressForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            address: '',
            apt: '',
        }
    }

    static navigationOptions = ({ navigation }) => {
        const { params } = navigation.state;

        return {
            headerTitle: (
                <Text style={{color: '#f23151', fontSize: 20, fontWeight: 'bold'}}>Enter Address</Text>
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
                    <View>
                        <Text style={{color: '#595959', padding: 15}}>Let us know where to send your order. Please enter an address or city name.</Text>
                        <FormLabel>Street Address</FormLabel>
                        <FormInput style={{border: 1}} onChangeText={text => this.updateForm({address: text})}/>
                    </View>
                    { this.state.address &&
                    <View>
                        <View>
                            <FormLabel>Apartment # (Optional)</FormLabel>
                            <FormInput style={{border: 1}} onChangeText={text => this.updateForm({apt: text})}/>
                        </View>
                        <View style={styles.container}>
                            <View style={styles.submitButton}>
                                <Button block
                                        title="submit"
                                        style={{backgroundColor: '#f23151'}}
                                        onPress={() => this.props.navigation.navigate('ConfirmAddress', {'address': this.state.address + ', ' + this.state.apt})}>
                                    <Text style={{color: '#FFFFFF'}}>Submit</Text>
                                </Button>
                            </View>
                        </View>
                    </View>}
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
    submitButton: {
        width: '80%',
        margin: 10,
        justifyContent: 'center',
        alignItems: 'center'
    }
};