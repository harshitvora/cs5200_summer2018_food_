import React, { Component } from 'react';
import { Container, Header, Item, Input, Icon, Button, Text } from 'native-base';

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
                    <Text style={{color: '#000000', fontWeight: 'bold', fontSize: 20}}>Search</Text>
                    <Item>
                        <Icon name="ios-search" />
                        <Input placeholder="Search HuskyEats" />
                        <Icon name="ios-people" />
                    </Item>
                </Header>
            </Container>
        );
    }
}