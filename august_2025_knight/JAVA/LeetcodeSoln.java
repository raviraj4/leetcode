
import java.util.Arrays;
import java.util.Stack;
import java.util.ArrayList;

public class LeetcodeSoln {

    public static int removeDuplicates(int[] nums) {
        // loop 
        int current = 0; // current index

        for (int i = current; i<nums.length;i++){
            // ex : [1,1,2]
            // (i = 0)1 -> 1(0),1(1) same, at (j = 2) 1(0) != 2(2)  i,j-1 is same. 0, 1 (2-1) -> 1
            // then nums[i]
            for (int j = i; j<nums.length;j++){

            }
        }


        return nums.length;
    }


    public static boolean isValid(String s) {
        if(s.length()<=Math.pow(10,4)){
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i<= s.length()-1; i++){
                if(s.charAt(i)=='{' || s.charAt(i)=='(' || s.charAt(i)=='['){
                    stack.push(s.charAt(i));

                }else{
                    if(stack.isEmpty()){
                        return false;
                    }
                    if(stack.peek()=='{' && s.charAt(i)=='}' || stack.peek()=='(' && s.charAt(i)==')' || stack.peek()=='[' && s.charAt(i)==']'){
                        stack.pop(); 
                    }else{
                    return false;
                    }
                }
                
                // return false;
            }
            if(stack.isEmpty()){
                    return true;
            }
          
        }
        return false;
}
// MY SOLUTION - 115/126 (try fixing)
    public static String longestCommonPrefix(String[] strs) {
        String min_wrd = strs[0];
        if(strs.length<1 || strs == null || strs.length> 200){
            return "";
        }else{
        // finding the min len word
        
        for (String word:strs){
            if(word.length()<=min_wrd.length()){
                min_wrd = word;
            }
        }

        ArrayList<Character> lcpArr = new ArrayList<>();
        // lcp arr
        boolean flag = false;
        for(String word: strs){
            for(int j = 0; j <= min_wrd.length()-1;++j){
                if(min_wrd.charAt(j)==word.charAt(j)){
                    lcpArr.add(min_wrd.charAt(j));
                }else {
                    flag = true;
                    break;
                }   
            }
            //if (flag){break;}

        }
        // now I must count, if a char c exists target times, then add it to another target arr
        ArrayList<Character> targetArr = new ArrayList<>();
        int targetLen = strs.length;
        int count = 0;
        for (int i = 0 ; i <= min_wrd.length()-1 ; i++){
            for (char c: lcpArr){
                if(min_wrd.charAt(i)==c){
                    count++;
                    if(count == targetLen){
                        targetArr.add(c);
                        count = 0;
                        break;
                    }
                }
            }
            count = 0;

        }
        // converting target arr to string
        StringBuilder sb = new StringBuilder();
        for (Character c:targetArr){
            sb.append(c);
        }
        String res = sb.toString();
        return res;



        }


    }
    
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
        // int a = lengthOfLongestSubstring("abcabcbb");
        // System.out.println(a);
        // testDemo();

        // remove duplicates
        int[] nums = {1,1,2};
        int lengthRD = removeDuplicates(nums);
        System.out.println("length of expectedNums: "+lengthRD);
    }
}
