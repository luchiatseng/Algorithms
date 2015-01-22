// Return the index of target value in a rotated sorted array

// Write a function: class Solution { public int solution(
// int[] A, int target) }, with A being a sorted array that is
// rotated at some unknown pivot (i.e., 0 1 2 4 5 6 7 might 
// become 4 5 6 7 0 1 2), which returns the index of the target

// For example, for A = [5, 6, 7, 0, 1, 2] and target = 2, 
// return 5

// The time complexity of my solution is O(log(n)). However,
// it does not handle input arrays containing many duplicated 
// values well

class Solution {
    public int solution(int[] A, int target) {
        
        // We will use a modified version of binary search to 
        // find the target value in the rotated array. 
        int leftIndex = 0;
        int rightIndex = A.length - 1;

        while (leftIndex <= rightIndex){

            int midIndex = (leftIndex + rightIndex)/2;
            
            // Use a switch statement to check if target is one 
            // of left-, mid- or right-Index values
            switch(target){
                case A[leftIndex] :
                    return leftIndex;
                case A[midIndex] :
                    return midIndex;
                case A[rightIndex] :
                    return rightIndex;
            }

            // If the value at leftIndex is smaller than the
            // value at midIndex, we know the in-between 
            // values are in increasing order and does not 
            // contain the pivot point
            if (A[leftIndex] < A[midIndex]){

                // If the target value is between A[leftIndex]
                // and A[midIndex], discard the other hald of
                // the array
                if (A[leftIndex] < target && target < A[midIndex]){
                    leftIndex++;
                    rightIndex = midIndex - 1;

                // Else, discard A[leftIndex] to A[midIndex]
                } else {
                    leftIndex = midIndex + 1;
                    rightIndex--;
                }

            // Else, the pivot point is between A[leftIndex]
            // and A[midIndex], and the values in-between
            // A[midIndex] and A[rightIndex] are in increasing
            // order
            } else {

                // If target is between A[midIndex] and 
                // A[rightIndex], discard A[leftIndex] to 
                // A[midIndex]
                if (A[midIndex] < target && target < A[rightIndex]){
                    leftIndex = midIndex + 1;
                    rightIndex--;
                
                // Else, discard A[midIndex] to A[rightIndex]
                } else {
                    leftIndex++;
                    rightIndex = midIndex - 1;
                }
            }
        }

        // If the value is not found, return -1
        return -1;
        
    }
}