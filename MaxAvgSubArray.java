package SlidingWindow;

public class MaxAvgSubArray {
    public double findMaxAverage(int[] nums, int k) {     
        int start = 0;   
        int windowSum = 0;

        // Step 1: first window
        for(int i = 0; i < k; i++){
            windowSum += nums[i];
        }

        int bestSum = windowSum;

        // Step 2: slide the window
        for(int i = k; i < nums.length; i++){
            windowSum -= nums[start++];
            windowSum += nums[i];
            if(windowSum > bestSum){
                bestSum = windowSum;
            }
        }
        // Step 3: return max average
        return bestSum / (double)k;
    }
}