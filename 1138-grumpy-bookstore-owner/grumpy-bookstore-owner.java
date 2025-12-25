class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        // 1 = grumpy, 0 = fine
        int happy = 0;


        for (int i=0; i<customers.length; i++) {
            // if (grumpy[i] == 0)grumpyCount--;
            if (grumpy[i] == 0)happy += customers[i];
        }


        int lo = 0;
        int hi = minutes;

        int winSize = 0; // 2

        for (int i=0; i<minutes; i++) {
            if (i < customers.length && grumpy[i] == 1)winSize += customers[i];
        }
        
        int winMax = 0;

        while (lo < customers.length || hi < customers.length) {
            if (winSize > winMax) {
                winMax = Math.max(winMax, winSize);
            } 
            if (lo < customers.length && grumpy[lo] == 1) {
                winSize = Math.abs(winSize -customers[lo]);
            }
            lo++;
            if (hi < customers.length && grumpy[hi] == 1) {
                winSize = winSize + customers[hi];
            }
            hi++;
            
        }

        return winMax + happy;
    }
}