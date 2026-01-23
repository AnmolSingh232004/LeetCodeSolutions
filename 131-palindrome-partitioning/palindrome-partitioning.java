class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(String s, int start, List<String> list) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        // for loop gives us, a | aa | aab  
        for (int end=start+1; end <= s.length(); end++) {
            if (isPalin(s, start, end-1)) { // simple check for current string
            // we just add all possible partitons if in any case any fails we dont continue that partition
                list.add(s.substring(start, end));
                backtrack(s, end, list); 
                list.remove(list.size() - 1); // backtrack
            }
        }
    }

    public boolean isPalin(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(hi) != s.charAt(lo))return false;
            lo++;
            hi--;
        }
        return true;
    }
}

// we can make all possible partitons and if in any case a partiton is not valid, we dont go in that branc
// if a branch manages to reach s.length() it means it has a valid partion where all string are palindromes
// we can maintain a local list which will host all valid palindromes
// our input for inital backtracking isnt just the whole string s
// but all contigous sub strings. ex : aab | a | aa | aab