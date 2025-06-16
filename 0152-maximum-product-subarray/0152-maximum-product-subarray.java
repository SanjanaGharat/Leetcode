class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            // Store current max before updating (we need original value for min calculation)
            int temp = max;
            
            // Calculate new max (consider three possibilities)
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            
            // Calculate new min (consider three possibilities)
            min = Math.min(nums[i], Math.min(temp * nums[i], min * nums[i]));
            
            // Update overall result
            result = Math.max(result, max);
        }
        
        return result;
    }
}