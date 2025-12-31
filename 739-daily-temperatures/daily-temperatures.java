class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] res = new int[n]; //resultant array

        Stack<int[]> stack = new Stack<>(); // val, index

        for (int i=0; i<n; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]) {
                int[] ans = stack.pop();
                res[ans[1]] = i - ans[1];
            }

            stack.push(new int[]{temperatures[i], i});
        }
        return res;
    }
}

// we use a monotonic stack
// if stack is empty we add the current element i onto the stack since we want to look at the future elements and determine the correct answer for it, we store the value as well as the index so once we find the answer we update it right there without traversing back into the array
// There are two scenarios now, the current element is greather than the one on stack and the current element is smaller than the one on stack
// so if current is greater that simply means the answer for the previous elements is found since all elements on the stack are just smaller than every element 
// we pop the element on stack, and for its index caluclate the result which would simply be distance between current element and the popped elements indices, and then we pop until the element on top of stack is smaller than current element
// and we just add elements onto the stack if our stack is empty or when the current element is even smaller than the one on stack