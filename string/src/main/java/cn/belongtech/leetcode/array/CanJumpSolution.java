package cn.belongtech.leetcode.array;

/**
 * 跳跃游戏
 *
 * @author sunliang
 * @version 1.0
 */
public class CanJumpSolution {

    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个下标。
     *
     *
     * 贪心算法
     *
     *
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canJumpDemo(int[] nums) {
        int most = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= most) {
                most = Math.max(most, i + nums[i]);
                if (most >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
     *
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     *
     * 假设你总是可以到达数组的最后一个位置。
     *
     *
     */
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}