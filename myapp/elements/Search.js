import React, { Component } from 'react';
import { View } from 'react-native';
import { Container, Header, Content, List, ListItem, Item, Input, Icon, Button, Text } from 'native-base';

export default class Search extends Component {

    constructor(props) {
        super(props);
        this.state = {
        }
    }

    render() {
        var cuisines = [
            'American',
            'Asian',
            'Barbeque',
            'Breakfast',
            'Indian'
        ];

        return (
            <Container>
                <Header searchBar block>
                    <Item>
                        <Icon name="ios-search" />
                        <Input placeholder="Search HuskyEats" />
                    </Item>
                </Header>
                <Content style={styles.container}>
                    <Text style={{ color: '#595959', fontWeight: 'bold' }}>CUISINES</Text>
                    <List dataArray={cuisines}
                          renderRow={(cuisine) =>
                              <ListItem>
                                  <Text style={{ color: '#f23151'}}>{cuisine}</Text>
                              </ListItem>
                          }>
                    </List>
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