class Project {
    public int cap;
    public int profit;

    public Project(int cap, int profit) {
        this.cap = cap;
        this.profit = profit;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }
        Arrays.sort(projects, Comparator.comparingInt(a -> a.cap));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int idx = 0;
        while (k > 0) {
            while (idx < n) {
                if (projects[idx].cap > w)
                    break;
                maxHeap.add(projects[idx].profit);
                idx++;
            }
            if (maxHeap.isEmpty())
                return w;
            w += maxHeap.poll();
            k--;
        }
        // for (Integer p : maxHeap) {
        //     System.out.println(p);
        // }
        // while (!maxHeap.isEmpty()) {
        //     w += maxHeap.peek();
        //     maxHeap.poll();
        // }
        return w;
    }
}