/**
 * Created by danding on 17/5/20.
 */
import React, { Component } from 'react';
import {
    StyleSheet,
    Text,
    View,
    Image,
    TouchableOpacity
} from 'react-native';
import { connect } from 'react-redux';
import DrawerLayoutAndroid from '../../example/DrawerLayoutAndroid';
import Home from '../containers/Home';
import CourseAchievement from '../containers/CourseAchievement';
import Ionicons from 'react-native-vector-icons/Ionicons';
import Icon from 'react-native-vector-icons/FontAwesome';
import {
    switchTab
} from '../action/NavigationAction';

 class F8TabsView extends Component {


    constructor(props) {
        super(props);

        this.renderNavigationView = this.renderNavigationView.bind(this);
    }

    openDrawer() {
        this.refs.drawer.openDrawer();
    }

    onTabSelect(tab) {
        if (this.props.tab !== tab) {
            this.props.dispatch(switchTab(tab))

        }
        this.refs.drawer.closeDrawer();
    }

    renderContent() {
        switch (this.props.tab) {
            case 'home':
                return (
                    <Home openDrawer={this.openDrawer.bind(this)} navigator={this.props.navigator}/>
                );
            case 'courseAchievement':
                return (
                    <CourseAchievement openDrawer={this.openDrawer.bind(this)} navigator={this.props.navigator} />
                );


        }
        throw new Error(`Unknown tab ${this.props.tab}`);
    }


    renderNavigationView() {
        var scheduleIcon = this.props.day === 1
            ? require('../../img/schedule-icon-1.png')
            : require('../../img/schedule-icon-2.png');
        var scheduleIconSelected = this.props.day === 1
            ? require('../../img/schedule-icon-1-active.png')
            : require('../../img/schedule-icon-2-active.png');
        var accountItem, myF8Item, loginItem;




        if (this.props.user && this.props.user.isLoggedIn) {
            var name = this.props.user.name || '';
            accountItem = (
                <View>
                    <TouchableOpacity onPress={this.openProfileSettings}>
                        <ProfilePicture userID={this.props.user.id} size={80} />
                    </TouchableOpacity>
                    <Text style={styles.name}>
                        {name.toUpperCase()}
                    </Text>
                </View>
            );
            myF8Item = (
                <MenuItem
                    title="My F8"
                    selected={this.props.tab === 'my-schedule'}
                    onPress={this.onTabSelect.bind(this, 'my-schedule')}
                    icon={require('../../img/my-schedule-icon.png')}
                    selectedIcon={require('../../img/my-schedule-icon-active.png')}
                />
            );
        } else {
            accountItem = (
                <View>
                    <Image source={require('../../img/logo.png')} />
                    <Text style={styles.name}>
                        APRIL 12 + 13 / SAN FRANCISCO
                    </Text>
                </View>
            );
            loginItem = (
                <View style={styles.loginPrompt}>
                    <Text style={styles.loginText}>
                        Log in to find your friends at F8.
                    </Text>
                    {/*<LoginButton source="Drawer" />*/}
                </View>
            );
        }

        return (
            <View style={styles.drawer}>
                <Image
                    style={styles.header}
                    source={require('../../img/drawer-header.png')}>
                    {accountItem}
                </Image>
                <TouchableOpacity style={{ flexDirection: 'row', padding: 6, paddingHorizontal: 15, alignItems: 'center' }}
                    onPress={() => {
                        this.onTabSelect('home')
                    }}
                >
                    <Ionicons name='ios-home' size={35} color='#052351' />
                    <Text style={{ marginLeft: 20, fontSize: 18, color: '#052351' }}>主页</Text>
                </TouchableOpacity>

                <View style={{ height: 1, backgroundColor: '#ccc' }}></View>
                <View style={{ flexDirection: 'row', justifyContent: 'flex-start', padding: 8 }}>
                    <Text style={{ fontSize: 14 }}>个人信息</Text>
                </View>

                <TouchableOpacity style={{ flexDirection: 'row', padding: 6, paddingHorizontal: 15, alignItems: 'center' }}
                    onPress={() => {
                    }}
                >
                    <Icon name="user-circle-o" size={24} color='#666'></Icon>
                    <Text style={{ marginLeft: 26, fontSize: 17 }}>基本信息</Text>
                </TouchableOpacity>

                <TouchableOpacity style={{ flexDirection: 'row', padding: 6, paddingHorizontal: 15, alignItems: 'center' }}
                    onPress={() => {
                    }}
                >
                    <Icon name="group" size={24} color='#666'></Icon>
                    <Text style={{ marginLeft: 24, fontSize: 17 }}>培养信息</Text>
                </TouchableOpacity>


                <TouchableOpacity style={{ flexDirection: 'row', padding: 6, paddingHorizontal: 20, alignItems: 'center' }}
                    onPress={() => {
                    }}
                >
                    <Icon name="mobile" size={35} color='#666'></Icon>
                    <Text style={{ marginLeft: 30, fontSize: 17 }}>联系方式</Text>
                </TouchableOpacity>

                <View style={{ height: 1, backgroundColor: '#ccc' }}></View>
                <View style={{ flexDirection: 'row', justifyContent: 'flex-start', padding: 8 }}>
                    <Text style={{ fontSize: 14 }}>综合</Text>
                </View>

                <TouchableOpacity style={{ flexDirection: 'row', padding: 6, paddingHorizontal: 17, alignItems: 'center' }}
                    onPress={() => {
                        this.onTabSelect('home')
                    }}
                >
                    <Icon name="calendar-o" size={24} color='#666'></Icon>
                    <Text style={{ marginLeft: 24, fontSize: 18, }}>我的课表</Text>
                </TouchableOpacity>

                <TouchableOpacity style={{ flexDirection: 'row', padding: 6, paddingHorizontal: 17, alignItems: 'center' }}
                    onPress={() => {
                        this.onTabSelect('courseAchievement')
                    }}
                >
                    <Icon name="bar-chart" size={24} color='#666'></Icon>
                    <Text style={{ marginLeft: 20, fontSize: 18, }}>科目成绩</Text>
                </TouchableOpacity>




                {/*<MenuItem*/}
                {/*title="Schedule"*/}
                {/*selected={this.props.tab === 'schedule'}*/}
                {/*onPress={this.onTabSelect.bind(this, 'schedule')}*/}
                {/*icon={scheduleIcon}*/}
                {/*selectedIcon={scheduleIconSelected}*/}
                {/*/>*/}
                {myF8Item}
                {/*/!* <MenuItem*!/*/}
                {/*//     title="Maps"*/}
                {/*//     selected={this.props.tab === 'map'}*/}
                {/*//     onPress={this.onTabSelect.bind(this, 'map')}*/}
                {/*//     icon={require('../../img/maps-icon.png')}*/}
                {/*//     selectedIcon={require('../../img/maps-icon-active.png')}*/}
                {/*// />*/}
                {/*// <MenuItem*/}
                {/*//     title="Notifications"*/}
                {/*//     selected={this.props.tab === 'notifications'}*/}
                {/*//     onPress={this.onTabSelect.bind(this, 'notifications')}*/}
                {/*//     badge={this.props.notificationsBadge}*/}
                {/*//     icon={require('../../img/notifications-icon.png')}*/}
                {/*///!*selectedIcon={require('../../img/notifications-icon-active.png')}*!/*/}
                {/*/>*/}
                {/*<MenuItem*/}
                {/*title="Info"*/}
                {/*selected={this.props.tab === 'info'}*/}
                {/*onPress={this.onTabSelect.bind(this, 'info')}*/}
                {/*icon={require('../../img/info-icon.png')}*/}
                {/*selectedIcon={require('../../img/info-icon-active.png')}*/}
                {/*/>*/}
                {loginItem}
            </View>
        );
    }

    render() {
        return (
            <DrawerLayoutAndroid
                ref="drawer"
                drawerWidth={290}
                renderNavigationView={this.renderNavigationView}>
                {this.renderContent()}
            </DrawerLayoutAndroid>
        );
    }


}

const styles = StyleSheet.create({
    drawer: {
        flex: 1,
        backgroundColor: 'white',
    },
    content: {
        flex: 1
    },
    header: {
        padding: 20,
        justifyContent: 'flex-end',
        height: 180
    },
    name: {
        marginTop: 10,
        color: 'white',
        fontSize: 12,
    },
    loginPrompt: {
        flex: 1,
        justifyContent: 'flex-end',
        paddingBottom: 10,
    },
    loginText: {
        fontSize: 12,
        color: '#7F91A7',
        textAlign: 'center',
        marginBottom: 10,
    },
});

const mapStateToProps = (state, ownProps) => {

    const props = {
        tab: state.nav.tab,
    }
    return props
}

export default connect(mapStateToProps)(F8TabsView);