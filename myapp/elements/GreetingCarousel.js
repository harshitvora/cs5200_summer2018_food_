import React, { Component } from 'react';
import { View, ScrollView, Image, StyleSheet, Dimensions, Text } from 'react-native';
import Carousel, { Pagination } from 'react-native-snap-carousel';

const { width } = Dimensions.get('window');
const height = 300;

export default class GreetingCarousel extends Component {

    constructor(props) {
        super(props);
    }

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