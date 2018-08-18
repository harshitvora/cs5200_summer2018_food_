import React, { Component } from 'react';
import { Text } from 'react-native';
import { Container, Content, List, ListItem, CheckBox, Body, Button, Left, Right, Radio, View } from 'native-base';

export default class Filter extends Component {

    constructor(props) {
        super(props);
        this.state = {
            sortSelected: 'topRated',
            priceSelected: '',
            addonSelected: false,
        };
        this.selectionOnPress = this.selectionOnPress.bind(this);
        this.priceSelectionOnPress = this.priceSelectionOnPress.bind(this);
        this.addonSelectionOnPress = this.addonSelectionOnPress.bind(this);
    }

    static navigationOptions = ({ navigation }) => {
        const { params } = navigation.state;

        return {
            headerTitle: (
                <Text style={{color: '#000000', fontSize: 20, fontWeight: 'bold'}}>Filters</Text>
            ),
            headerLeft: (
                <Button
                    transparent
                    title="filter"
                    onPress={() => navigation.goBack()}
                >
                    <Text style={{color: '#f23151', padding: 5}}>Cancel</Text>
                </Button>
            ),
            headerRight: (
                <Button
                    transparent
                    title="filter"
                    onPress={() => navigation.navigate('Filter')}
                >
                    <Text style={{color: '#f23151', padding: 5}}>Clear</Text>
                </Button>
            ),
        };
    };

    selectionOnPress(sortType) {
        this.setState({ sortSelected: sortType})
    }

    priceSelectionOnPress(price) {
        this.setState({ priceSelected: price })
    }

    addonSelectionOnPress(addon) {
        this.setState({ addonSelected: addon })
    }

    render() {
        return (
            <Container>
                <Content style={styles.container}>
                    <List>
                        <Text style={{color: '#000000', fontWeight: 'bold', padding: 10}}>SORT BY</Text>
                        <ListItem>
                            <Left>
                                <Text color={this.state.sortSelected === 'topRated' ? '#f23151' : '#595959'}>Top Rated</Text>
                            </Left>
                            <Right>
                                <Radio
                                    color={this.state.sortSelected === 'topRated' ? '#595959' : '#f23151'}
                                    onPress={() => this.selectionOnPress('topRated')}
                                    selected={this.state.sortSelected === 'topRated'}
                                    selectedColor={this.state.sortSelected === 'topRated' ? '#f23151' : '#595959'}
                                />
                            </Right>
                        </ListItem>
                        <ListItem>
                            <Left>
                                <Text color={this.state.sortSelected === 'lowestDelivery' ? '#f23151' : '#595959'}>Lowest Delivery Fee</Text>
                            </Left>
                            <Right>
                                <Radio
                                    color={this.state.sortSelected === 'lowestDelivery' ? '#595959' : '#f23151'}
                                    onPress={() => this.selectionOnPress('lowestDelivery')}
                                    selected={this.state.sortSelected === 'lowestDelivery'}
                                    selectedColor={this.state.sortSelected === 'lowestDelivery' ? '#f23151' : '#595959'}
                                />
                            </Right>
                        </ListItem>
                        <ListItem>
                            <Left>
                                <Text color={this.state.sortSelected === 'highestDelivery' ? '#f23151' : '#595959'}>Fastest Delivery</Text>
                            </Left>
                            <Right>
                                <Radio
                                    color={this.state.sortSelected === 'highestDelivery' ? '#595959' : '#f23151'}
                                    onPress={() => this.selectionOnPress('highestDelivery')}
                                    selected={this.state.sortSelected === 'highestDelivery'}
                                    selectedColor={this.state.sortSelected === 'highestDelivery' ? '#f23151' : '#595959'}
                                />
                            </Right>
                        </ListItem>
                        <ListItem>
                            <Left>
                                <Text color={this.state.sortSelected === 'mostPopular' ? '#f23151' : '#595959'}>Most Popular</Text>
                            </Left>
                            <Right>
                                <Radio
                                    color={this.state.sortSelected === 'mostPopular' ? '#595959' : '#f23151'}
                                    onPress={() => this.selectionOnPress('mostPopular')}
                                    selected={this.state.sortSelected === 'mostPopular'}
                                    selectedColor={this.state.sortSelected === 'mostPopular' ? '#f23151' : '#595959'}
                                />
                            </Right>
                        </ListItem>
                    </List>
                    <Text style={{color: '#000000', fontWeight: 'bold', padding: 10}}>MENU PRICES</Text>
                    <View style={{flexDirection: "row", justifyContent: 'center'}}>
                        <Button bordered
                                style={{ width:'30%',
                                    marginRight: 5,
                                    justifyContent: 'center',
                                    borderColor: '#f23151',
                                    backgroundColor: this.state.priceSelected === 'cheap' ? '#f23151' : '#ffffff'}}
                                onPress={() => this.priceSelectionOnPress('cheap')}
                                title="Cheap">
                            <Text style={{fontSize: 25, color:  this.state.priceSelected === 'cheap' ? '#ffffff' : '#f23151'}}>$</Text>
                        </Button>
                        <Button bordered
                                style={{ width:'30%',
                                    marginRight: 5,
                                    justifyContent: 'center',
                                    borderColor: '#f23151',
                                    backgroundColor: this.state.priceSelected === 'medium' ? '#f23151' : '#ffffff'}}
                                onPress={() => this.priceSelectionOnPress('medium')}
                                title="Medium">
                            <Text style={{fontSize: 25, color:  this.state.priceSelected === 'medium' ? '#ffffff' : '#f23151'}}>$$</Text>
                        </Button>

                        <Button bordered
                                style={{ width:'30%',
                                    justifyContent: 'center',
                                    borderColor: '#f23151',
                                    backgroundColor: this.state.priceSelected === 'expensive' ? '#f23151' : '#ffffff'}}
                                onPress={() => this.priceSelectionOnPress('expensive')}
                                title="Expensive">
                            <Text style={{fontSize: 25, color: this.state.priceSelected === 'expensive' ? '#ffffff' : '#f23151'}}>$$$</Text>
                        </Button>

                    </View>
                    <Text style={{color: '#000000', fontWeight: 'bold', padding: 10}}>ADDITIONAL FILTERS</Text>
                    <List>
                        <ListItem>
                            <CheckBox checked={this.state.addonSelected}
                                      color= {this.state.addonSelected ? '#f23151' : '#ffffff'}
                                      style={{borderColor: '#f23151'}}
                                      onPress={() => {
                                          if(this.state.addonSelected) this.addonSelectionOnPress(false);
                                          else this.addonSelectionOnPress(true);
                                      }}/>
                            <Body>
                            <Text> Has vegetarian options</Text>
                            </Body>
                        </ListItem>
                    </List>
                </Content>
            </Container>
        );
    }
}

const styles = {
    container: {
        margin:10
    }
};