class Pair {
    public Integer freq;
    public Character ch;

    public Pair(Integer freq, Character ch) {
        this.freq = freq;
        this.ch = ch;
    }

}

class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        // for(Map.Entry<Character,Integer> m:freq.entrySet()){
        //     System.out.println(m.getKey() + "----" + m.getValue());
        // }
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
                (a, b) -> {
                    if (a.freq != b.freq)
                        return b.freq - a.freq;
                    return b.ch.compareTo(a.ch);
                });
        for (Map.Entry<Character, Integer> m : freq.entrySet()) {
            maxHeap.add(new Pair(m.getValue(), m.getKey()));
        }
        StringBuilder res = new StringBuilder();
        int seat = 0;
        while (!maxHeap.isEmpty()) {
            Pair p = maxHeap.poll();
            if (seat == 0 || res.charAt(seat - 1) != p.ch) {
                res.append(p.ch);
                p.freq--;
            } else {
                if (maxHeap.isEmpty())
                    return "";
                Pair p1 = maxHeap.poll();
                res.append(p1.ch);
                p1.freq--;
                if (p1.freq > 0)
                    maxHeap.add(p1);
            }
            if (p.freq > 0)
                maxHeap.add(p);
            seat++;
        }
        return res.toString();
    }
}