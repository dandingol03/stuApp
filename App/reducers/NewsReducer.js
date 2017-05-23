
import {
    ON_NEWS_FETCH
} from '../constants/NewsConstants';


const initialState = {
    news:[]
};

let news = (state = initialState, action) => {

    switch (action.type) {

        case ON_NEWS_FETCH:
            var {news}=action.payload
            return Object.assign({}, state, {
               news:news
            })
 
        default:
            return state;
    }
}

export default news;
