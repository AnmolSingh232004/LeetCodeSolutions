class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int p1 = 0;
        int p2 = people.length-1;
        int min = 0;

        while (p1 <= p2) {
        if (people[p1] + people[p2] == limit) {
            p2--;
            p1++;
            min++;
        } 
        // 2,2,2,6,6,7,10,10,10,11,12,13,18,22,26,33,41,47,49,50
            else if (people[p1] + people[p2] < limit) { 
                int localSum = people[p1] + people[p2];
                if (localSum <= limit && p1 < people.length) {
                    p1++;
                    if (p1 < people.length)localSum += people[p1];
                }
                min++;
                p2--;
            } 
             else if (people[p2] <= limit && p2 >= 0) {
                p2--;
                min++;
            }
        }
        return min;
    }
}