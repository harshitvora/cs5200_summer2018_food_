import React, { Component } from 'react';
import { Container, Content, List, ListItem, Text, Left, Right, Icon } from 'native-base';

export default class Account extends Component {
    render() {
        return (
            <Container>
                <Content style={styles.container}>
                    <List>
                        <ListItem>
                            <Left>
                                <Text>Name goes here</Text>
                            </Left>
                            <Right>
                                <Icon name="arrow-forward" style={{color: '#595959'}}/>
                            </Right>
                        </ListItem>
                        <ListItem>
                            <Left>
                                <Text>Payment Cards</Text>
                            </Left>
                            <Right>
                                <Icon name="arrow-forward" style={{color: '#595959'}}/>
                            </Right>
                        </ListItem>
                        <ListItem>
                            <Left>
                                <Text>Addresses</Text>
                            </Left>
                            <Right>
                                <Icon name="arrow-forward" style={{color: '#595959'}}/>
                            </Right>
                        </ListItem>
                        <ListItem>
                            <Left>
                                <Text>Account Credits</Text>
                            </Left>
                            <Right>
                                <Icon name="arrow-forward" style={{color: '#595959'}}/>
                            </Right>
                        </ListItem>
                        <ListItem>
                            <Left>
                                <Text>Logout</Text>
                            </Left>
                            <Right>
                                <Icon name="arrow-forward" style={{color: '#595959'}}/>
                            </Right>
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
    },
};