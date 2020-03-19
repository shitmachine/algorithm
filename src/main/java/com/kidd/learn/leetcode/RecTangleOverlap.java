package com.kidd.learn.leetcode;

import com.kidd.learn.Official;

/**
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 *
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 *
 * 给出两个矩形，判断它们是否重叠并返回结果。
 *
 * 示例 1：
 *
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false
 * 说明：
 *
 * 两个矩形 rec1 和 rec2 都以含有四个整数的列表的形式给出。
 * 矩形中的所有坐标都处于 -10^9 和 10^9 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rectangle-overlap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RecTangleOverlap {

    public static void main(String[] args) {
      /*  int[] rec1 = {0,0,2,2};
        int[] rec2 = {1,1,3,3};*/
     /*   int[] rec1 = {0,0,1,1};
        int[] rec2 = {1,0,2,1};*/
        int[] rec1 = {-257926405,-680763313,702840196,454409669};

        int[] rec2 = {-275916328,-417802221,22808107,675629469};
        System.out.println(rec1[2] - rec2[0]);
        System.out.println(rec2[2] - rec1[0]);
        System.out.println(rec1[3] - rec2[1]);
        System.out.println(rec2[3] - rec1[1]);
        System.out.format("the result is %b", cal1(rec1, rec2));
    }

    /**
     * 判定1
     * 最左侧的点和最右侧的点的x轴距离小于每个矩形两点之间的x轴距离相加
     * 最下侧的点和最上侧的点的y轴距离小于每个矩形两点之间的y轴距离相加
     * 这是我自己的思路，结果是错的。很可惜
     * @param rec1
     * @param rec2
     * @return
     */
    private static boolean cal1(int[] rec1, int[] rec2){
        int rec1_x_dis = rec1[2] - rec1[0];
        int rec2_x_dis = rec2[2] - rec2[0];
        int rec1_y_dis = rec1[3] - rec1[1];
        int rec2_y_dis = rec2[3] - rec2[1];

        return Math.max(Math.abs(rec1[2] -rec2[0]), Math.abs(rec1[0] - rec2[2])) < rec1_x_dis + rec2_x_dis
                && Math.max(Math.abs(rec1[3] -rec2[1]), Math.abs(rec1[1] - rec2[3])) < rec1_y_dis + rec2_y_dis;
    }

    /**
     * 官方1
     * 考虑绝对不相交的情况
     * 即 rec1 在 rec2 的左边， 右边， 上边 ，下边， 或者是左边上边，左边下边等情况同时存在
     * @param rec1
     * @param rec2
     * @return
     */
    @Official
    private static boolean cal2(int[] rec1, int[] rec2){
        return !(rec1[2] < rec1[0] || rec2[2] < rec1[0] || rec1[3] < rec2[1] || rec2[3] < rec1[1]);
    }

    /**
     * 官方的第二种做法，考虑相交会的矩形的边的x轴和y轴上有投影。
     * 我的做法思路其实相近，就是考虑最远的两点之间的x或y轴上的距离 大于 两个矩形分别的x轴和y轴距离之和，但不知哪里错了
     * 这思路直接看代码了
     * 最简单的方法是
     * @param rec1
     * @param rec2
     * @return
     */
    @Official
    private static boolean cal3(int[] rec1, int[] rec2){

        return Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0])
                && Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]);
    }

}
