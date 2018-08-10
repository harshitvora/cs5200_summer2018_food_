import React, {Component} from 'react';
import { Container, Header, Left, Body, Right, Button, Icon, Segment, Content, Text } from 'native-base';

export default class SignInSignUpSegment extends Component {

    constructor(props) {
        super(props)
    }

    render() {
        return(
            <Container>
                <Header hasSegment>
                    <Left>
                        <Button transparent>
                            <Icon name="arrow-back" />
                        </Button>
                    </Left>
                    <Body>
                    <Segment>
                        <Button first><Text>Sign Up</Text></Button>
                        <Button last active><Text>Sign In</Text></Button>
                    </Segment>
                    </Body>
                    <Right>
                        <Button transparent>
                            <Text>Skip</Text>
                        </Button>
                    </Right>
                </Header>
                <Content padder first>
                    <Text>Sign Up segment</Text>
                </Content>
                <Content padder last>
                    <Text>Sign In segment</Text>
                </Content>
            </Container>
        )
    }
}