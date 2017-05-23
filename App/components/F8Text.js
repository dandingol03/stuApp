/**
 * Created by danding on 17/5/20.
 */
import React, { Component } from 'react';
import {
    StyleSheet,
    Text,
    View,
    Dimensions
} from 'react-native';

const scale = Dimensions.get('window').width / 375;


export function Text({style, ...props}: Object): ReactElement {
    return <ReactNative.Text style={[styles.font, style]} {...props} />;
}

export function Heading1({style, ...props}: Object): ReactElement {
    return <ReactNative.Text style={[styles.font, styles.h1, style]} {...props} />;
}

export function Paragraph({style, ...props}: Object): ReactElement {
    return <ReactNative.Text style={[styles.font, styles.p, style]} {...props} />;
}


const styles = StyleSheet.create({

    h1: {
        fontSize: normalize(24),
        lineHeight: normalize(27),
        color: '#032250',
        fontWeight: 'bold',
        letterSpacing: -1,
    },
    p: {
        fontSize: normalize(15),
        lineHeight: normalize(23),
        color: '#7F91A7',
    },
});
