package com.kidd.learn.leetcode;

import com.kidd.learn.Self;
import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 */
public class ZuiXiaoDeKGeShuLcof {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 2, 0};
        int k = 3;
        int[] result = cal1(arr, k);
        System.out.println(Arrays.asList(result));

    }


    /**
     * 最傻的方法，需要k个，就遍历k次arr，取出最小的k个
     * @param arr
     * @param k
     * @return
     */
    @Self
    private static int[] cal1(int[] arr, int k){
        if (arr == null || k > arr.length){
            throw new RuntimeException("the arr is null, and k is too long");
        }
        int[] result = new int[k];
        int currentMax = arr[0];

        for (int j = 0; j < arr.length; j++ ){
            if (arr[j] > currentMax){
                currentMax = arr[j] ;
            }

        }
        for (int i = 0; i < k; i++){
            int currentMin = arr[0];
            int pos = 0;
            for (int j = 0; j < arr.length; j++ ){
                if (currentMin >= arr[j]){
                    currentMin = arr[j];
                    pos = j;
                }
            }
            arr[pos] = currentMax;
            result[i] = currentMin;
        }
        return result;
    }

    /**
     * 排序 不考虑
     * @param arr
     * @param k
     * @return
     */
    @Self
    private static int[] cal2(int[] arr, int k){

        return null;
    }

    /**
     * 将所有的数都放进一个treeMap，以值为key，出现的次数为value，自然就排列了。
     * @param arr
     * @param k
     * @return
     */
    @Self
    private static int[] cal3(int[] arr, int k){
        int[] result = new int[k];
        Map<Integer, Integer> map = new TreeMap<>();
        for (int a : arr){
            if (map.containsKey(a)){
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (k >= count){
                break;
            }
            if (count + entry.getValue() + 1 <= k){
                for (int i = 0 ; i < entry.getValue(); i ++){
                    result[count++] = entry.getKey();
                }
            } else {
                for (int i = 0; i < k - count; i ++){
                    result[count++] = entry.getKey();
                }
            }
        }
        return result;
    }


}
