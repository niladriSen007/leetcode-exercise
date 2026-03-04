class Solution {
    public int findFirstOccurance(int[] arr, int target) {
        int n = arr.length;
        int start = 0, end = n - 1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                res = mid;
                end = mid-1;
            } else if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return res;
    }

    public int findLastOccurance(int[] arr, int target) {
        int n = arr.length;
        int start = 0, end = n - 1;
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                res = mid;
                start = mid + 1;
            } else if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return res;
    }

    public int[] searchRange(int[] nums, int target) {
        int first = findFirstOccurance(nums, target);
        int last = findLastOccurance(nums, target);
        return new int[] { first, last };
    }
}