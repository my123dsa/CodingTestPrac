import java.util.*;
class Solution {
    public int solution(int n, int k) {
        //조건1 소수 찾고 , 소수가 0 사이에 있는 거 찾아라
        //조건2 소수에 0이 포함 불가
        int answer=0;
        int[] array = change(n,k);
        int index=0;
        long num=0L;
        while(index<=array.length){
            if(index==array.length ||array[index]==0){
                if(num==0L){
                    index++;
                    continue;
                }
                //이제 소수인지 판별
                boolean isPrime=false;
                for(long i=2;i*i<=num;i+=1){
                    if(num%i==0){
                        isPrime=true;
                        break;
                    }
                }
                if(!isPrime && num !=1){
                    answer++;
                }
                num=0L;index++;
                continue;
            }
            num= num*10 + array[index++];
            // System.out.println(num);
        }
        System.out.println(num);
        return answer;
    }

    public int[] change(int n,int k){
        int[] wlstn =new int[10];
        for(int i=0;i<10;i++){
            wlstn[i]=i;
        }
        int temtpN = n;
        List<Integer> list= new ArrayList<>();
        while(temtpN>0){
            int skajwl =temtpN%k;
            temtpN/=k;
            list.add(wlstn[skajwl]);
        }
        int[] array = new int[list.size()];
        for(int i=0;i<array.length;i++){
            array[i]=list.get(list.size()-1-i);
        }
        return array;
    }
}