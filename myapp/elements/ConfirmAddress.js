import React, {Component} from 'react';
import { View, TouchableOpacity} from 'react-native';
import { Container, Content, Footer, Button, Text, Form, Textarea } from 'native-base';
import Geocoder from 'react-native-geocoder';
import MapView,  { PROVIDER_GOOGLE } from "react-native-maps";
import RefineLocation from './RefineLocation';
import Browse from './Browse';
import GoogleMaps from 'react-native-maps';

// simply add your google key
Geocoder.fallbackToGoogle('AIzaSyCvAhyVQdC7VtQw-McXtUm9fDBwDneWdWI');

export default class ConfirmAddress extends Component {
    constructor(props) {
        super(props);
        this.state = {
            dasherInstructions: '',
            latitude: null,
            longitude: null,
        }
    }

    static navigationOptions = ({ navigation }) => {
        const { params } = navigation.state;

        return {
            headerTitle: (
                <Text style={{color: '#f23151', fontSize: 20, fontWeight: 'bold'}}>Confirm Address</Text>
            ),
        };
    };

    updateForm(newState) {
        this.setState(newState)
    }

    location() {
        Geocoder.init('AIzaSyCvAhyVQdC7VtQw-McXtUm9fDBwDneWdWI'); // use a valid API key

        let that = this;
        Geocoder.from(this.props.address)
            .then(json => {
                let loc = json.results[0].geometry.location;
                // that.setState({location: loc});
                console.log("loc",loc);

                let locWeNeed = new Object();
                locWeNeed.latitude = loc.lat;
                locWeNeed.longitude = loc.lng;
                locWeNeed.latitudeDelta=0.0922;
                locWeNeed.longitudeDelta= 0.0421;
                that.setState({locationObject: locWeNeed})
            })
            .catch(error => console.warn(error));
    }

    // const pointInView = await this._map.getPointInView([-37.817070, 144.949901]);

    getInitialState() {
        return {
            region: {
                latitude: 37.78825,
                longitude: -122.4324,
                latitudeDelta: 0.0922,
                longitudeDelta: 0.0421,
            },
        };
    }

    onRegionChange(region) {
        this.setState({ region });
    }

    refresh = () => {
        navigator.geolocation.getCurrentPosition(
            (position) => {
                this.setState({
                    latitude: position.coords.latitude,
                    longitude: position.coords.longitude
                });
            },
            { enableHighAccuracy: true, timeout: 20000, maximumAge: 1000 },
        );
    };

    render() {
        // Geocoder.geocodePosition(this.state.latitude,this.state.longitude)

        const address = this.props.navigation.getParam('address', 'no address');

        return(
            <Container>
                <Content>
                    <View style={styles.container}>
                        <Text style={{color: '#595959', padding: 15, fontSize: 20, fontWeight: 'bold'}}>{address}</Text>
                    </View>
                    <MapView
                        provider={ PROVIDER_GOOGLE }
                        initialRegion={{
                            latitude: 37.78825,
                            longitude: -122.4324,
                            latitudeDelta: 0.0922,
                            longitudeDelta: 0.0421
                        }}
                    />
                    <MapView
                        region={this.state.region}
                        onRegionChange={this.onRegionChange}
                    />
                    {/*<MapView*/}
                    {/*region={this.state.locationObject}*/}
                    {/*onRegionChange={this.onRegionChange}*/}
                    {/*/>*/}

                    {/*<MapView*/}
                    {/*region={this.getInitialState()}*/}
                    {/*onRegionChange={this.onRegionChange}*/}
                    {/*/>*/}

                    <View style={{ flexGrow: 1, alignItems: 'center', justifyContent: 'center' }}>
                        <Text>Latitude: {this.state.latitude}</Text>
                        <Text>Longitude: {this.state.longitude}</Text>

                        <Button
                            style={{ marginTop: 30 }}
                            onPress={() => { this.refresh(); }}
                            title="Refresh"
                        />
                    </View>
                    <View style={styles.container}>
                        <TouchableOpacity onPress={() => this.props.navigation.navigate('RefineLocation', {'address': address})}>
                        <Text style={{color: '#595959', padding: 5}}>
                            Not quite right?
                            <Text style={{color: '#f23151'}}> Refine your location</Text>
                        </Text>
                        </TouchableOpacity>
                        <Form>
                            <Textarea rowSpan={6}
                                      bordered
                                      style={{color: '#595959'}}
                                      placeholder="DASHER INSTRUCTIONS" />

                        </Form>
                    </View>
                </Content>
                <Footer>
                    <View style={styles.submitButton}>
                        <Button block
                                title="ConfirmAddress"
                                style={{backgroundColor: '#f23151'}}
                                onPress={() => this.props.navigation.navigate('Browse', {'address': address})}>
                            <Text style={{color: '#FFFFFF'}}>Confirm Address</Text>
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