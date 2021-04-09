package cn.belongtech.leetcode.string;

import java.util.Objects;

/**
 * 最长公共前缀
 *
 * @author sunliang
 * @version 1.0
 */
public class CommonSubString {

    /**
     * 最长公共前缀
     * @param strs 字符串
     * @return 最长公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        if(Objects.isNull(strs) || strs.length == 0) {
            return "";
        }

        String commonPrefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            commonPrefix = longestCommonPrefix(commonPrefix, strs[i]);
            if(commonPrefix.length() == 0) {
                break;
            }
        }

        return commonPrefix;
    }

    public String longestCommonPrefix(String str1, String str2){
        int minTotal = Math.min(str1.length(), str2.length());
        int end = 0;

        for(; end < minTotal; end++) {
            if(!Objects.equals(str1.charAt(end), str2.charAt(end))) {
                break;
            }
        }

        return str1.substring(0, end);
    }

    public static void main(String[] args) {
        CommonSubString commonSubString = new CommonSubString();

        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(commonSubString.longestCommonPrefix(strs));
    }
}