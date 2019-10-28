package com.bandweaver.maxtunnelbase.utils;

public class RandomUtil {
    public static double getValue(double start, double end){
        return start + Math.random() * (end - start);
    }
}
