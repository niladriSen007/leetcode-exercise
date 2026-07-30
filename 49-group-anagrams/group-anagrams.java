class Solution {

    public String generateKey(int[] freq){
        char start = 97;
                StringBuilder sb = new StringBuilder();
        for(int count:freq){
            if(count>0){
                sb.append((char) start);
                sb.append(count);
            }
                start++;
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        // group wac string by frequency -> a1b2c3
        // {
        // "a1b2" : ["abb","bab",...]
        // }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] freq = new int[26]; // to store the frequency of each character [1,2,0,0] a-> 2 times, b-> 1 times,...
            char[] ch = str.toCharArray();
            for (char c : ch) {
                freq[c - 'a']++;
            }
            String key = generateKey(freq);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}