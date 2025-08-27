package SlidingWindow;

public class SubArrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;

        int product = 1;
        int count = 0;
        int start = 0;

        for(int i = 0; i < nums.length; i++){
            product *= nums[i];
            while(product >= k){
                product /= nums[start];
                start++;
            }
            //[start..i]
            count += i - start + 1;//end - start + 1
        }

        return count;
    }
}