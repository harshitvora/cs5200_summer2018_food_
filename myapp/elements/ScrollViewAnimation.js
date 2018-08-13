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

const HEADER_MAX_HEIGHT = 200;
const HEADER_MIN_HEIGHT = 60;
const HEADER_SCROLL_DISTANCE = HEADER_MAX_HEIGHT - HEADER_MIN_HEIGHT;

export default class ScrollViewAnimation extends Component {
    constructor(props) {
        super(props);
        this.state = {
            selectedTab: 'food',
            scrollY: new Animated.Value(0),
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
                    onPress={() => navigation.navigate('Filter')}
                >
                    <Icon name="funnel" style={{color: '#f23151'}}/>
                </Button>
            ),
        };
    };

    _renderScrollViewContent() {
        const data = Array.from({length: 30});
        return (
            <View style={styles.scrollViewContent}>
                {data.map((_, i) =>
                    <View key={i} style={styles.row}>
                        <Text>{i}</Text>
                    </View>
                )}
            </View>
        );
    }

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

        const headerHeight = this.state.scrollY.interpolate({
            inputRange: [0, HEADER_SCROLL_DISTANCE],
            outputRange: [HEADER_MAX_HEIGHT, HEADER_MIN_HEIGHT],
            extrapolate: 'clamp',
        });

        const imageOpacity = this.state.scrollY.interpolate({
            inputRange: [0, HEADER_SCROLL_DISTANCE / 2, HEADER_SCROLL_DISTANCE],
            outputRange: [1, 1, 0],
            extrapolate: 'clamp',
        });
        const imageTranslate = this.state.scrollY.interpolate({
            inputRange: [0, HEADER_SCROLL_DISTANCE],
            outputRange: [0, -50],
            extrapolate: 'clamp',
        });

        closeDrawer = () => {
            this.drawer._root.close()
        };
        openDrawer = () => {
            this.drawer._root.open()
        };

        return(
            <View style={styles.fill}>
                <ScrollView style={styles.fill}
                            scrollEventThrottle={16}
                            onScroll={Animated.event(
                                [{nativeEvent: {contentOffset: {y: this.state.scrollY}}}]
                            )}
                >
                    {this._renderScrollViewContent()}

                </ScrollView>
                <Animated.Image
                    style={[
                        styles.backgroundImage,
                        {opacity: imageOpacity, transform: [{translateY: imageTranslate}]},
                    ]}
                    source={require('../images/husky.jpg')}
                />
                <Animated.View style={[styles.header, {height: headerHeight}]}>
                    <View style={styles.bar}>
                        <Text style={styles.title}>Browse</Text>
                    </View>
                </Animated.View>
            </View>
            // <Container style={{backgroundColor:'#fff'}}>
            //     <Content>
            //         {this.renderSelectedTab()}
            //     </Content>
            //     <Footer>
            //         <FooterTab>
            //             <TouchableOpacity onPress={() => this.selectionOnPress('food')} >
            //                 <Button active={this.setState.selectedTab==='food'}
            //                         onPress={() => this.setState({selectedTab: 'food'})}>
            //                     <Icon name="restaurant"
            //                           active={this.setState.selectedTab==='food'}
            //                           style={{color: this.state.selectedTab === 'food' ? '#f23151' : '#595959'}}/>
            //                     <Text style={{color: this.state.selectedTab === 'food' ? '#f23151' : '#595959'}}>Food</Text>
            //                 </Button>
            //             </TouchableOpacity>
            //             <TouchableOpacity onPress={() => this.selectionOnPress('drinks')} >
            //                 <Button
            //                         active={this.setState.selectedTab==='drinks'}
            //                         onPress={() => this.setState({selectedTab: 'drinks'})}>
            //                     <Icon name="wine"
            //                           style={{color: this.state.selectedTab === 'drinks' ? '#f23151' : '#595959'}}/>
            //                     <Text style={{color: this.state.selectedTab === 'drinks' ? '#f23151' : '#595959'}}>Drinks</Text>
            //                 </Button>
            //             </TouchableOpacity>
            //             <TouchableOpacity onPress={() => this.selectionOnPress('search')} >
            //                 <Button active={this.setState.selectedTab==='search'}
            //                         onPress={() => this.setState({selectedTab: 'search'})}>
            //                     <Icon name="search"
            //                           onPress={() => this.setState({selectedTab: 'search'})}
            //                           style={{color: this.state.selectedTab === 'search' ? '#f23151' : '#595959'}}/>
            //                     <Text style={{color: this.state.selectedTab === 'search' ? '#f23151' : '#595959'}}>Search</Text>
            //                 </Button>
            //             </TouchableOpacity>
            //             <TouchableOpacity onPress={() => this.selectionOnPress("orders")} >
            //                 <Button active={this.setState.selectedTab==='orders'}
            //                         onPress={() => this.setState({selectedTab: 'orders'})}>
            //                     <Icon name="cart"
            //                           style={{color: this.state.selectedTab === 'orders' ? '#f23151' : '#595959'}}/>
            //                     <Text style={{color: this.state.selectedTab === 'orders' ? '#f23151' : '#595959'}}>Orders</Text>
            //                 </Button>
            //             </TouchableOpacity>
            //             <TouchableOpacity onPress={() => this.selectionOnPress('account')} >
            //                 <Button active={this.setState.selectedTab==='account'}
            //                         onPress={() => this.setState({selectedTab: 'account'})}>
            //                     <Icon name="contact"
            //                           style={{color: this.state.selectedTab === 'account' ? '#f23151' : '#595959'}}/>
            //                     <Text style={{color: this.state.selectedTab === 'account' ? '#f23151' : '#595959'}}>Account</Text>
            //                 </Button>
            //             </TouchableOpacity>
            //         </FooterTab>
            //     </Footer>
            // </Container>
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
    fill: {
        flex: 1,
    },
    row: {
        height: 40,
        margin: 16,
        backgroundColor: '#D3D3D3',
        alignItems: 'center',
        justifyContent: 'center',
    },
    header: {
        position: 'absolute',
        top: 0,
        left: 0,
        right: 0,
        backgroundColor: '#f23151',
        overflow: 'hidden',
    },
    bar: {
        marginTop: 28,
        height: 32,
        alignItems: 'center',
        justifyContent: 'center',
    },
    title: {
        backgroundColor: 'transparent',
        color: 'white',
        fontSize: 18,
    },
    scrollViewContent: {
        marginTop: HEADER_MAX_HEIGHT,
    },
    backgroundImage: {
        position: 'absolute',
        top: 0,
        left: 0,
        right: 0,
        width: null,
        height: HEADER_MAX_HEIGHT,
        resizeMode: 'cover',
    },
};