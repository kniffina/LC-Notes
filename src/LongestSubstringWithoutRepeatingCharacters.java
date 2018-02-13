import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    /*
    int[26] for Letters 'a' - 'z' or 'A' - 'Z'
    int[128] for ASCII
    int[256] for Extended ASCII

     */

    public static int longest(String s) {
        int max = 0, leftCount = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();


        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);

            //check to see if this value is in the map, if it is we need to find out
            //the greater between the left value and the index of where this character is
            if(map.containsKey(c)) {
                //left window now holds where the last time this was seen
                leftCount = Math.max(map.get(c), leftCount);
            }
            max = Math.max(max , i - leftCount + 1);
            map.put(c, i + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "aabcdeffg"; //abcdef (6)

        System.out.println(longest(s));
    }
}
