class Solution {
    public int fib(int n) {
        if (n == 0)return 0;
        if (n == 1)return 1;

        return fib(n-1) + fib(n-2);
    }
}

// f 0 = 0
// f 1 = 1
// f 2 = f1 + f0 = 1
// f 3 = f2 + 1 = 2
// f 4 = f2 + f3 = 1+2 = 3