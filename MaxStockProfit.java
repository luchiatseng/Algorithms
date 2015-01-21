// Determine the best time to buy and sell stock, and the maximum profit.

// Write a function: class Solution { public int solution(int[] prices)},
// with prices being the price of a given stock over a period of time, 
// and returns the maximum profit.

// For example, for prices = [2. 3, 7, 8, 11, 5], return  = 8

// The time complexity of my solution is O(n).

class Solution {
    public int solution(int[] prices) {
        
        public int maxProfit(int[] prices){
            
            // Edge cases: If the input array is null or contains less
            // than 2 prices, the profit cannot be computed
            if (prices == null || prices.length < 2){
                return 0;
            }

            int globalMin = Integer.MAX_VALUE;
            int maxProfit = 0;

            // We iterate through the array looking for the globalMin 
            // purchase price. 

            for (int i=0; i<prices.length; i++){
                if (prices[i] < globalMin){
                    globalMin = prices[i];
                }

                // A purchase has to be made before a sale. Therefore, 
                // each iteration, we will calculate the difference 
                // between current value (i) and globalMin, and update 
                // maxProfit as necessary. 
                if (maxProfit < (prices[i] - globalMin)){
                    maxProfit = prices[i] - globalMin;
                }
            }
        }

        return maxProfit;

    }
}