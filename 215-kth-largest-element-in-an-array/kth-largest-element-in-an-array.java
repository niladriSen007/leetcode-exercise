class Solution {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < minHeap.peek())
                continue;
            else {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        return minHeap.peek().intValue();
    }
}