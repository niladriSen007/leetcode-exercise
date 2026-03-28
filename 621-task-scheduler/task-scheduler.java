class Pair {
    public int frequency;
    public Character ch;

    public Pair(int frequency, Character ch) {
        this.frequency = frequency;
        this.ch = ch;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        // int length = tasks.length;
        // storing the frequency of each character in array of size 26
        for (char i : tasks) {
            freq[i - 65]++;
        }
        // creating a max heap to store the <freq,char> inside a maxHeap
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
                (a, b) -> b.frequency - a.frequency);
        // storing the seat number where CHAR can be fitted
        Map<Character, Integer> freeSeat = new HashMap<>();
        for (char ch : tasks) {
            freeSeat.put(ch, freeSeat.getOrDefault(ch, 1));
        }
        // pushing freq arr data into maxHeap
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                maxHeap.add(new Pair(freq[i], (char) (i + 65)));
            }
        }
        int seatId = 1;
        while (!maxHeap.isEmpty()) {
            List<Pair> pulled = new ArrayList<>();
            while (!maxHeap.isEmpty()) {
                Pair topFreq = maxHeap.poll();
                if (seatId >= freeSeat.get(topFreq.ch)) {
                    // decreasing the frequency of the character
                    topFreq.frequency--;
                    // if topFreq element frequency > 0 then again pushing it into maxHeap 
                    if (topFreq.frequency > 0) {
                        maxHeap.add(new Pair(topFreq.frequency, topFreq.ch));
                    }
                    // remapping the freeSeat map to store where the next same character can seat
                    freeSeat.replace(topFreq.ch, seatId + n + 1);
                    // seatId++;
                    break;

                } else {
                    pulled.add(topFreq);
                    // Pair secondTopFreq = maxHeap.poll();
                    // if (maxHeap.isEmpty())
                    //     return 0;
                    // secondTopFreq.frequency--;
                    // if (secondTopFreq.frequency > 0) {
                    //     maxHeap.add(new Pair(secondTopFreq.frequency, secondTopFreq.ch));
                    // }
                    // freeSeat.replace(secondTopFreq.ch, seatId + n + 1);
                    // maxHeap.add(topFreq);
                }
            }
            for (Pair elem : pulled) {
                maxHeap.add(elem);
            }
            seatId++;

        }
        return seatId-1;
    }
}