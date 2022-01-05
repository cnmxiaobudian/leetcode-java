package cn.belongtech.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 *
 * @author sunliang
 * @version 1.0
 */
public class SubString {

    /**
     * 不重复的最长子串的长度
     *
     * 重复 = hash
     *
     */
    public int lengthOfLongestSubstring(String s) {
        // 最大长度
        int length = 0;
        // 左指针
        int left = 0;
        // 右指针
        int right = 0;
        // 重复字符记录
        HashMap<Character, Integer> occur = new HashMap<>(128);

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

    public int lengthOfLongestSubstring2(String s) {
        int length = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            Integer index = map.get(s.charAt(right));
            map.put(s.charAt(right), right);

            if (null != index && index >= left) {
                left = index + 1;
            }

            if (right - left + 1 > length) {
                length = right - left + 1;
            }

            right++;
        }
        return length;
    }
}