package cn.belongtech.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 *
 * @author sunliang
 * @version 1.0
 */
public class LongestConsecutiveSolution {

    /**
     * hash表
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashNum = new HashSet<>();
        for (int num : nums) {
            hashNum.add(num);
        }

        int longestStack = 0;
        for (Integer num : hashNum) {
            if (!hashNum.contains(num - 1)) {
                int currentNum = num;
                int currentStack = 1;

                while (hashNum.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStack += 1;
                }

                longestStack = Math.max(longestStack, currentStack);
            }
        }
        return longestStack;
    }
}