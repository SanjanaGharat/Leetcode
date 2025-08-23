class Solution {
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        
        // First pass: count zeros and move non-zeros to front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zeroCount] = nums[i];
                zeroCount++;
            }
        }
        
        // Second pass: fill the end with zeros
        for (int i = zeroCount; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}