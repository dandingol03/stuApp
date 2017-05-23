package com.stuapp;

import android.graphics.Color;
import android.graphics.Typeface;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.x;



public class MyBarChartViewManager extends SimpleViewManager<BarChart> {
    @Override
    public String getName() {
        return "MPBarChart";
    }

    @Override
    protected BarChart createViewInstance(ThemedReactContext reactContext) {
        BarChart chart=new BarChart(reactContext);

        return chart;
    }

    @ReactProp(name="drawBarShadow",defaultBoolean = false)
    public void setDrawBarShadow(BarChart mChart, boolean enable){
        mChart.setDrawBarShadow(enable);
    }

    @ReactProp(name="drawValueAboveBar",defaultBoolean = true)
    public void setDrawValueAboveBar(BarChart mChart, boolean enable){
        mChart.setDrawValueAboveBar(enable);
    }


    @ReactProp(name="description",defaultBoolean = false)
    public void setDescriptionEnabled(BarChart mChart, boolean enable){
        if(enable)
        {
            mChart.getDescription().setEnabled(true);
        }else{
            mChart.getDescription().setEnabled(false);
        }
    }

    @ReactProp(name="dragEnabled",defaultBoolean = true)
    public void setDragEnabled(BarChart mChart, boolean enable){
        mChart.setDragEnabled(enable);
    }

    @ReactProp(name="maxVisibleValueCount",defaultInt = 100)
    public void setMaxVisibleValueCount(BarChart mChart, int v){
        mChart.setMaxVisibleValueCount(v);
    }

    @ReactProp(name="pinchZoom",defaultBoolean = false)
    public void setPinchZoom(BarChart mChart, boolean enabled){
        mChart.setPinchZoom(enabled);
    }

    @ReactProp(name="drawGridBackground",defaultBoolean = false)
    public void setDrawGridBackground(BarChart mChart, boolean enabled){
        mChart.setDrawGridBackground(enabled);
    }

    @ReactProp(name="xAxis")
    public  void  setXAxis(BarChart chart,ReadableMap v){
        XAxis x= chart.getXAxis();
        setAxisInfo(x, v);
        setXAxisInfo(chart,x, v);
    }

    @ReactProp(name="yAxis")
    public  void  setYAxis(BarChart chart,ReadableMap v){
        YAxis y= chart.getAxisLeft();
        setAxisInfo(y, v);
        setYAxisInfo((YAxis) y, v);

    }


    private void setAxisInfo(AxisBase axis, ReadableMap v){
        if(v.hasKey("enable")) axis.setEnabled(v.getBoolean("enable"));
        if(v.hasKey("drawAxisLine")) axis.setDrawAxisLine(v.getBoolean("drawAxisLine"));

        if(v.hasKey("drawGridLines")) axis.setDrawGridLines(v.getBoolean("drawGridLines"));
        if(v.hasKey("drawLabels")) axis.setDrawLabels(v.getBoolean("drawLabels"));

        if(v.hasKey("textColor")) axis.setTextColor(Color.parseColor(v.getString("textColor")));
        if(v.hasKey("textSize")) axis.setTextSize((float)v.getDouble("textSize"));
        if(v.hasKey("gridColor")) axis.setGridColor(Color.parseColor(v.getString("gridColor")));

        if(v.hasKey("gridLineWidth")) axis.setGridLineWidth((float)v.getDouble("gridLineWidth"));
        if(v.hasKey("axisLineColor")) axis.setAxisLineColor(Color.parseColor(v.getString("axisLineColor")));
        if(v.hasKey("axisLineWidth")) axis.setAxisLineWidth((float)(v.getDouble("axisLineWidth")));
        if(v.hasKey("gridDashedLine")) {
            ReadableMap gdl=v.getMap("gridDashedLine");
            axis.enableGridDashedLine((float)gdl.getDouble("lineLength"),
                    (float)gdl.getDouble("spaceLength"),
                    (float)gdl.getDouble("phase"));
        }
        if (v.hasKey("xOffset")) {
            axis.setXOffset((float)(v.getDouble("xOffset")));
        }
        if (v.hasKey("yOffset")) {
            axis.setYOffset((float)(v.getDouble("yOffset")));
        }
        if(v.hasKey("typeface"))
        {
            switch (v.getString("typeface").toLowerCase())
            {
                case "bold":
                    axis.setTypeface(Typeface.DEFAULT_BOLD);
                    break;
                case "sans-serif":
                    axis.setTypeface(Typeface.SANS_SERIF);
                    break;
                case "serif":
                    axis.setTypeface(Typeface.SERIF);
                    break;
                case "monospace":
                    axis.setTypeface(Typeface.MONOSPACE);
                    break;
            }

        }
    }

