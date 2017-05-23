import _ from 'lodash'
import Proxy from '../proxy/Proxy'
import Config from '../../config';
import {
    SWITCH_TAB
} from '../constants/NavigationConstants';



let _onNewsFetch=(tab)=>{
    return {
        type:SWITCH_TAB,
        payload:{
            tab
        }
    }
}

//抽屉页的切换
export let switchTab=(tab)=>{
    return (dispatch, getState) => {
        dispatch(_onNewsFetch(tab))
    }
}