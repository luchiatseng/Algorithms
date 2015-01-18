// Compute number of integers divisible by k in range [a..b].

// Write a function: class Solution { public int solution(int A, int
// B, int K); } that, given three integers A, B and K, returns the
// number of integers within the range [A..B] that are divisible by K,
// i.e.: { i : A ≤ i ≤ B, i mod K = 0 }

// For example, for A = 6, B = 11 and K = 2, your function should
// return 3, because there are three numbers divisible by 2 within the
// range [6..11], namely 6, 8 and 10. 

// Assume that: A and B are integers within the range [0..2,000,000,000]
// K is an integer within the range [1..2,000,000,000]
// A ≤ B.

// Time complexity of my solution is O(1).

class Solution {
    public int solution(int A, int B, int K) {
        // If the starting integer A is divisible by K, we can compute 
        // the number of integers in range [A..B] by dividing the 
        // difference of A and B by K, and adding 1
        if (A % K == 0){
            return ((B - A) / K + 1);
        // For the edge case where A is equal to B, given that A (and B)
        // is not divisible by K, return 0
        } else if (A == B){
            return 0;
        // For all other cases, increment A until a value divisible by K
        // is reached, and return the difference of B and i divided by K,
        // and adding 1
        // Note that i<=B can be replaced by i<A+K. I chose i<=B because
        // the same number of iterations is produced, but there's no need
        // to compute A+K
        } else {
            for(int i=A+1; i<=B; i++){
                if(i % K == 0){
                    return ((B - i)/K) + 1;
                }
            }
            // If no value is divisible by K in the range [A..B], return 0
            return 0;
        }
    }
}