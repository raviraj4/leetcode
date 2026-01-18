
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedHashMap;

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

public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i<nums.length; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
        int l = i+1;
        int r = nums.length-1;
        while (l < r){
            int sum = nums[i]+nums[l]+nums[r];
            if(sum == 0){
                
                result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                r-=1;
                l+=1;
                
                while (l<r && nums[l]==nums[l-1]) l++;
                while (l<r && nums[r]==nums[r+1]) r--;
            }
            else if(sum<0){
                l+=1;
            }else{
                r-=1;
            }

        }
        }
        return result;
    }

    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            int l = i+1;
            int r = nums.length-1;

        while(l<r){
            int sum = nums[i] + nums[l] + nums[r];
            if(Math.abs(closest - target) > Math.abs(sum - target)){
                closest = sum;
            }
            if(sum == target){
                return target;
            }else if(sum < target){
                l+=1;
            }else{
                r-=1;
            }
        }   

        }
        return closest;
        
    }

    public int romanToInt(String s) {
       
        final Map<String, Integer> mapping = new LinkedHashMap<>();

        mapping.put("M", 1000);
        mapping.put("CM", 900);
        mapping.put("D", 500);
        mapping.put("CD", 400);
        mapping.put("C", 100);
        mapping.put("XC", 90);
        mapping.put("L", 50);
        mapping.put("XL", 40);
        mapping.put("X", 10);
        mapping.put("IX", 9);
        mapping.put("V", 5);
        mapping.put("IV", 4);
        mapping.put("I", 1);
        // int res = mapping.get(s[0]);
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if (s.length() == 1){
                return mapping.get(String.valueOf(s.charAt(i)));
                }
            if(i+1 < s.length() && mapping.get(String.valueOf(s.charAt(i)))<mapping.get(String.valueOf(s.charAt(i+1)))){
                // subtract
                res -= mapping.get(String.valueOf(s.charAt(i))); 
                // - mapping.get(String.valueOf(s.charAt(i-1)));
            }else{
                // add
                res += mapping.get(String.valueOf(s.charAt(i))) ;
                // + mapping.get(String.valueOf(s.charAt(i-1)));
            }
        }
        return res;
    
    }

    public static String intToRoman(int num) {
        // hashtable | int to roman leetcode
        final Map<String, Integer> mapping = new LinkedHashMap<>();
        
        mapping.put("M", 1000);
        mapping.put("CM", 900);
        mapping.put("D", 500);
        mapping.put("CD", 400);
        mapping.put("C", 100);
        mapping.put("XC", 90);
        mapping.put("L", 50);
        mapping.put("XL", 40);
        mapping.put("X", 10);
        mapping.put("IX", 9);
        mapping.put("V", 5);
        mapping.put("IV", 4);
        mapping.put("I", 1);

        StringBuilder sb = new StringBuilder();
        for(String key : mapping.keySet() ){
            if(num == 0 ) 
            break;
            while (num >= mapping.get(key)){
                sb.append(key);
                num -= mapping.get(key);
            }
        }
        return sb.toString();
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Map<Character, String> map = new LinkedHashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        class Bt {
        public void backtrack(int i, StringBuilder curstr){
            if(i == digits.length()){
                res.add(curstr.toString());
                return;
            }

            for (int c = 0; c < map.get(digits.charAt(i)).length(); c++){
                curstr.append(map.get(digits.charAt(i)).charAt(c));
                backtrack(i + 1, curstr); 
                curstr.deleteCharAt(curstr.length() - 1);
                }
        }
        }
        StringBuilder sb = new StringBuilder();
        if(digits.length()>=1) new Bt().backtrack(0,sb);
        return res;
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
        // int[] nums = {1,1,2};
        // int lengthRD = removeDuplicates(nums);
        // System.out.println("length of expectedNums: "+lengthRD);


        System.out.println(intToRoman(2));

    }
}
