class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int largest = 0;

        for (int i=0; i<piles.length; i++) {
            largest = Math.max(piles[i], largest);
        }


        // for (int i=1; i<=largest; i++) {
        //     long localHours = 0L;
        //     for (int j=0; j<piles.length; j++) {
        //         int timeTaken = (int)Math.ceil( (double)piles[j] / (double)i);
        //         localHours += timeTaken;
        //         if (localHours <= h && j == piles.length-1)return i;
        //     }
        //     if (localHours > h)continue;
        // }

        int lo = 1;
        int hi = largest;

        int finalAnswer = largest;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; // current eating speed
            long localHours = 0L;

            for (int j=0; j<piles.length; j++) {
                int timeTaken = (int)Math.ceil( (double)piles[j] / (double)mid); // find time taken
                localHours += timeTaken; // add time taken
            }

            if (localHours <= h) {
                hi = mid - 1;
                finalAnswer = Math.min(finalAnswer, mid);
            } else {
                lo = mid + 1;
            }
            
        }

        return finalAnswer;
    }
}

// k can be from 1 to piles[largest]
// if hours are excedded we fail
// we test frin 1 to h and we simulate koko eating banana by assesing how many bananas koka eat and time taken
// piles[i] / k = time taken in hours
// 