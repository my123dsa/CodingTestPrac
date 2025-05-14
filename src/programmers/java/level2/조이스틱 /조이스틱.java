import java.util.*;
class Solution {
    int[] array;
    int min=99999;
    int length;
    public int solution(String name) {
        //현재 A다
        length= name.length();
        array= new int[length];

        int count=0;
        for(int i=0;i<length;i++){
            int now= name.charAt(i) - 'A';
            int result = check(now);
            array[i]= result;
            count+=result;
        }


        for(int i=0;i<length;i++){
            int x= length-i-1;

            int move=i*2+x;
            int move2 =i*2+1+x;

            int c =function1(i,move);
            int c2= function2(x,move2);

            if(c2==x){
                move2-=x+1;
            }
            move2-=c2;
            min=Math.min(min,move2);

            if(c==x){
                move-=i;
            }
            move-=c;
            min=Math.min(min,move);
        }

        return count+min;
    }

    public int function2(int target,int move){
        int c=0;
        for(int i=target-1;i>=1;i--){
            if(array[i]==0){
                c++;
            }
            else{
                break;
            }
        }
        return c;
    }


    public int function1(int target,int move){
        int c=0;
        for(int i=target+1;i<length;i++){
            if(array[i]==0){
                c++;
            }
            else{
                break;
            }
        }
        return c;
    }

    public int check(int now){
        if(now<=13){
            return now;
        }
        else{
            return (25-now+1);
        }
    }
}