import React, { Component } from 'react';
import { View, ScrollView, Image, StyleSheet, Dimensions, Text } from 'react-native';
import Carousel, { Pagination } from 'react-native-snap-carousel';

const { width } = Dimensions.get('window');
const height = 300;

const entries = [
    {
        name: 'Order all your favorites',
        text: 'Order from the best local restaurants with easy, on-demand delivery.',
        image: require('../images/orderfood.jpg'),
    },
    {
        name: 'Free delivery offers',
        text: 'HuskyEats regularly offers free delivery for new customers via Apple Pay.',
        image: require('../images/payment.jpg'),
    },
    {
        name: 'Unmatched Reliability',
        text: 'Experience peace of mind while tracking your order in real time.',
        image: require('../images/track.jpg'),
    },
    {
        name: 'Five start dashers',
        text: 'Enjoy deliveries from a friendly vetted fleet.',
        image: require('../images/deliveryuncle.jpg'),
    },
    {
        name: 'Here for you',
        text: 'Something come up? Talk to a real person. We\'re here to help.',
        image: require('../images/customerservice.jpg'),
    }
];

export default class GreetingCarousel extends Component {

    constructor(props) {
        super(props);
    }

    _renderItem({item, index}) {
        return <MySlideComponent data={item}/>
    }

    // get pagination() {
    //     const {entries, activeSlide} = this.state;
    //     return (
    //         <Pagination
    //             dotsLength={entries.length}
    //             activeDotIndex={activeSlide}
    //             containerStyle={{backgroundColor: 'rgba(0, 0, 0, 0.75)'}}
    //             dotStyle={{
    //                 width: 10,
    //                 height: 10,
    //                 borderRadius: 5,
    //                 marginHorizontal: 8,
    //                 backgroundColor: 'rgba(255, 255, 255, 0.92)'
    //             }}
    //             inactiveDotStyle={{
    //                 // Define styles for inactive dots here
    //             }}
    //             inactiveDotOpacity={0.4}
    //             inactiveDotScale={0.6}
    //         />
    //     );
    // }

    // render() {
    //     return (
    //         <View>
    //             <Carousel
    //                 data={this.state.entries}
    //                 renderItem={this._renderItem}
    //                 onSnapToItem={(index) => this.setState({activeSlide: index})}
    //             />
    //             {this.pagination}
    //         </View>
    //     );
    // }

    render() {
        const { images } = this.props;
        if (images && images.length) {
            return (
                <View style={styles.scrollContainer}>
                    <ScrollView
                        horizontal
                        pagingEnabled
                        showsHorizontalScrollIndicator={false}
                    >
                        {images.map(image => (
                            <Image key={image.id} style={styles.image} source={image.source} />
                        ))}
                    </ScrollView>
                </View>
            );
        }
        return null;
    }
}

const styles = StyleSheet.create({
    scrollContainer: {
        height,
    },
    image: {
        width,
        height,
    },
});