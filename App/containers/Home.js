
import React, { Component } from 'react';
import {
    StyleSheet,
    Text,
    View,
    Image,
    ListView,
    ScrollView,
    TouchableOpacity,
    RefreshControl,
    Animated,
    Easing
} from 'react-native';
import { connect } from 'react-redux';
import Ionicons from 'react-native-vector-icons/Ionicons';
import Icon from 'react-native-vector-icons/FontAwesome';
import ScrollableTabView, { DefaultTabBar, } from 'react-native-scrollable-tab-view';
import DateFilter from '../utils/DateFilter';
import {
    fetchNews,
    onNewsFetch
} from '../action/NewsActions';
import {
    fetchGuideInfo,
    onGuideInfoFetch
} from '../action/GuideInfoActions';



class Home extends Component {

    constructor(props) {
        super(props);
        this.state = {
            doingFetch: false,
            isRefreshing: false,
            fadeAnim: new Animated.Value(1)
        }
    }



    _onRefresh() {
        this.setState({ isRefreshing: true, fadeAnim: new Animated.Value(0) });
        setTimeout(function () {
            this.setState({
                isRefreshing: false,
            });
            Animated.timing(          // Uses easing functions
                this.state.fadeAnim,    // The value to drive
                {
                    toValue: 1,
                    duration: 600,
                    easing: Easing.bounce
                },           // Configuration
            ).start();
        }.bind(this), 2000);
    }


    renderGuideInfo(rowData, sectionId, rowId) {

        var lineStyle = {
            flex: 1, flexDirection: 'row', padding: 4, paddingLeft: 0, paddingRight: 0,
            justifyContent: 'flex-start', backgroundColor: 'transparent', borderBottomColor: '#ddd', borderBottomWidth: 1
        };

        var row = (
            <TouchableOpacity style={lineStyle} onPress={() => {

            }}>
                <View style={{ width: 40, flexDirection: 'row', justifyContent: 'center', alignItems: 'center', padding: 6, }}>
                    <Text style={{ fontSize: 15, justifyContent: 'flex-start', alignItems: 'flex-start', color: '#222' }}>
                        {rowData.guideNum}
                    </Text>

                </View>
                <View style={{
                    flex: 1, flexDirection: 'row', justifyContent: 'flex-start',alignItems:'center', padding: 6, paddingLeft: 20
                }}>
                    <View>
                        <Text style={{ color: '#fab381', fontSize: 16, padding: 2, }}>
                            {rowData.guideName}
                        </Text>
                    </View>
                </View>


            </TouchableOpacity>
        );

        return row;
    }

    renderNews(rowData, sectionId, rowId) {

        var lineStyle = {
            flex: 1, flexDirection: 'row', padding: 2, paddingLeft: 0, paddingRight: 0,
            justifyContent: 'flex-start', backgroundColor: 'transparent'
        };

        var row = (
            <TouchableOpacity style={lineStyle} onPress={() => {

            }}>
                <View style={{ width: 40, flexDirection: 'row', justifyContent: 'center', alignItems: 'center', padding: 6, paddingTop: 10, }}>
                    <Text style={{ fontSize: 15, justifyContent: 'flex-start', fontWeight: 'bold', alignItems: 'flex-start', color: '#222' }}>
                        {rowData.id}
                    </Text>

                </View>
                <View style={{
                    flex: 1, flexDirection: 'column', alignItems: 'flex-start', padding: 2, paddingLeft: 0,
                    borderBottomColor: '#aaa', borderBottomWidth: 1
                }}>
                    <View>
                        <Text style={{ color: '#fab381', fontSize: 15, padding: 2, fontWeight: 'bold' }}>
                            {rowData.title}
                        </Text>
                    </View>
                    <View>
                        <Text style={{ color: '#666', fontSize: 14, padding: 2 }}>
                            {DateFilter.filter(rowData.editTime, 'yyyy-mm-dd')}
                        </Text>
                    </View>
                </View>


            </TouchableOpacity>
        );

        return row;
    }


