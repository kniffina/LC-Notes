import java.util.HashMap;

public class LongestPalindromeSubstring {

    public static String longestPalindromeSub(String s) {
        if(s == null || s.length() <= 0) return "";

        int mid1 = 0, mid2 = 0;

        if(s.length() % 2 == 0) {
            mid1 = s.length() / 2 - 1;
            mid2 = s.length() / 2;
        } else {
            mid1 = s.length() / 2;
            mid2 = s.length() / 2;
        }

        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Character> hm = new HashMap<Integer, Character>();

        while(mid1 >= 0 && mid2 < s.length()) {
            if(s.charAt(mid1) != s.charAt(mid2)) return sb.toString();
            else {
                if(mid1 == mid2) hm.put(mid1, s.charAt(mid1));
                else if(s.charAt(mid1) == s.charAt(mid2)){
                    hm.put(mid1, s.charAt(mid1));
                    hm.put(mid2, s.charAt(mid2));
                }
                else
                    break;

                mid1--;
                mid2++;
            }
        }

        for(Integer y : hm.keySet()) {
            sb.append(hm.get(y));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abac";

        System.out.println(longestPalindromeSub(s));
    }
}
