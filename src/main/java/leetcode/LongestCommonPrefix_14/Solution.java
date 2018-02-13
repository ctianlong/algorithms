package leetcode.LongestCommonPrefix_14;

import org.junit.Test;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 最长公共前缀字符串
 * @author Tianlong
 *
 */
public class Solution {
	
	/*
	 * 水平扫描，
	 * 即使数组中最后一个字符串很短，但该方法仍要比较所有字符串，因此考虑用垂直扫描
	 */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int min = result.length() > strs[i].length() ? strs[i].length() : result.length();
            int j;
            for (j = 0; j < min; j++)
                if (result.charAt(j) != strs[i].charAt(j)) break;
            if (j == 0) {
                result = "";
                break;
            }
            result = result.substring(0, j);
        }
        return result;
    }
    
    /*
     * 垂直扫描
     */
    public String longestCommonPrefix2(String[] strs) {
    	if (strs == null || strs.length == 0) return "";
    	int i, len = strs[0].length();
    	char tmp;
    	out:for (i = 0; i < len; i++) {
    		tmp = strs[0].charAt(i);
    		for (int j = 1; j < strs.length; j++) 
    			if (i >= strs[j].length() || strs[j].charAt(i) != tmp) break out;
    	}
    	return strs[0].substring(0, i);
    	
    	//精简写法
//    	if (strs == null || strs.length == 0) return "";
//    	int i;
//    	out:for (i = 0; i < strs[0].length(); i++) 
//    		for (int j = 1; j < strs.length; j++) 
//    			if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) break out;
//    	return strs[0].substring(0, i);
    }
    
    
    @Test
    public void test() {
    	String s = "abc";
//    	System.out.println(s.charAt(3)); //异常
//    	System.out.println(s.substring(0, 4)); //异常
    	System.out.println(s.indexOf("ad")); //-1
    	System.out.println(s.substring(0, 0).length()); //空字符串
    }
    
    
}
