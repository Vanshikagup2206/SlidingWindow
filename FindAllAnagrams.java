package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int[] freqP = new int[26];

        for(int i = 0; i < p.length(); i++){
            freqP[p.charAt(i) - 'a']++;
        }

        int left = 0;
        int[] freqS = new int[26];
        List<Integer> result = new ArrayList<>();
        for(int right = 0; right < s.length(); right++){
            freqS[s.charAt(right) - 'a']++;

            if((right - left + 1) > p.length()){
                freqS[s.charAt(left) - 'a']--;
                left++;
            }

            if(Arrays.equals(freqS, freqP)){
                result.add(left);
            }
        }
        return result;
    }
}