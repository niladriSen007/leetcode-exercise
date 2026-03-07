class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int start = 0, end = n - 1;
        if (arr[0] < arr[n - 1])
            return arr[0];
        if(n==1) return arr[0];
        int res = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid]>=arr[0]){
                int max = Math.max(arr[res],arr[mid]);
                res = arr[mid] == max ? mid : res;
                start=mid+1;
            }else{
                end = mid-1;
            }
            
        }
        System.out.println(res);
        return arr[(res + 1) % n];
    }
}