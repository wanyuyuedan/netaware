package com.unicom.utils;

/**
 * 计算
 * shenjianghao
 */
public class Location {
    private static   double big_x = 116.614759;
    private static   double big_y = 39.971582;
    private static   double small_x = 116.246358;
    private static   double small_y = 39.844787;
    private static  int total_width ;
    private static  int total_high ;
    private static  int width ;
    private static  int high;

    public  static String getArea(double x, double y){
        total_width = (int)((big_x - small_x) * 10000);
        total_high = (int)((big_y - small_y) * 10000);
        width = total_width / 5;
        high = total_high / 4;
        int x1 = (int)(x * 10000);
        int y1 = (int)(y * 10000);
        int x2 = (int)(small_x * 10000);
        int y2 = (int)(small_y * 10000);
        if((x1-x2)>0 && (y1 -y2)>0){
            if((x1-x2) < width && (y1-y2) < high) {
                //	System.out.println("a1");
                return "A"+1;
            }
            if(((x1-x2) % width) >0 && ((y1-y2) % high) > 0) {
                //System.out.println("a"+(((x1-x2) / width) *((y1-y2) / high) +1));
                return "A"+(((x1-x2) / width) *((y1-y2) / high) +1);
            }

        }
        return "";
    }
}
