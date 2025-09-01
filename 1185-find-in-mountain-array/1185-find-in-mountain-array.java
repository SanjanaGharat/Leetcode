/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        
        // Step 1: Find the peak index using binary search
        int peak = findPeak(mountainArr, n);
        
        // Step 2: Search in the left (ascending) part of the mountain
        int leftResult = binarySearchAscending(mountainArr, target, 0, peak);
        if (leftResult != -1) {
            return leftResult;
        }
        
        // Step 3: If not found in left part, search in right (descending) part
        return binarySearchDescending(mountainArr, target, peak + 1, n - 1);
    }
    
    private int findPeak(MountainArray mountainArr, int n) {
        int start = 0;
        int end = n - 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);
            int nextVal = mountainArr.get(mid + 1);
            
            if (midVal < nextVal) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    
    private int binarySearchAscending(MountainArray mountainArr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);
            
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
    
    private int binarySearchDescending(MountainArray mountainArr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);
            
            if (midVal == target) {
                return mid;
            } else if (midVal > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}