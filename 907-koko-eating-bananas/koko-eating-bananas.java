class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0; // max pile can even be 80553579
        for (int i = 0; i<piles.length; i++) { // for loop to get max
            maxPile = Math.max(maxPile, piles[i]);
        }

        int k = 1;
        int lo = 0;
        int hi = maxPile;

        int minSpeedOfKoko = maxPile;

        while (lo <= hi) { // k can vary from 1 to maxPileElement
        int mid = lo + (hi - lo) / 2;
        double totalTimeTaken = 0;

            for (int i=0; i<piles.length; i++) { // calculates time for one/every k
                double timeTaken = Math.ceil((double) piles[i] / (double) mid);
                totalTimeTaken += timeTaken;
            }

            if (totalTimeTaken <= h) { // if k is bigger than minnium time needed then
            hi = mid - 1;
            minSpeedOfKoko = Math.min(minSpeedOfKoko, mid);
            } else if (totalTimeTaken > h) { // speed too slow of eating
            lo = mid + 1;
            }
        }

        return minSpeedOfKoko;
    }
}

// k can be from 1 to piles largest element
// nums[i] / k = time taken
// Math.ceil(2.2); -> 3 Rounds off to +ve infinity 