class Solution {
    public boolean isValid(int row,int col,int mid,int k){
        int r = row,c=1;
        int count=0;
        while(r >= 1 && c <= col){
            if((r*c) > mid) r--;
            else{
                count += r;
                c++;
            }
        }
        return count >= k;
    }
    public int findKthNumber(int m, int n, int k) {
        int row = m,col = n;
        int start = 1, end = row*col;
        int res = -1;
        while(start<=end){
            int mid = start + (end-start)/2;
            System.out.println(mid);
            if(isValid(row,col,mid,k)) {
                res = mid;
                end = mid -1;
            }else start = mid+1;
        }
        return res;
    }
}