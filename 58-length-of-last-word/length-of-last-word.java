class Solution {
    public int lengthOfLastWord(String s) {
        String[] arr = s.trim().split(" ");
        String lastWord = arr[arr.length-1];
        return lastWord.length();
    }
}