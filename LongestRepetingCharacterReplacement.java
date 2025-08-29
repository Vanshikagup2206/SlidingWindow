package SlidingWindow;

public class LongestRepetingCharacterReplacement {
    
//     public int characterReplacement(String s, int k) {
//         HashMap<Character, Integer> hm = new HashMap<>();
//         int left = 0;
//         int maxLength = 0;
//         int maxFreq = 0;

//         for(int right = 0; right < s.length(); right++){
//             char c = s.charAt(right);
//             hm.put(c, hm.getOrDefault(c,0) + 1);
            
//             maxFreq = Math.max(maxFreq, hm.get(c));

//             // shrink window if invalid
//             while ((right - left + 1) - maxFreq > k) {
//                 char leftChar = s.charAt(left);
//                 hm.put(leftChar, hm.get(leftChar) - 1);
//                 left++;
//             }

//             // always update maxLength after adjusting window
//             maxLength = Math.max(maxLength, right - left + 1);
//         }
//         return maxLength;
//     }
// }

    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, maxFreq = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count[c - 'A']++;
            
            maxFreq = Math.max(maxFreq, count[c - 'A']);

            // shrink if invalid
            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}