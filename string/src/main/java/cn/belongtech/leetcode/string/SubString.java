package cn.belongtech.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 无重复字符的最长子串
 *
 * @author sunliang
 * @version 1.0
 */
public class SubString {

    /**
     * 不重复的最长子串的长度
     * @param s 子串
     * @return 长度
     */
    public int lengthOfLongestSubstring(String s) {
        // 最大长度
        int length = 0;
        // 左指针
        int left = 0;
        // 右指针
        int right = 0;
        // 重复字符记录
        HashMap<Character, Integer> occur = new HashMap<>();

        // 遍历字符串
        while(right < s.length()) {
            Integer index = occur.get(s.charAt(right));
            occur.put(s.charAt(right), right);

            // 左指针不断移动
            if(null != index && index >= left) {
                left = index + 1;
            }

            if(right - left + 1 > length) {
                length = right - left + 1;
            }

            right++;
        }
        return length;
    }

    /**
     * main测试
     * @param args 入参
     */
    public static void main(String[] args) {
        SubString subString = new SubString();
        System.out.println(subString.lengthOfLongestSubstring("abcabcbb"));
    }

}