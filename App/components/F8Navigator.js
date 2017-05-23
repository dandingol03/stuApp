/**
 * Created by danding on 17/5/20.
 */
import React, { Component } from 'react';
import {
    StyleSheet,
    Text,
    View,
    BackAndroid,
    Platform
} from 'react-native';

import {
    Navigator
} from 'react-native-deprecated-custom-components'

import F8TabsView from './F8TabsView'

 class F8Navigator extends Component {
    render() {


        return (
            <Navigator
                ref="navigator"
                style={styles.container}
                configureScene={(route) => {
                  if (Platform.OS === 'android') {
                    return Navigator.SceneConfigs.FloatFromBottomAndroid;
                  }
                  // TODO: Proper scene support
                  if (route.shareSettings || route.friend) {
                    return Navigator.SceneConfigs.FloatFromRight;
                  } else {
                    return Navigator.SceneConfigs.FloatFromBottom;
                  }
                }}
                initialRoute={{}}
                renderScene={this.renderScene}
            />
        );
    }

    renderScene(route, navigator)
    {
        return <F8TabsView navigator={navigator} day={1}/>;
    }

}


const styles = StyleSheet.create({
    container: {
        flex: 1,
        marginTop:23
    }
});


module.exports=F8Navigator
