package cn.belongtech.leetcode.array;

/**
 * 连续递增序列
 *
 * @author sunliang
 * @version 1.0
 */
public class FindLengthOfLCISSolution {
    /**
     * 双向指针（快慢指针）
     */
    public int findLengthOfLCIS(int[] nums) {
        int result = 0;
        int start = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] <= nums[i-1]) {
                start = i;
            }
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}