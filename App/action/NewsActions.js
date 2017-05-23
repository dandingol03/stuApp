import _ from 'lodash'
import Proxy from '../proxy/Proxy'
import Config from '../../config';
import {
    ON_NEWS_FETCH
} from '../constants/NewsConstants';

//拉取新闻
export let fetchNews = () => {
    return (dispatch, getState) => {
        return new Promise((resolve, reject) => {
            var state = getState();
            var accessToken = state.user.accessToken;
            Proxy.postes({
                url: Config.server + '/gradms/getNews',
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

let _onNewsFetch=(news)=>{
    return {
        type:ON_NEWS_FETCH,
        payload:{
            news
        }
    }
}

//收到新闻内容
export let onNewsFetch=(news)=>{
    return (dispatch, getState) => {
        dispatch(_onNewsFetch(news))
    }
}