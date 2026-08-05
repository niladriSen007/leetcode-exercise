class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;

        int[] freqS1 = new int[26];
        int[] wordCount = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freqS1[s1.charAt(i) - 'a']++;
            wordCount[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freqS1, wordCount))
            return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            wordCount[s2.charAt(i) - 'a']++;
            wordCount[s2.charAt(i - s1.length()) - 'a']--;
            if (Arrays.equals(freqS1, wordCount))
                return true;
        }
        return false;
    }
}