class Solution {
    public String reverseWords(String s) {
        // String[] list = s.trim().split("\\s+");
        // int n=list.length;
        // int left=0,right=n-1;
        // while(left<right){
        //     String temp = list[left];
        //     list[left] = list[right];
        //     list[right]  =temp;
        //     left++;
        //     right--;
        // }
        // return String.join(" ",list);

        // Take string length
        int length = s.length();
        String result = "";

        // while ' ' is coming keep incrementing 'i'
        int i = 0;

        while (i < length) {
            while (i < length && s.charAt(i) == ' ')
                i++;

            int j = i + 1 > length ? i : i + 1;
            while (j < length && s.charAt(j) != ' ')
                j++;

            String substring = s.substring(i, j);

            if (substring.length() > 0)
                result = result.length() > 0 ? substring + " " + result : substring;

            i = j + 1;
        }

        return result;
    }
}