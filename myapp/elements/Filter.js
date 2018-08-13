import React, { Component } from 'react';
import { Drawer } from 'native-base';
import FilterBar from './FilterBar';

export default class Filter extends Component {
    render() {
        closeDrawer = () => {
            this.drawer._root.close()
        };
        openDrawer = () => {
            this.drawer._root.open()
        };
        return (
            <Drawer
                ref={(ref) => { this.drawer = ref; }}
                content={<FilterBar navigator={this.navigator} />}
                onClose={() => this.closeDrawer()} >
                // Main View
            </Drawer>
        );
    }
}