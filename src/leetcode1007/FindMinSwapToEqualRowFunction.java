package leetcode1007;

public class FindMinSwapToEqualRowFunction {
	// Brute force way to do it, but its fast
	// O(6 * n) = o(n) time
    public int minDominoRotations(int[] A, int[] B) {
        int min = Integer.MAX_VALUE;
        
        // Since a domino is only 1-6
        for(int i = 1; i <= 6; i++){
        	// Find the min for both since we don't know which array is better to pick
            min = Math.min(min, checking(A, B, i));
            min = Math.min(min, checking(B, A, i));
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    private int checking(int[] A, int[] B, int currentDice){
        int numOfSwap = 0;
        
        for(int i = 0; i < A.length; i++){
        	// If its already in A, just go to next element
            if(A[i] == currentDice){
                continue;
            }
            
            // If its not in A or not in B, return the biggest integer as false
            if(B[i] != currentDice){
                return Integer.MAX_VALUE;
            }
            
            numOfSwap++;
        }
        
        return numOfSwap;
    }
    
    // Checking if A or B elements are the same using the first element
    // O(n + n) which is just O(n)
    public int minDominoRotations2(int[] A, int[] B) {
        int n = A.length;
        
        // Pretend A is the row with all equals
        // (A[i] == A[0] || B[i] == A[0]) will make sure we stop the loop if there is no match
        for(int i = 0, a = 0, b = 0; i < n && (A[i] == A[0] || B[i] == A[0]); i++){
            if(A[i] != A[0]){
                a++;
            }
            
            if(B[i] != A[0]){
                b++;
            }
            
            // If i got til the end, just return the min of it
            if(i == n - 1){
                return Math.min(a,b);
            }
        }
        
        // Pretend B is the row with all equals
        for(int i = 0, a = 0, b = 0; i < n && (A[i] == B[0] || B[i] == B[0]); i++){
            if(A[i] != B[0]){
                a++;
            }
            
            if(B[i] != B[0]){
                b++;
            }
            
            if(i == n - 1){
                return Math.min(a,b);
            }
        }
        
        return -1;
    }
    
    // O(n * 6) = O(n) time, need extra memory to store two arrays to keep track
    public int minDominoRotations3(int[] A, int[] B) {
        int[] countA = new int[7];
        int[] countB = new int[7];
        
        // Could make this to an array too, but pointless
        int samePosition = 0;
        
        int totalLength = A.length;
        
        for(int i = 0; i < totalLength; i++){
            countA[A[i]]++;
            countB[B[i]]++;
            
            // Count how many times its at the same position
            if(A[i] == B[i]){
                samePosition++;
            }
        }
        
        // 7 since there is only 6 parts of dice
        for(int i = 1; i < 7; i++){
        	// If it gets add up to the total length
            if(countA[i] + countB[i] - samePosition == totalLength){
            	// return the minimum swap
                return totalLength - Math.max(countA[i],countB[i]);
            }
        }
        
        return -1;
    }
}
