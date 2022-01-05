package cn.belongtech.leetcode.array;

/**
 * 盛水最多的容器
 *
 * @author sunliang
 * @version 1.0
 */
public class MaxAreaSolution {
    /**
     * 双指针
     *
     * 面积计算：min(A(start), A(end)) * (end - start)
     * 移动较小数字对应的指针
     *
     */
    public int maxArea(int[] height) {
        int result = 0;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            int area = Math.min(height[start], height[end]) * (end - start);
            result = Math.max(area, result);

            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return result;
    }
}
