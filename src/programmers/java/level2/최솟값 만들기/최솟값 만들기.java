import java.util.*;
class Solution{
    public int solution(int []A, int []B){
        int max=0;
        int length= B.length-1;

        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<A.length;i++){
            max+=A[i]*B[length-i];
        }
        return max;
    }
}