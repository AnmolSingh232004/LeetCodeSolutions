class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i=0; i<s.length(); i++) {
            int lo = i;
            int hi = i;

            // if center is for odd palindromes
            while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
                if (res.length() < s.substring(lo, hi+1).length() )res = s.substring(lo, hi+1);
                lo--;
                hi++;
            }
            lo = i;
            hi = i+1;

            // if center is even
            while (lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)) {
                if (res.length() < s.substring(lo, hi+1).length() )res = s.substring(lo, hi+1);
                lo--;
                hi++;
            }
        }
        return res;
    }
}

// How about we consider every single index a possible palindrome, and we expand from center to left and right from it to build the palindrome, how this helps is, if we did smth like, s = "babad", if we did start from [0] and expanded and checked, we would first of all have to check all substring which is already n^2 which is decent but then for checking if its a palindrome or not it would take use  O(n) as well which gives us total tc of O(n^3)
// To fix this how about, for every index we expand from center to outside how this will help is simulatenously when checking for all substrings, we can also check if it is palindrome at the same time since exapnsion happens on edges.

// We will have two types of center, one when center is odd and one where it is even, odd is simple both pointers start at same place and expand, if center is even which means it is a palindrome but smth like this "bb", normal code would think this is wrong since expanding on left with lo would go out of bound and "abb" would also be wrong since we expand from b, bb wont be considered so we can have two cases in other case we can make lo = i, hi = i+1, because since we will be doing a for loop from left to right hi+1 makes sense 