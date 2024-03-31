class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));
        int start = 0;
        int end = k-1;
        int count = 0;
        int max = 0;
        for (int i=0; i<k; i++) {
            if (set.contains(s.charAt(i)))count++;
            max = Math.max(max, count);
            if (max == k)return max;
        }

        while (end < s.length()-1 && start < s.length()-k) {
            if (max == k)return max;
            if (set.contains(s.charAt(start)))count--;
            start++;
            end++;
            if (set.contains(s.charAt(end)))count++;
            max = Math.max(max, count);
        }
        return max;
    }
}