package programmers.java.level1.숫자_짝꿍;

import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] x= new int[10];
        int[] y= new int[10];
        for(int i=0;i<X.length();i++){
            int now = X.charAt(i)-'0';
            x[now]++;
        }
        for(int i=0;i<Y.length();i++){
            int now = Y.charAt(i)-'0';
            y[now]++;
        }
        for(int i=9;i>=1;i--){
            if(x[i] !=0 && y[i] !=0){
                int count = Math.min(x[i],y[i]);
                for(int k=0;k<count;k++){
                    sb.append(i);
                }
            }
        }
        // System.out.println(sb.toString());
        String tempt =sb.toString();
        if(tempt.equals("")){
            if(x[0] !=0 && y[0] !=0){
                return "0";
            }
            else if(x[0]==0 || y[0]==0){
                return "-1";
            }
        }
        else{
            int count = Math.min(x[0],y[0]);
            for(int k=0;k<count;k++){
                sb.append(0);
            }
        }

        return sb.toString();

    }
}