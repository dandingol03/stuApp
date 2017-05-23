
import {
    ON_GET_COURSE_ACHIEVEMENT
} from '../constants/CourseAchievementConstants';


const initialState = {
    
};

let achievement = (state = initialState, action) => {

    switch (action.type) {

        case ON_GET_COURSE_ACHIEVEMENT:
            var {data,ranks,max,min,average}=action.payload
            return Object.assign({}, state, {
               cultivate:data,
               ranks:ranks,
               maxes:max,
               mins:min,
               averages:average
            })
 
        default:
            return state;
    }
}

export default achievement;
