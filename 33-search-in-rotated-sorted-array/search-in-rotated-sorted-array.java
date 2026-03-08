class Solution {
    public int binarySearch(int[] arr, int target,int pos) {
        for(int i:arr){
            System.out.print(i+"->");
        }
        int n = arr.length;
        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target)
                return mid+pos;
            else if (arr[mid] < target)
                start = mid + 1;
            else
                end = mid -1;
        }
        return -1;
    }

    public int search(int[] arr, int target) {
        int n = arr.length;
        if (n == 1 && arr[0] != target)
            return -1;
        else if (n == 1 && arr[0] == target)
            return 0;
        int start = 0, end = n - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start);
        if (target == arr[start])
            return start;
        if (target > arr[start]) {
            if (target <= arr[n-1]) {
                return binarySearch(Arrays.copyOfRange(arr, start, n), target,start);
            } else {
                return binarySearch(Arrays.copyOfRange(arr, 0, start), target,0);
            }
        }
        return -1;
    }
}