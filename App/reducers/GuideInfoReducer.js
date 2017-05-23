
import {
    ON_GUIDE_INFO_FETCH
} from '../constants/GuideInfoConstants';


const initialState = {
    infos:[]
};

let guideInfo = (state = initialState, action) => {

    switch (action.type) {

        case ON_GUIDE_INFO_FETCH:
            var {infos}=action.payload
            return Object.assign({}, state, {
               infos:infos
            })
 
        default:
            return state;
    }
}

export default guideInfo;
