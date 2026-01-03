class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for (int i=0; i<piles.length; i++) {
            maxPile = Math.max(maxPile, piles[i]);
        }

        int lo = 1;
        int hi = maxPile;

        int res = maxPile;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; // k = mid
            
            long totalTimeTaken = 0L;

        for (int i=0; i<piles.length; i++) { // calc if mid is able to eat bannana in time or not
            long timeTaken = (long) Math.ceil( (double) piles[i] / (double) mid);

            totalTimeTaken += timeTaken;  // 2.2, 0.9, 2.1, 0.3  || 
        }
        if (totalTimeTaken > h) { // not enough speed of eating this means we need a bigger value than mid 
        lo = mid + 1;
        } else if (totalTimeTaken <= h) { // ate in enough time
        res = (int) Math.min(res, mid);
        hi = mid - 1;
        }

        
        }

        return res;
    }
}

// Input: piles = [25,10,23,4], h = 4

// Output: 25

// [1,2,3,4,5,6,7,8,9,10,11] mid = 6