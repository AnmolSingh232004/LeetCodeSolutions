class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int start = 0;
        int end = k-1;
        int count = 0;
        int max = 0;
        for (int i=0; i<k; i++) {
            if (set.contains(s.charAt(i)))count++;
            if (count > max)max = count;
        }

        while (end < s.length()-1 && start < s.length()-k) {
            if (set.contains(s.charAt(start)))count--;
            start++;
            end++;
            if (set.contains(s.charAt(end)))count++;
            if (count > max)max = count;
        }
        return max;
    }
}