class Solution {
    public boolean isIsomorphic(String s, String t) {

        // Map<Character,Character> mapST =new HashMap<>();
        // Map<Character,Character> mapTS = new HashMap<>();

        int n = s.length();

        // for(int i=0;i<n;i++){

        //     char s1 = s.charAt(i);
        //     char t1 = t.charAt(i);

        //     if(mapST.containsKey(s1) && mapST.get(s1) != t1) return false;
        //     if(mapTS.containsKey(t1) && mapTS.get(t1) != s1) return false;

        //     mapST.put(s1,t1);
        //     mapTS.put(t1,s1);
        // }
        // return true;

        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        Arrays.fill(freq1, -1);
        Arrays.fill(freq2, -1);

        for (int i = 0; i < n; i++) {

            char s1 = s.charAt(i);
            char t1 = t.charAt(i);

            if (freq1[s1] != freq2[t1])
                return false;

            freq1[s1] = i;
            freq2[t1] = i;

        }
        return true;
    }
}