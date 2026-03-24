class Pair {
    public int frequency;
    public int number;

    public Pair(int freq, int num) {
        this.frequency = freq;
        this.number = num;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        // for(Map.Entry<Integer,Integer> m : freq.entrySet()){
        //     System.out.println("key - "+m.getKey()+" value - "+m.getValue());
        // }
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a.frequency != b.frequency)
                        return a.frequency - b.frequency;
                    return a.number - b.number;
                });
        for (Map.Entry<Integer, Integer> m : freq.entrySet()) {
            pq.add(new Pair(m.getValue(), m.getKey()));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        for (Pair p : pq) {
    System.out.println(p.frequency + " : " + p.number);
}

    int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = pq.poll().number;
        }
        return topK;


        // return null;
    }
}