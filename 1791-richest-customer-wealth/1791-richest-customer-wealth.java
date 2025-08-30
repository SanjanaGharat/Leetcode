class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        
        for (int row = 0; row < accounts.length; row++) {
            int rowsum = 0;
            
            for (int col = 0; col < accounts[row].length; col++) {
                rowsum += accounts[row][col];
            }
            
            if (rowsum > max) {
                max = rowsum;
            }
        }
        
        return max;
    }
}