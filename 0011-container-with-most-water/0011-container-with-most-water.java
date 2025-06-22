// class Solution {
//     public int maxArea(int[] height) {
//         int start = 0 ;
//         int end = height.length-1 ;
//         int maxCap = 0 ;
//         while(start<end){
//             int h = Math.min(height[start],height[end]);
//             int width = end - start ;
//             int currCap = h * width ;
//             maxCap = Math.max(currCap , maxCap );
//             if(height[start]<height[end]){
//                 start++;
//             }else{
//                 end--;
//             }
//         }
//         return maxCap;
//     }
// }

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            int currArea = h * width;
            maxArea = Math.max(maxArea, currArea);
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}
