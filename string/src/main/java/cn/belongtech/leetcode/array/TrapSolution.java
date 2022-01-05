package cn.belongtech.leetcode.array;

/**
 * 接雨水
 *
 * @author sunliang
 * @version 1.0
 */
public class TrapSolution {

    /**
     * 暴力求解
     */
    public int trap(int[] height) {
        int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left = 0;
            int right = 0;
            for (int j = i; j >= 0; j--) {
                left = Math.max(left, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                right = Math.max(right, height[j]);
            }
            result += Math.min(left, right) - height[i];
        }
        return result;
    }

    /**
     * 双指针
     */
    public int trapBy2(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }
}