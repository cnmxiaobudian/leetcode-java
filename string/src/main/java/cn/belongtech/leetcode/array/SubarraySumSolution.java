package cn.belongtech.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为K的子数组
 *
 * @author sunliang
 * @version 1.0
 */
public class SubarraySumSolution {

    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
     *
     * 数组遍历 (i, j)
     *
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0;

        // i指针往前，j指针向后，计算总值
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和 + 哈希表（总和 - 数量）
     */
    public int subarraySumBy2(int[] nums, int k) {
        int count = 0;
        int pre = 0;

        // 总和 - 数量
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        map.put(0, 1);

        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}