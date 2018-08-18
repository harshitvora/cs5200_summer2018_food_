import React, { Component } from 'react';
import { Container, Content, Item, Input, Icon, Button, Text } from 'native-base';

export default class Orders extends Component {
    render() {
        return (
            <Container>
                <Content style={styles.container}>
                    <Text style={{ color: '#595959', paddingTop: 10, fontWeight: 'bold' }}>PREVIOUS ORDERS</Text>
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