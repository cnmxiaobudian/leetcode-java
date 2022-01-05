package cn.belongtech.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @author sunliang
 * @version 1.0
 */
public class ThreeSumSolution {
    /**
     * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * 三重循环
     * 固定一个值！！！！！
     * 排序 + 双指针（a + b + c = 0  =====>  a + b = -c）（两数加法 TwoSumSolution.twoSum2）
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length <= 2) {
            return results;
        }

        // 排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            // 相同的数，直接跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];

            // 双指针
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum == target) {
                    results.add(new ArrayList<>(Arrays.asList(nums[start], nums[end], nums[i])));

                    start++;
                    end--;

                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return results;
    }

    /**
     * 降维操作
     */
    public List<List<Integer>> threeSumByDemo(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == nums || nums.length <= 2) {
            return result;
        }

        // 排序
        Arrays.sort(nums);

        // 固定一个值：a + b = -c
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 降维成为：针对升序数组，两数之和等于某一固定值。即可使用双指针
            int target = -nums[i];
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum == target) {
                    result.add(Arrays.asList(nums[start], nums[end], nums[i]));

                    start++;
                    end--;

                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
}