    //x轴的特有信息
    private void setXAxisInfo(BarChart mChart,XAxis axis,ReadableMap v){

        if(v.hasKey("labelRotationAngle")) axis.setLabelRotationAngle((float) v.getDouble("labelRotationAngle"));
        if(v.hasKey("avoidFirstLastClipping")) axis.setAvoidFirstLastClipping(v.getBoolean("avoidFirstLastClipping"));
        if(v.hasKey("position")) {
            String name=v.getString("position");
            axis.setPosition(XAxis.XAxisPosition.valueOf(name));
        }
        if(v.hasKey("granularity"))
        {
            axis.setGranularity((float)v.getDouble("granularity"));
        }
        if(v.hasKey("labelCount"))
        {
            axis.setLabelCount(v.getInt("labelCount"),false);
        }
        //设置x轴的value formatter
        if(v.hasKey("labelList"))
        {
            ReadableArray labelArr= v.getArray("labelList");
            ArrayList<String >labels=new ArrayList<>();
            for(int i=0;i<labelArr.size();i++)
            {
                labels.add(labelArr.getString(i));
            }
            axis.setValueFormatter(new CourseAxisValueFormatter(mChart,null,labels) );
        }


    }

    //y轴的特有信息
    private  void setYAxisInfo(YAxis axis,ReadableMap v){

        if(v.hasKey("axisMaximum"))
            axis.setAxisMaximum((float)v.getDouble("axisMaximum"));
        if(v.hasKey("axisMinimum"))
        {
            axis.setAxisMinimum((float)v.getDouble("axisMinimum"));
        }

        if(v.hasKey("inverted")) axis.setInverted(v.getBoolean("inverted"));

        if(v.hasKey("spaceTop")) axis.setSpaceTop((float) (v.getDouble("spaceTop")));
        if(v.hasKey("spaceBottom")) axis.setSpaceBottom((float) (v.getDouble("spaceBottom")));


        if(v.hasKey("labelCount")) {
            boolean labelCountForce = false;
            if (v.hasKey("labelCountForce")) {
                labelCountForce = v.getBoolean("labelCountForce");
            }
            axis.setLabelCount(v.getInt("labelCount"), labelCountForce);
        }

        if(v.hasKey("position")) {
            String name=v.getString("position");
            axis.setPosition(YAxis.YAxisLabelPosition.valueOf(name));
        }

        if(v.hasKey("valueFormatter"))
        {
            String mode=v.getString("valueFormatter");
            switch (mode)
            {
                case "INTEGER":
                    IAxisValueFormatter custom = new MyAxisValueFormatter();
                    axis.setValueFormatter(custom);
                    break;
            }
        }

    }


