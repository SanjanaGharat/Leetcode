class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        
        for (int i = 0; i < nums1.length; i++) {
            int current = nums1[i];
            int nextGreater = -1;
            boolean foundCurrent = false;
            
            // Find the current element in nums2, then look for next greater
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == current) {
                    foundCurrent = true;
                    continue;
                }
                
                if (foundCurrent && nums2[j] > current) {
                    nextGreater = nums2[j];
                    break;
                }
            }
            
            result[i] = nextGreater;
        }
        
        return result;
    }
}