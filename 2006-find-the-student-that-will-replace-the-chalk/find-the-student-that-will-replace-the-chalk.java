class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long chalksNeeded = 0;
        for (int i=0; i<chalk.length; i++) {
            chalksNeeded += chalk[i];
        }
        if (k >= chalksNeeded) {
            k = k % (int) chalksNeeded;
        }
        int i = 0;
        for (i=0; i<chalk.length; i++) {
            if (k < chalk[i])break;
            k -= chalk[i];
        }
        return i;
    }
}