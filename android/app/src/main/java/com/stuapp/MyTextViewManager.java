package com.stuapp;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;


public class MyTextViewManager extends SimpleViewManager<TextView> {
    @Override
    public String getName() {
        return "MyTextView";
    }

    @Override
    protected TextView createViewInstance(ThemedReactContext reactContext) {
        TextView textView=new TextView(reactContext);
        return textView;
    }



    @ReactProp(name="text")
    public void setText(TextView view,String text){
        view.setText(text);
    }



}
