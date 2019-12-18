import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstrWithoutRepeatingChars {
    public static void main(String[] args) {
        int len = new LongestSubstrWithoutRepeatingChars().lengthOfLongestSubstring("dvdf");
        System.out.println("len = " + len);
//        len = new LongestSubstrWithoutRepeatingChars().lengthOfLongestSubstring2("dvdf");
//        System.out.println("len2 = " + len);
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> used = new HashSet<>();

        int maxLen = 0, i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            char c = s.charAt(j);
            boolean notUsed = !used.contains(c);
            if (notUsed) {
                used.add(c);
                ++j;
                maxLen = Math.max(j - i, maxLen);
            } else {
                used.remove(s.charAt(i++));
            }
        }
        maxLen = Math.max(j - i, maxLen);

        return maxLen;
    }

  /*  public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> charMap = new HashMap<>();

        int maxLen = 0, i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            char c = s.charAt(j);
            Integer oldIdx = charMap.get(c);
            if (oldIdx == null) {
                charMap.put(c, i);
                ++j;
                maxLen = Math.max(j - i, maxLen);
            } else {
                charMap.remove(s.charAt(i++));
            }
        }
        maxLen = Math.max(j - i, maxLen);
        return maxLen;
    }*/
}
