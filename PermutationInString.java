package SlidingWindow;

import java.util.Arrays;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] hmS1 = new int[26];
        for(int i = 0; i < s1.length(); i++){
            hmS1[s1.charAt(i) - 'a']++;
        }

        int left = 0;
        int[] hmS2 = new int[26];
        for(int right = 0; right < s2.length(); right++){
            hmS2[s2.charAt(right) - 'a']++;

            // shrink the window if it's too big
            if(right - left + 1 > s1.length()){
                hmS2[s2.charAt(left) - 'a']--;
                left++;
            }

            // check if window matches s1
            if(Arrays.equals(hmS1,hmS2)){
                return true;
            }
        }

        return false;
    }
}