class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int p1 = 0;
        int p2 = people.length-1;
        int min = 0;

        while (p1 <= p2) {
            if (people[p1] + people[p2] <= limit) { 
                p2--;
            p1++;
            min++;
            } 
            else if (people[p2] <= limit && p2 >= 0) {
                p2--;
                min++;
            }
        }
        return min;
    }
}