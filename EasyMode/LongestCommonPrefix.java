/* Task: Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "". */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        int currLetterIdx = 0;
        int currWordIdx = 0;
        int initIdx = 0;
        Character initChar = 0;
        
        
        while (true) {

            if ( currWordIdx == strs.length ) { // reached the end of word list (all letters of position currLetterIdx match)
                currWordIdx = 0; // reset to start from top of list 
                result += initChar;
                currLetterIdx++;
                initIdx = currLetterIdx;
            }

            try {
                if ( currWordIdx == 0 ) initChar = (Character) strs[currWordIdx].charAt(initIdx);
                
                String currWord = strs[currWordIdx++];
                
                if ( currWord.charAt(currLetterIdx) != initChar ) {
                    break;
                }
            } catch (IndexOutOfBoundsException exception) {
                return result;
            }

        }      

        return result;
    }
}