package cn.belongtech.leetcode.array;

import java.util.Arrays;

/**
 * 俄罗斯套娃二维数组
 *
 * @author sunliang
 * @version 1.0
 */
public class MaxEnvelopesSolution {

    /**
     * 首先我们将所有的信封按照 ww 值第一关键字升序、hh 值第二关键字降序进行排序；
     * 随后我们就可以忽略 ww 维度，求出 hh 维度的最长严格递增子序列，其长度即为答案。
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                // 降序
                return o1[0] - o2[0];
            } else {
                // 升序
                return o2[1] - o1[1];
            }
        });

        // 最长严格递增子序列
        int[] f = new int[envelopes.length];
        Arrays.fill(f, 1);
        int result = 1;

        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            result = Math.max(result, f[i]);
        }

        return result;
    }

    /**
     * 最长递增子序列（不需要连续）
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] f = new int[nums.length];
        Arrays.fill(f, 1);
        int result = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            result = Math.max(result, f[i]);
        }
        return result;
    }
}