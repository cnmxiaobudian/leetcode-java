package cn.belongtech.leetcode.string;

import java.util.Arrays;
import java.util.Objects;

/**
 * 字符串的全排列
 *
 * @author sunliang
 * @version 1.0
 */
public class StringCheckInclusion {

    /**
     * 字符串的全排列
     * @param s1 排列串
     * @param s2 源串
     * @return 是否包含排列关系
     */
    public boolean checkInclusion(String s1, String s2) {
        if(Objects.isNull(s1) || Objects.isNull(s2)
                || s1.length() == 0 || s2.length() == 0
                || s1.length() > s2.length()) {
            return false;
        }

        // 26个字母对应的asc
        int[] source = new int[26];
        int[] dest = new int[26];

        for (int i = 0; i < s1.length(); ++i) {
            ++source[s1.charAt(i) - 'a'];
            ++dest[s2.charAt(i) - 'a'];
        }

        if(Arrays.equals(source, dest)) {
            return Boolean.TRUE;
        }

        for (int i = s1.length(); i < s2.length(); ++i) {
            ++dest[s2.charAt(i) - 'a'];
            --dest[s2.charAt(i - s1.length()) - 'a'];
            if (Arrays.equals(source, dest)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        StringCheckInclusion stringCheckInclusion = new StringCheckInclusion();
        System.out.println(stringCheckInclusion.checkInclusion("ab", "eidbaooo"));
    }
}