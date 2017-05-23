
import {
    SWITCH_TAB
} from '../constants/NavigationConstants';


const initialState = {
    tab:'home'
};

let nav = (state = initialState, action) => {

    switch (action.type) {

        case SWITCH_TAB:
            var {tab}=action.payload
            return Object.assign({}, state, {
               tab:tab
            })
 
        default:
            return state;
    }
}

export default nav;
