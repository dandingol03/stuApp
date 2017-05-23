import React, {Component, PropTypes} from 'react';
import {requireNativeComponent, View} from 'react-native';


class BarChart extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <MPBarChart {...this.props}/>
        );
    }
}

BarChart.propTypes = {
    ...View.propTypes,
    data:PropTypes.object,
    touchEnabled:PropTypes.bool,
    dragEnabled:PropTypes.bool,
    pinchZoom:PropTypes.bool,
    maxVisibleValueCount:PropTypes.number,
    description:PropTypes.string,
    drawGridBackground:PropTypes.bool,
    xAxis:PropTypes.object,
    yAxisLeft:PropTypes.object,
    yAxisRight:PropTypes.object,
    yAxis:PropTypes.object,
    legend:PropTypes.object,
    drawBarShadow:PropTypes.bool,
    drawValueAboveBar:PropTypes.bool,
}

var MPBarChart = requireNativeComponent('MPBarChart', BarChart);

module.exports=BarChart