package com.stuapp.acm.netease.dungeon;

public class Point {
     int x;
     int y;
     int step;
    boolean visited=false;
     boolean reachable=false;

    public Point()
    {}

    public Point(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step=step;
    }
}
