class Solution {
    public String reverseWords(String s) {
        String[] list = s.trim().split("\\s+");
        int n=list.length;
        int left=0,right=n-1;
        while(left<right){
            String temp = list[left];
            list[left] = list[right];
            list[right]  =temp;
            left++;
            right--;
        }
        return String.join(" ",list);
    }
}