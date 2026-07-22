class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n= strs.length;
        Arrays.sort(strs);
        int count = 0;
        String first = strs[0];
        String last = strs[n-1];
        int right=0;
        while(right < first.length()){
            if(first.charAt(right)== last.charAt(right)){
                count++;
            }else{
                break;
            }
            right++;
        }
        return first.substring(0,count);
    }
}