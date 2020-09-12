package com.offer.a笔试.奇安信;


public class Main {
    public static void main(String[] args) {
        int max = getMaxArea(0,0,2,2,0, 0, 1,1);
        //System.out.println(max);
    }

    /**
     * 获得剩余区域内的最大干净矩形面积
     * @param x1 int整型
     * @param y1 int整型
     * @param x2 int整型
     * @param y2 int整型
     * @param x3 int整型
     * @param y3 int整型
     * @param x4 int整型
     * @param y4 int整型
     * @return int整型
     */
    public static int getMaxArea (int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // write code here
        //上层
        int TopY = Math.min(y1, y3);
        int areaTop = TopY * 10;
        System.out.println(areaTop);
        //下层
        int BottomY = Math.max(y2, y4);
        int areaBottom = (10 - BottomY) * 10;
        areaBottom = Math.max(areaTop, areaBottom);
        System.out.println(areaBottom);
        //左边
        int LeftX = Math.min(x1, x3);
        int areaLeft = LeftX * 10;
        areaLeft = Math.max(areaBottom, areaLeft);
        System.out.println("left" + areaLeft);
        //右边
        int RightX = Math.max(x2, x4);
        int areaRight = (10 - RightX) * 10;
        areaRight = Math.max(areaLeft, areaRight);
        System.out.println(areaRight);
        //左上(可能重叠)
        int LeftTopX = Math.max(x1, x3);
        int LeftTopY = Math.max(y1, y3);
        int areaLeftTop = LeftTopX * LeftTopY;
        areaLeftTop = Math.max(areaLeftTop, areaRight);
        System.out.println("areaLeftTop" + areaLeftTop);
        //右下
        int RightBoX = Math.min(x2, x4);
        int RightBoY = Math.min(y2, y4);
        int areaRightBo = (10 - RightBoX) * (10 - RightBoY);
        areaRightBo = Math.max(areaLeftTop, areaRightBo);

        //右上
        int RightTopX = 0;
        int RightTopY = 0;
        int areaRightTop = 0;
        //左下
        int LeftBoX = 0;
        int LeftBoY = 0;
        int areaLeftBo = 0;


        if(x1 < x3){
            RightTopX = x2;
            RightTopY = y3;
            areaRightTop = (10 - RightTopX) * RightTopY;
            areaRightTop = Math.max(areaRightTop, areaRightBo);

            //
            LeftBoX = x3;
            LeftBoY = y2;
            areaLeftBo = LeftBoX * (10 - LeftBoY);
            areaLeftBo = Math.max(areaRightTop, areaLeftBo);
        }else{
            RightTopX = x4;
            RightTopY = y1;
            areaRightTop = (10 - RightTopX) * RightTopY;
            areaRightTop = Math.max(areaRightTop, areaRightBo);

            //
            LeftBoX = x1;
            LeftBoY = y4;
            areaLeftBo = LeftBoX * (10 - LeftBoY);
            areaLeftBo = Math.max(areaRightTop, areaLeftBo);
        }

        return areaLeftBo;
    }
}

