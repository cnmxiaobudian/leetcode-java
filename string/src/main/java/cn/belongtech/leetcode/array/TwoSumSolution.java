package cn.belongtech.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author sunliang
 * @version 1.0
 */
public class TwoSumSolution {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 暴力求值（双重循环）
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 哈希表（值 - 下标）
     */
    public int[] twoSumBy2(int[] nums, int target) {
        // 值 - 下标
        Map<Integer, Integer> hashMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{i, hashMap.get(target - nums[i])};
            }
            hashMap.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * 给定一个已按照 非递减顺序排列的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
     *
     * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
     */
    public int[] twoSum2(int[] numbers, int target) {
        // 双指针
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                return new int[]{start + 1, end + 1};
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }

        return new int[0];
    }
}