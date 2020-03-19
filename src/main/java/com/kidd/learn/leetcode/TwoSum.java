package com.kidd.learn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] num1 = {1, 5, 3, 7, 8};
        int target1 = 4;
        //int[] results = calc1(num1, target1);
        //System.out.format("the first is %d, the second is %d", results[0], results[1]);
        //int[] results = calc1(num1, target1);
        //System.out.format("the first is %d, the second is %d", results[0], results[1]);
        int[] results = calc3(num1, target1);
        System.out.format("the first is %d, the second is %d", results[0], results[1]);
    }

    /**
     * 暴力破解法
     * @param nums
     * @param target
     * @return
     */
    private static int[] calc1(int[] nums, int target){
        if (nums == null || nums.length < 2){
            return null;
        }
        int[] result = {0, 0};
        int length = nums.length;
        for (int i = 0; i < length; i ++){
            for (int j = i + 1; j < length; j++ ){
                if (nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * hash两次循环, 少了两次循环的问题
     * @param nums
     * @param target
     * @return
     */
    private static int[] calc2(int[] nums, int target){
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i ++){
            maps.put(nums[i], i);
        }
        for (int i = 0; i < nums.length ; i ++){
            int complement = target - nums[i];
            if (maps.containsKey(complement) && maps.get(complement) != i){
                return new int[]{i, maps.get(complement)};
            }
        }
        throw new RuntimeException("no result");
    }

    /**
     * solution3: hash一次遍历
     * @param nums
     * @param target
     * @return
     */
    private static int[] calc3(int[] nums, int target){
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i ++){
            int complement = target - nums[i];
            if(maps.containsKey(complement)){
                return new int[]{maps.get(complement), i};
            };
            maps.put(nums[i], i);
        }
        throw new RuntimeException("no result");
    }

}
