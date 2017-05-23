
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
    Easing,
    TouchableHighlight
} from 'react-native';
import { connect } from 'react-redux';
import Ionicons from 'react-native-vector-icons/Ionicons';
import Icon from 'react-native-vector-icons/FontAwesome';
import DateFilter from '../utils/DateFilter';
import {
    acquirePlanCourseScores,
    onGetCourseAchievement
} from '../action/UserActions';



import {
    COLOE_TEMPLATE
} from '../constants/ChartConstants';

import MyTextView from '../native/MyTextView';
import BarChart from '../native/BarChart';

class CourseAchievement extends Component {

    constructor(props) {
        super(props);
        this.state = {
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

    renderRow(rowData, sectionId, rowId) {

        var lineStyle = {
            flex: 1, flexDirection: 'row', padding: 2, paddingLeft: 0, paddingRight: 0,
            justifyContent: 'flex-start', backgroundColor: 'transparent'
        };

        var row = (
            <TouchableOpacity style={lineStyle} onPress={() => {

            }}>
                <View style={{ width: 80, flexDirection: 'row', justifyContent: 'flex-start', alignItems: 'center', padding: 6, paddingTop: 10, }}>
                    <Text style={{ fontSize: 16, color: '#222',fontWeight: 'bold', }}>
                        {rowData.courseNum}
                    </Text>

                </View>
                <View style={{flex: 1, flexDirection: 'row', justifyContent: 'flex-start', alignItems:'center',padding: 2, paddingLeft: 0}}>
                    
                    <Text style={{ fontSize: 15, padding: 2, fontWeight: 'bold', color: '#222'  }}>
                        {rowData.courseName}
                    </Text>
                    
                </View>

                 <View style={{ width: 50, flexDirection: 'row', justifyContent: 'center', alignItems: 'center', padding: 6, paddingTop: 10, }}>
                    <Text style={{ fontSize: 15, justifyContent: 'flex-start', fontWeight: 'bold', alignItems: 'flex-start', color: '#222' }}>
                        {rowData.credit}
                    </Text>

                </View>

                 <View style={{ width: 50, flexDirection: 'row', justifyContent: 'center', alignItems: 'center', padding: 6, paddingTop: 10, }}>
                    <Text style={{ fontSize: 15, justifyContent: 'flex-start', fontWeight: 'bold', alignItems: 'flex-start', color: '#222' }}>
                        {rowData.endScore}
                    </Text>

                </View>


            </TouchableOpacity>
        );

        return row;
    }

    //获取测试数据
    getData()
    {
        var data={
			xValues:['63','54','80'],
			yValues:[
				{
					data:92,
					config:{
						color:'blue'
					}
				},
				{
					data:89,	
					config:{
						color:'red'
					}
				},
				{
					data:92,
					config:{
						color:'yellow'
					}
				}
			]
		};	
		return data;
    }

    getBarData(argument)
    {

        var {cultivate,mins}=this.props.achievement
        var xValues=[]
        var yValues=[]
        cultivate.map((achievement,i)=>{
            yValues.push({
                data:[achievement.endScore],
                label:achievement.courseName,
                config:{
                    color:COLOE_TEMPLATE[i]
                }
            })
            xValues.push(mins[i]+'')
        })


        var data={
        xValues:xValues,
        yValues:yValues
        };  
        return data;
    }

    render() {


        var cultivateList=null
        var {cultivate}=this.props.achievement
        if(cultivate&&cultivate.length>0)
        {
            var ds = new ListView.DataSource({ rowHasChanged: (r1, r2) => r1 !== r2 });
            cultivateList = (
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
                        dataSource={ds.cloneWithRows(cultivate)}
                        renderRow={this.renderRow.bind(this)}
                    />
                </ScrollView>)
        }



        return (
            <View style={styles.container}>
                <Ionicons.ToolbarAndroid
                    navIconName="md-list"
                    onIconClicked={() => {
                        if (this.props.openDrawer)
                            this.props.openDrawer()
                    }}
                    iconColor="#222"
                    style={styles.toolbar}
                    titleColor="#222"
                    title={'成绩'} />

                <View style={{ padding: 6,paddingTop:4}}>
                    <View style={{ backgroundColor: '#fff', borderRadius: 4 }}>


                        <View style={{ flexDirection: 'row', justifyContent: 'flex-start', padding: 6 }}>
                            <Text style={{ color: '#DB3937', fontSize: 14 }}>科目统计</Text>
                        </View>

                        <View style={{ flexDirection: 'row', alignItems: 'center', padding: 6 }}>
                            <View style={{ width:80,flexDirection:'row',justifyContent:'center'}}>
                                <Text style={{fontSize:15}}>编号</Text>
                            </View>

                            <View style={{ flex: 1 ,flexDirection:'row',justifyContent:'center'}}>
                                <Text style={{fontSize:15}}>课程名</Text>
                            </View>

                            <View style={{ width:50,flexDirection:'row',justifyContent:'center',paddingLeft:10}}>
                                <Text style={{color:'#72b8b9',fontSize:16}}>学分</Text>
                            </View>

                            <View style={{ width:50,flexDirection:'row',justifyContent:'center',paddingLeft:10}}>
                                <Text style={{color:'#72b8b9',fontSize:16}}>成绩</Text>
                            </View>
                        </View>

                        <Animated.View style={{ opacity: this.state.fadeAnim }}>
                            {cultivateList}
                        </Animated.View>
                    </View>

                </View>

            {/*图表*/}
            {
               
                 <View style={{flex:1,backgroundColor:'#fff',marginBottom:5}}>
                    	<BarChart style={{flex:1}} data={this.getData()}/>
                </View>
            }
            

            </View>
        );
    }

    componentDidMount() {
        this.props.dispatch(acquirePlanCourseScores()).then((json) => {
            if (json.re == 1) {
                var { data, ranks, max, min, average } = json

                this.props.dispatch(onGetCourseAchievement({
                    data: data,
                    ranks: ranks,
                    max: max,
                    min: min,
                    average: average
                }))
            }
        })
    }

}


const styles = StyleSheet.create({

    container: {
        flex: 1,
        backgroundColor: '#ddd'

    },
    toolbar: {
        backgroundColor: '#fff',
        height: 56,

    },
    title: {
        fontSize: 38,
        backgroundColor: 'transparent'
    },
    myTextView:{
        width:300,
        height:100,
    },

});

const mapStateToProps = (state, ownProps) => {

    const props = {
        achievement: state.achievement,
    }

    return props
}

export default connect(mapStateToProps)(CourseAchievement);
