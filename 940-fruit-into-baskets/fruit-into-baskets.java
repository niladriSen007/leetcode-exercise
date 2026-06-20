class Solution {
    public int totalFruit(int[] fruits) {
            int length = fruits.length;
    int left = 0, right = 0;
    int basket = 2;
    int max_fruits = Integer.MIN_VALUE;
    Map<Integer, Integer> map = new HashMap<>();
    while (right < length) {
        map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
        if (map.size() <= basket) {
            max_fruits = Math.max(max_fruits, right - left + 1);
        }
        while (map.size() > basket) {
            map.compute(fruits[left], (key, value) -> value > 1 ? value - 1 : null);
            left++;
        }
        right++;
    }
    return max_fruits;
    }
}