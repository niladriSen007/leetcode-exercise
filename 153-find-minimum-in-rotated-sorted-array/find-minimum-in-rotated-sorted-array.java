class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int start = 0, end = n - 1;
        if (arr[0] < arr[n - 1])
            return arr[0];
        if(n==1) return arr[0];
        while (start < end) {
            int mid = start + (end - start) / 2;
            if(arr[mid]>arr[end]){
                start=mid+1;
            }else{
                end = mid;
            }
            
        }
        return arr[start];
    }
}