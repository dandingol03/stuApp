/**
 * Created by danding on 17/5/20.
 */
import React, { Component } from 'react';
import {
    StyleSheet,
    Text,
    View,
    DrawerLayoutAndroid
} from 'react-native';


export default class DrawerLayout extends Component {

    constructor(props) {
        super(props);
    }

    closeDrawer() {
        this._drawer && this._drawer.closeDrawer();
    }

    openDrawer() {
        this._drawer && this._drawer.openDrawer();
    }

    render() {
        const { ...props} = this.props;

        var item= (
            <DrawerLayoutAndroid
                ref={(drawer) => { this._drawer = drawer; }}
                drawerWidth={300}
                drawerPosition={DrawerLayoutAndroid.positions.Left}
                {...props}
            >

            </DrawerLayoutAndroid>
        );


        return (
            item
        );
    }
}


const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#F5FCFF',
    },
    welcome: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
    instructions: {
        textAlign: 'center',
        color: '#333333',
        marginBottom: 5,
    },
});
