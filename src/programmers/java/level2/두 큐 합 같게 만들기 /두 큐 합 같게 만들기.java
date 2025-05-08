class Solution {
    long sumQueue1=0;
    long sumQueue2=0;

    public int solution(int[] queue1, int[] queue2) {
        int len = queue1.length;
        for(int i=0;i<len;i++){
            sumQueue1+= queue1[i];
            sumQueue2+= queue2[i];
        }
        int count=0;
        int index1=0;
        int index2=0;
        while(true){

            if(count>len*3){
                return -1;
            }

            if(sumQueue1 == sumQueue2){
                break;
            }
            else if(sumQueue1<sumQueue2){
                if(index2<len){
                    sumQueue2-=queue2[index2];
                    sumQueue1+=queue2[index2];
                }
                else{
                    sumQueue2-=queue1[index2-len];
                    sumQueue1+=queue1[index2-len];
                }
                index2++;
            }
            else{
                if(index1<len){
                    sumQueue1-=queue1[index1];
                    sumQueue2+=queue1[index1];
                }
                else{
                    sumQueue1-=queue2[index1-len];
                    sumQueue2+=queue2[index1-len];
                }
                index1++;
            }
            count++;
        }
        return count;
    }
}
