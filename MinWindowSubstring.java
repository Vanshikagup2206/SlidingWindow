package SlidingWindow;

import java.util.HashMap;

public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        int left = 0; // sliding window ka left pointer
        
        // freq = required frequency map (target string "t" ke chars)
        HashMap<Character, Integer> freq = new HashMap<>();
        // window = current window me abhi kitne chars hain
        HashMap<Character,Integer> window = new HashMap<>();

        // Step 1: target string ke liye freq map banao
        for(char i : t.toCharArray()){
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        int minLength = Integer.MAX_VALUE; // ab tak ka shortest valid window
        int startIndex = 0;                // shortest window ka starting index
        int formed = 0;                    // kitne unique chars abhi satisfy hue hain
                                           // e.g. if need = {A:1, B:1, C:1} 
                                           // aur window ne A aur B satisfy kar liya => formed = 2

        // Step 2: expand window with right pointer
        for(int right = 0; right < s.length(); right++){
            char c = s.charAt(right);

            // agar current char required hai (present in freq)
            if(freq.containsKey(c)){
                // window me count badhao
                window.put(c, window.getOrDefault(c, 0) + 1);

                // agar required frequency match ho gayi
                // e.g. freq[A] = 2 aur ab window[A] = 2 -> ek char satisfy hua
                if(window.get(c).equals(freq.get(c))){
                    formed++;
                }
            }

            // Step 3: jab tak window valid hai (all required chars satisfied)
            while(formed == freq.size()){
                // check if yeh window ab tak ki minimum hai
                if((right - left + 1) < minLength){
                    minLength = right - left + 1;
                    startIndex = left; // update startIndex
                }
                
                // ab left pointer ko move karke shrink karna try karo
                char d = s.charAt(left);
                if(freq.containsKey(d)){
                    // agar char d ki count break ho gayi
                    // e.g. freq[A]=2, window[A]=2 → formed-- karna padega
                    if(window.get(d).equals(freq.get(d))){
                        formed--;
                    }
                    // us char ka count kam kar do
                    window.put(d, window.get(d) - 1);
                }

                // left pointer ko aage badhao
                left++;
            }
        }

        // agar minLength update nahi hua → matlab no valid window mila
        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }
}