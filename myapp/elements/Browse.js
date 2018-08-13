import React, {Component} from 'react';
import { Animated, View, ScrollView, Text, TouchableOpacity } from 'react-native';
import { Container, Header, Content, Footer, FooterTab, Left, Right, Icon, Body, Title, Button, Drawer } from 'native-base';
import RF from "react-native-responsive-fontsize";
import Food from "./Food";
import Drinks from "./Drinks";
import Search from "./Search";
import Orders from "./Orders";
import Account from "./Account";
import Filter from "./Filter";

export default class Browse extends Component {
    constructor(props) {
        super(props);
        this.state = {
            selectedTab: 'food',
        };
        this.selectionOnPress = this.selectionOnPress.bind(this)
    }

    static navigationOptions = ({ navigation }) => {
        const { params } = navigation.state;

        return {
            headerLeft: (
                <Text style={{color: '#000000', fontSize: 25, fontWeight: 'bold', padding: 15}}>Browse</Text>
            ),
            headerRight: (
                <Button
                    transparent
                    title="filter"
                    onPress={() => navigation.navigate('Filter')}
                >
                    <Icon name="funnel" style={{color: '#f23151'}}/>
                </Button>
            ),
        };
    };

    updateForm(newState) {
        this.setState(newState)
    }

    selectionOnPress(userType) {
        this.setState({ selectedTab: userType })
    }

    renderSelectedTab () {
        switch (this.state.selectedTab) {
            case 'food':
                return (<Food{...this.props}/>);
                break;
            case 'drinks':
                return (<Drinks{...this.props}/>);
                break;
            case 'search':
                return (<Search{...this.props}/>);
                break;
            case 'orders':
                return (<Orders{...this.props}/>);
                break;
            case 'account':
                return (<Account{...this.props}/>);
                break;
        }
    }

    render() {

        closeDrawer = () => {
            this.drawer._root.close()
        };
        openDrawer = () => {
            this.drawer._root.open()
        };

        return(
            <Container style={{backgroundColor:'#fff'}}>
                <Content>
                    {this.renderSelectedTab()}
                </Content>
                <Footer>
                    <FooterTab>
                        <TouchableOpacity onPress={() => this.selectionOnPress('food')} >
                            <Button title="food"
                                    active={this.setState.selectedTab==='food'}
                                    onPress={() => this.setState({selectedTab: 'food'})}>
                                <Icon name="restaurant"
                                      active={this.setState.selectedTab==='food'}
                                      style={{color: this.state.selectedTab === 'food' ? '#f23151' : '#595959'}}/>
                                <Text style={{color: this.state.selectedTab === 'food' ? '#f23151' : '#595959'}}>Food</Text>
                            </Button>
                        </TouchableOpacity>
                        <TouchableOpacity onPress={() => this.selectionOnPress('drinks')} >
                            <Button title="drinks"
                                    active={this.setState.selectedTab==='drinks'}
                                    onPress={() => this.setState({selectedTab: 'drinks'})}>
                                <Icon name="wine"
                                      style={{color: this.state.selectedTab === 'drinks' ? '#f23151' : '#595959'}}/>
                                <Text style={{color: this.state.selectedTab === 'drinks' ? '#f23151' : '#595959'}}>Drinks</Text>
                            </Button>
                        </TouchableOpacity>
                        <TouchableOpacity onPress={() => this.selectionOnPress('search')} >
                            <Button title="search"
                                    active={this.setState.selectedTab==='search'}
                                    onPress={() => this.setState({selectedTab: 'search'})}>
                                <Icon name="search"
                                      onPress={() => this.setState({selectedTab: 'search'})}
                                      style={{color: this.state.selectedTab === 'search' ? '#f23151' : '#595959'}}/>
                                <Text style={{color: this.state.selectedTab === 'search' ? '#f23151' : '#595959'}}>Search</Text>
                            </Button>
                        </TouchableOpacity>
                        <TouchableOpacity onPress={() => this.selectionOnPress("orders")} >
                            <Button title="orders"
                                    active={this.setState.selectedTab==='orders'}
                                    onPress={() => this.setState({selectedTab: 'orders'})}>
                                <Icon name="cart"
                                      style={{color: this.state.selectedTab === 'orders' ? '#f23151' : '#595959'}}/>
                                <Text style={{color: this.state.selectedTab === 'orders' ? '#f23151' : '#595959'}}>Orders</Text>
                            </Button>
                        </TouchableOpacity>
                        <TouchableOpacity onPress={() => this.selectionOnPress('account')} >
                            <Button title="account"
                                    active={this.setState.selectedTab==='account'}
                                    onPress={() => this.setState({selectedTab: 'account'})}>
                                <Icon name="contact"
                                      style={{color: this.state.selectedTab === 'account' ? '#f23151' : '#595959'}}/>
                                <Text style={{color: this.state.selectedTab === 'account' ? '#f23151' : '#595959'}}>Account</Text>
                            </Button>
                        </TouchableOpacity>
                    </FooterTab>
                </Footer>
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
    },
};