class Pair{
    public int frequency;
    public String word;

    public Pair(int frequency,String word){
        this.frequency = frequency;
        this.word = word;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> freq = new HashMap<>();
        for(String word:words){
            freq.put(word,freq.getOrDefault(word,0)+1);
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
            (a,b) -> {
                if(a.frequency != b.frequency) return a.frequency - b.frequency;
                return b.word.compareTo(a.word);
            }
        );
        for(Map.Entry<String,Integer> m:freq.entrySet()){
            minHeap.add(new Pair(m.getValue(),m.getKey()));
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
                for (Pair p : minHeap) {
            System.out.println(p.frequency + " : " + p.word);
        }
        List<String> topK = new ArrayList<>();
        for(int i=0;i<k;i++){
            topK.add(minHeap.poll().word);
        }
        Collections.reverse(topK);
        return topK;
    }
}