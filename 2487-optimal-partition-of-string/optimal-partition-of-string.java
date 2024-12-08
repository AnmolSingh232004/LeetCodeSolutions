class Solution {
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();

        int res = 0;

        for (int i=0; i<s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set = new HashSet<>();
                res++;
            } 
                set.add(s.charAt(i));
        }
        return res + 1;
    }
}