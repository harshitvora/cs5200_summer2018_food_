import React, {Component} from 'react';
import { View } from 'react-native';
import { Container, Content, Footer, Button, Text } from 'native-base';
import ConfirmAddress from './ConfirmAddress';

export default class RefineLocation extends Component {
    constructor(props) {
        super(props);
        this.state = {

        }
    }

    static navigationOptions = ({ navigation }) => {
        const { params } = navigation.state;

        return {
            headerTitle: (
                <Text style={{color: '#f23151', fontSize: 20, fontWeight: 'bold'}}>Refine Location</Text>
            ),
        };
    };

    updateForm(newState) {
        this.setState(newState)
    }

    render() {

        const address = this.props.navigation.getParam('address', 'no address');

        return(
            <Container>
                <Content>
                    <View style={styles.container}>
                        <Text style={{color: '#595959', padding: 15, fontSize: 15}}>
                            Refine your location by dragging the pin.
                        </Text>
                        <Text style={{color: '#595959', padding: 15, fontSize: 25, fontWeight: 'bold'}}>{address}</Text>
                    </View>
                </Content>
                <Footer>
                    <View style={styles.submitButton}>
                        <Button block
                                title="SaveLocation"
                                style={{backgroundColor: '#f23151'}}
                                onPress={() => this.props.navigation.navigate('ConfirmAddress')}>
                            <Text style={{color: '#FFFFFF'}}>Save Location</Text>
                        </Button>
                    </View>
                </Footer>
            </Container>
        )
    }
}

const styles = {
    container: {
        justifyContent: 'center',
        alignItems: 'center',
        display: 'flex'
    },
    submitButton: {
        width: '80%',
        margin: 10,
        justifyContent: 'center',
        alignItems: 'center'
    }
};