    render() {

        var newsList = null
        var { news } = this.props;
        if (news && news.length > 0) {
            var ds = new ListView.DataSource({ rowHasChanged: (r1, r2) => r1 !== r2 });
            newsList = (
                <ScrollView

                    refreshControl={
                        <RefreshControl
                            refreshing={this.state.isRefreshing}
                            onRefresh={this._onRefresh.bind(this)}
                            tintColor="#ff0000"
                            title="Loading..."
                            titleColor="#00ff00"
                            colors={['#ff0000', '#00ff00', '#0000ff']}
                            progressBackgroundColor="#ffff00"
                        />
                    }
                >
                    <ListView
                        automaticallyAdjustContentInsets={false}
                        dataSource={ds.cloneWithRows(news)}
                        renderRow={this.renderNews.bind(this)}
                    />
                </ScrollView>)
        }

        var infosList = null
        var { infos } = this.props
        if (infos && infos.length > 0) {
            var ds = new ListView.DataSource({ rowHasChanged: (r1, r2) => r1 !== r2 });
            infosList = (
                <ScrollView

                    refreshControl={
                        <RefreshControl
                            refreshing={this.state.isRefreshing}
                            onRefresh={this._onRefresh.bind(this)}
                            tintColor="#ff0000"
                            title="Loading..."
                            titleColor="#00ff00"
                            colors={['#ff0000', '#00ff00', '#0000ff']}
                            progressBackgroundColor="#ffff00"
                        />
                    }
                >
                    <ListView
                        automaticallyAdjustContentInsets={false}
                        dataSource={ds.cloneWithRows(infos)}
                        renderRow={this.renderGuideInfo.bind(this)}
                    />
                </ScrollView>)
        }



        return (
            <View style={styles.container}>

                <Ionicons.ToolbarAndroid
                    actions={[
                        { title: 'Edit', iconName: 'ios-create-outline', show: 'never' },
                        { title: 'Settings', iconName: 'md-alarm', show: 'ifRoom' }
                    ]}
                    navIconName="md-list"
                    onIconClicked={() => {
                        if(this.props.openDrawer)
                            this.props.openDrawer()
                    }}
                    iconColor="#222"
                    style={styles.toolbar}
                    titleColor="#222"
                    title={'山东大学研究生App'} />

                <ScrollableTabView
                    tabBarUnderlineStyle={{ backgroundColor: '#066' }}
                    tabBarActiveTextColor="#066"
                    style={{ backgroundColor: '#eee', borderWidth: 0 }}
                    renderTabBar={() => <DefaultTabBar />}
                >
                    <View tabLabel='通知'>
                        <Animated.View style={{ opacity: this.state.fadeAnim }}>
                            {infosList}
                        </Animated.View>

                    </View>
                    <View tabLabel='新闻'>
                        <Animated.View style={{ opacity: this.state.fadeAnim }}>
                            {newsList}
                        </Animated.View>

                    </View>
                    <Text tabLabel='Sites'>project</Text>
                </ScrollableTabView>


            </View>
        )
    }


    componentDidMount() {
        //TODO:fetch data
        
        this.props.dispatch(fetchNews()).then((json) => {
            if (json.re == 1) {
                this.props.dispatch(onNewsFetch(json.data))
            }

            return this.props.dispatch(fetchGuideInfo());
        }).then((json) => {
            if (json.re == 1) {
                this.props.dispatch(onGuideInfoFetch(json.data))
            }
            
        })
    }

}


const styles = StyleSheet.create({

    container: {
        flex: 1,

    },
    toolbar: {
        backgroundColor: '#eee',
        height: 56,
    },

});


const mapStateToProps = (state, ownProps) => {

    const props = {
        news: state.news.news,
        infos: state.guideInfo.infos
    }

    return props
}

export default connect(mapStateToProps)(Home);
