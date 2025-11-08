
import java.util.Arrays;
import java.util.ArrayList;

public class LeetcodeSoln {
    public static int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        int l = 0;
        int r = 0;
        int maxlen = 0;
        int len = 0;
        int n = s.length();
        for (int i = 0; i <= s.length() - 1; i++) {
            while (r < n) {
                if (hash[s.charAt(r)] != -1) { // string.charAt(index) to get character at certain index in a string
                    if (hash[s.charAt(r)] >= l) {
                        l = hash[s.charAt(r)] + 1;
                    }
                }
                len = r - l + 1;
                maxlen = Math.max(maxlen, len);
                hash[s.charAt(r)] = r;
                r++;
            }
        }
        return maxlen;
    }

    public static void testDemo() {
        // IGNORE : ONLY FOR DEMO
        int[] hasharr = new int[256];
        Arrays.fill(hasharr, -1);
        System.out.println("hasharr at r" + hasharr['@']);
        for (int i = 0; i <= hasharr.length - 250; i++) {
            System.out.println(hasharr[i]);
        }

        String s = "skibidi";
        System.out.println(s.charAt(0));
        System.out.println(s.length());
        // normal
        int[] arr = new int[20];
        System.out.println("arr 1: " + arr[1]);
        // using ArrayList
        ArrayList<Integer> ar = new ArrayList<>();
        for (int i = 10; i <= 20; i++) {
            ar.add(i);
        }
        for (int i = 0; i <= ar.size() - 1; i++) {
            System.out.println(ar.get(i));
        }
    }

    public static void main(String args[]) {
        int a = lengthOfLongestSubstring("abcabcbb");
        System.out.println(a);
        // testDemo();
    }
}
