class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()) return new ArrayList<>();
        // Map<Character, Integer> pFreq = new HashMap<>();
        // char[] charArr = p.toCharArray();
        // for (char ch : charArr) {
        //     pFreq.put(ch, pFreq.getOrDefault(ch, 0) + 1);
        // }
        // int window_size = p.length();
        // // 0 2,1 3,
        // int j = 0;
        // for (int i = window_size; i <= s.length(); i++) {
        //     String subString = s.substring(j, i);
        //     Map<Character, Integer> sFreq = new HashMap<>();
        //     char[] charArray = subString.toCharArray();
        //     for (char ch : charArray) {
        //         sFreq.put(ch, sFreq.getOrDefault(ch, 0) + 1);
        //     // System.out.println(ch);
        //     }
        //     int match=0;
        //     for (Character key : pFreq.keySet()) {
        //         if (pFreq.get(key) == sFreq.get(key)) {
        //             match++;
        //         }
        //     }
        //     if(match==pFreq.keySet().size()){
        //     res.add(j);
        //     }
        //     j++;
        // }
        // return res;
        int[] freqP = new int[26];
        int[] window = new int[26];
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<p.length();i++){
            freqP[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(freqP,window)) res.add(0);

        for(int i=p.length();i<s.length();i++){
            window[s.charAt(i) - 'a']++;
            window[s.charAt(i - p.length()) - 'a']--;
            if(Arrays.equals(freqP,window)) res.add(i-p.length()+1);
        }
        return res;
    }
}