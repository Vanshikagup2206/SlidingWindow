package SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int resPos = 0;

        for(int end = 0; end < nums.length; end++){
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[end]){
                dq.removeLast();
            }

            dq.addLast(end);

            if(dq.getFirst() <= end - k){
                dq.removeFirst();
            }

            if(end >= k - 1){
                result[resPos++] = nums[dq.getFirst()];
            }
        }
        return result;
    }
}