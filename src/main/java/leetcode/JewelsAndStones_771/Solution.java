package leetcode.JewelsAndStones_771;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	public static void main(String[] args) {
		System.out.println(new Solution().numJewelsInStones("aA", "aAAbbbb"));
	}
	
	public int numJewelsInStones(String J, String S) {
		int ans = 0;
        Set<Character> s = new HashSet<>();
        char[] jc = J.toCharArray();
        int lj = jc.length;
        for (int i = 0; i < lj; i++) {
        	s.add(jc[i]);
        }
        char[] sc = S.toCharArray();
        int ls = sc.length;
        for (int i = 0; i < ls; i++) {
        	if (s.contains(sc[i])) {
        		ans++;
        	}
        }
        return ans;
    }

}