    //设置图例
    @ReactProp(name="legend")
    public void setLegend(BarChart mChart,ReadableMap v){
        Legend legend=mChart.getLegend();
        if(v.hasKey("enable")) legend.setEnabled(v.getBoolean("enable"));
        if(v.hasKey("position"))  legend.setPosition(Legend.LegendPosition.valueOf(v.getString("position")));
        if(v.hasKey("direction"))  legend.setDirection(Legend.LegendDirection.valueOf(v.getString("direction")));

        if(v.hasKey("legendForm"))
            legend.setForm(Legend.LegendForm.valueOf(v.getString("legendForm")));
        if(v.hasKey("wordWrap"))
            legend.setWordWrapEnabled(v.getBoolean("wordWrap"));

        if(v.hasKey("textColor"))  legend.setTextColor(Color.parseColor(v.getString("textColor")));
        if(v.hasKey("textSize"))
            legend.setTextSize((float) v.getDouble("textSize"));
        if(v.hasKey("formSize"))
            legend.setFormSize((float)v.getDouble("formSize"));
        if(v.hasKey("xOffset"))  legend.setXOffset((float) v.getDouble("xOffset"));
        if(v.hasKey("yOffset"))  legend.setYOffset((float) v.getDouble("yOffset"));
        if(v.hasKey("xEntrySpace"))
            legend.setXEntrySpace((float) v.getDouble("xEntrySpace"));
        if(v.hasKey("yEntrySpace"))  legend.setYEntrySpace((float) v.getDouble("yEntrySpace"));

        if(v.hasKey("verticalAlignment"))
        {
            switch (v.getString("verticalAlignment"))
            {
                case "TOP":
                    legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
                    break;
                case "CENTER":
                    legend.setVerticalAlignment(Legend.LegendVerticalAlignment.CENTER);
                    break;
                case "BOTTOM":
                    legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
                    break;
            }
        }

        if(v.hasKey("horizontalAlignment"))
        {
            switch (v.getString("horizontalAlignment"))
            {
                case "LEFT":
                    legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
                    break;
                case "CENTER":
                    legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
                    break;
                case "RIGHT":
                    legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
                    break;
            }
        }

        if(v.hasKey("orientation"))
        {
            switch (v.getString("orientation"))
            {
                case "HORIZONTAL":
                    legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
                    break;
                case "VERTICAL":
                    legend.setOrientation(Legend.LegendOrientation.VERTICAL);
                    break;
            }
        }

        if(v.hasKey("drawInside"))
        {
            legend.setDrawInside(v.getBoolean("drawInside"));
        }



        if(v.hasKey("custom")){
            ReadableMap custom=v.getMap("custom");
            ReadableArray colors=custom.getArray("colors");
            ReadableArray labels=custom.getArray("labels");
            if(colors.size()==labels.size()) {
                int[] cols = new int[colors.size()];
                String[] labs = new String[colors.size()];
                List<LegendEntry> entries=new ArrayList<>();
                for (int j = 0; j < colors.size(); j++) {
                    LegendEntry entry=new LegendEntry();
                    entry.label= labels.getString(j);
                    entry.formColor=Color.parseColor(colors.getString(j));
                    entries.add(entry);
                }
                legend.setCustom(entries);
            }
        }

    }

    //注入数据

    @ReactProp(name="data")
    public void setData(BarChart mChart,ReadableMap rm){

        ReadableArray xArray=rm.getArray("xValues");
        ArrayList<String> xVals=new ArrayList<String>();
        for(int m=0;m<xArray.size();m++) {
            xVals.add(xArray.getString(m));
        }
        mChart.getXAxis().setValueFormatter(new CourseAxisValueFormatter(mChart,null,xVals) );



        ReadableArray ra=rm.getArray("yValues");
        int count=ra.size();


        float start = 1f;

        List<Integer> colors = new ArrayList<>();
        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        for (int i = (int) start; i < start + count ; i++) {
            ReadableMap map=ra.getMap(i-1);
            //配置项
            ReadableMap config= map.getMap("config");
            //=>颜色
            if(config.hasKey("color")) {
                int color=Color.parseColor(config.getString("color"));
                colors.add(color);
            }
            //数据项
            float yVal=(float)map.getDouble("data");
            yVals1.add(new BarEntry(i, yVal));

        }
        BarDataSet set1;
        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) mChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            set1.setColors(colors);//设置柱形图颜色
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "The year 2017");
            //set1.setColors(Constants.COLORS);//设置柱形图颜色
            set1.setDrawIcons(false);


            //set1.setColors(ColorTemplate.LIBERTY_COLORS);
            set1.setColors(colors);

            //set1.setColors(colors);
            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setValueTypeface(Typeface.DEFAULT_BOLD);
            //TODO:fix this
//            data.setValueFormatter(new DistributionValueFormatter());
            data.setBarWidth(0.9f);

            mChart.setData(data);
            mChart.invalidate();
        }


    }






}
