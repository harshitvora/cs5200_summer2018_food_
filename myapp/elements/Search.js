import React, { Component } from 'react';
import { View } from 'react-native';
import { Container, Header, Content, Item, Input, Icon, Button, Text } from 'native-base';

export default class Search extends Component {

    constructor(props) {
        super(props);
        this.state = {
        }
    }

    render() {
        return (
            <Container>
                <Header searchBar block>
                    <Item>
                        <Icon name="ios-search" />
                        <Input placeholder="Search HuskyEats" />
                    </Item>
                </Header>
                <Content style={styles.container}>
                    <Text style={{ color: '#595959', paddingTop: 10, fontWeight: 'bold' }}>CUISINES</Text>
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