package august_2025_knight;

import java.util.Arrays;

class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String min_word = strs[0];
        for (String c : strs) {
            if (min_word.length() >= c.length()) {
                min_word = c;
            }
        }

        String longest = min_word;   // start with the shortest word
        for (int i = 0; i < strs.length; i++) {
            String temp = "";
            for (int j = 0; j < min_word.length(); j++) {
                if (strs[i].charAt(j) == min_word.charAt(j)) {
                    System.out.println("min[j]: " + min_word.charAt(j) + "\nstrs[i][j]: " + strs[i].charAt(j));
                    temp += strs[i].charAt(j);  // build common prefix with current string
                } else {
                    break;
                }
            }
            // shrink 'longest' to what is common so far
            if (temp.length() < longest.length()) {
                longest = longest.substring(0, temp.length());
            }
        }
        System.out.println(longest);
        return longest;
    }

    public static void main(String[] args) {
        String[] strs = { "flower", "flow", "flight" };
        longestCommonPrefix(strs);
    }
}
