class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int happy = 0;

        for (int i=0; i<customers.length; i++) { // calculates how many customers he can satisfy without ability
            if (grumpy[i] == 0)happy += customers[i];
        }

        int lo = 0; //window start
        int hi = minutes; //window end

        int winVal = 0; //Win value for the static vindow

        for (int i=0; i<minutes; i++) { //calculating winVal for initial window which will be of size -> minutes
            if (grumpy[i] == 1)winVal += customers[i];
        }
        
        int winMax = 0; //largest winVal

        while (lo < customers.length || hi < customers.length) { 
            // if local winVal is larger than winMax
            winMax = Math.max(winMax, winVal);

            // operations of removing or adding value only happens when old man is grumpy
            if (lo < customers.length && grumpy[lo] == 1) { // reduce window from left and remove value
                winVal -= customers[lo];
            }
            lo++; //shrink the window
            if (hi < customers.length && grumpy[hi] == 1) { //add value from right if grandpa is grumpy for that value
                winVal +=customers[hi];
            }
            hi++; //expand the window
            
        }

        return winMax + happy;
    }
}