import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {

        Arrays.sort(people);

        int l= people.length;
        int count=0;
        int minIndex=0;
        int end= l-1;
        int start= 0;

        while(start<=end){
            int max= people[end];
            int size=1;
            while(start<=end){
                if(start==end || size==2){
                    count++;
                    break;
                }
                int min = people[start];
                if(max+min<=limit){
                    max+=min;
                    start++;
                    size++;
                }
                else{
                    count++;
                    break;
                }
            }
            end--;
        }
        return count;
    }
}