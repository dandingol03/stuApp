
import React, { Component } from 'react';
import {
    AppRegistry,
    StyleSheet,
    Text,
    View,
    StatusBar
} from 'react-native';
import { connect } from 'react-redux';

var F8Navigator = require('../components/F8Navigator');
import Login from './Login'


 class App extends Component {
    render() {

        if(this.props.auth==true)//已登录
        {
            return (
                <View style={styles.container}>
                    <StatusBar
                        translucent={true}
                        backgroundColor="rgba(0, 0, 0, 0.2)"
                        barStyle="light-content"
                    />
                    <F8Navigator/>
                </View>
            );
        }else{
            return (
               <Login/>
            );
        }

    }
    componentDidMount()
    {
        //TODO:fetch username and password in cache
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1
    }
});

export default connect(
    (state) => ({
        auth: state.user.auth
    })
)(App);

