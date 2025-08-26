class Solution {
    public int compress(char[] chars) {
int index = 0; // Position to write
        int i = 0;     // Position to read
        
        while (i < chars.length) {
            char currentChar = chars[i];
            int count = 0;
            
            // Count consecutive SAME characters (don't sort!)
            while (i < chars.length && chars[i] == currentChar) {
                count++;
                i++;
            }
            
            // Write the character
            chars[index++] = currentChar;
            
            // Write the count if greater than 1
            if (count > 1) {
                char[] countChars = Integer.toString(count).toCharArray();
                for (char c : countChars) {
                    chars[index++] = c;
                }
            }
        }
        
        return index;
    }
}