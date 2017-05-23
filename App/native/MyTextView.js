import React,{PropTypes,Component} from 'react';
import {
    requireNativeComponent,
    View
} from 'react-native';


var TextView = requireNativeComponent('MyTextView', MyTextView,{
    
});

class MyTextView extends Component {
  render() {
    // onChange事件是JS已经定义好的，对应原生的topChange事件
    return <TextView {...this.props}/>;
  }
}

MyTextView.propTypes={
      text:PropTypes.string,
      ...View.propTypes
}



module.exports = MyTextView;
