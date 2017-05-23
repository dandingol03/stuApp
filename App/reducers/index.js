
import { combineReducers } from 'redux';

import user from './UserReducer';
import news from './NewsReducer';
import guideInfo from './GuideInfoReducer';
import nav from './NavigationReducer';
import achievement from './CourseAchievementReducer';

export default rootReducer = combineReducers({
    user,
    news,
    guideInfo,
    nav,
    achievement
})
