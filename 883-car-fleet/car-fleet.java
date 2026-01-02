class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int[][] pair = new int[n][2];
        for (int i=0; i<n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
     Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0])); // sorts pair[][] based on pos

     Stack<Double> stack = new Stack<>(); // speed stack

     for (int i=0; i<n; i++) {
        int posi = pair[i][0];
        int spd = pair[i][1];
        int dist = target - posi; // 2/2 = 1, 4/3 = 1.3
        double currTime = (double) dist / spd; // curr element time left to reach


        if (!stack.isEmpty() && currTime > stack.peek()) { // time = 12,3,7,1,1 for sorted pos = [0,3,5,8,10], speed = [1,3,1,4,2], target = 12
        stack.push(currTime);
        }
        
        if (stack.isEmpty())stack.push(currTime);
     }

     return stack.size();
     }
    }

// sorted pos for case 4, pos = [6,8], speed = [3,2], target = 10
// sorted pos = [0,3,5,8,10], speed = [1,3,1,4,2], target = 12
// speed = dist / time
// time = dist / speed


