import _ from 'lodash'
import Proxy from '../proxy/Proxy'
import Config from '../../config';
import {
    ON_GUIDE_INFO_FETCH
} from '../constants/GuideInfoConstants';

//拉取新闻
export let fetchGuideInfo = () => {
    return (dispatch, getState) => {
        return new Promise((resolve, reject) => {
            var state = getState();
            var accessToken = state.user.accessToken;
            Proxy.postes({
                url: Config.server + '/gradms/getGuideInfo',
                headers: {
                    'Authorization': "Bearer " + accessToken,
                    'Content-Type': 'application/json'
                },
                body: {
                    request: 'getNews',
                }
            }).then((json)=>{
                resolve(json)
            }).catch((e)=>{
                reject(e)
            })


        })
    }
}

let _onGuideInfoFetch=(guideInfo)=>{
    return {
        type:ON_GUIDE_INFO_FETCH,
        payload:{
            infos:guideInfo
        }
    }
}

//收到新闻内容
export let onGuideInfoFetch=(guideInfo)=>{
    return (dispatch, getState) => {
        dispatch(_onGuideInfoFetch(guideInfo))
    }
}