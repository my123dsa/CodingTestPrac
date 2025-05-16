import java.util.*;
class Solution {
    List<String> list= new ArrayList<>();
    public int[] solution(String[] operations) {

        for(int i=0;i<operations.length;i++){

            String[] operation = operations[i].split(" ");

            if(operation[0].equals("I")){
                insert(operation[1]);
                continue;
            }

            if(list.size()>0){
                if(operation[1].equals("-1")){
                    deleteMin();
                }
                else{
                    deleteMax();
                }
            }

        }
        int[] answer = {0,0};

        if(list.size()==0){
            return answer;
        }

        answer[0]= Integer.parseInt(list.get(list.size()-1));
        answer[1]= Integer.parseInt(list.get(0));

        return answer;
    }

    void insert(String num){
        for(int i=0;i<list.size();i++){
            String now= list.get(i);
            // if(num<=now){
            if(check(num,now)){
                list.add(i,num);
                return;
            }
        }
        list.add(num);
        return;
    }

    boolean check(String num,String now){
        boolean numResult = num.charAt(0) =='-';
        boolean nowResult = now.charAt(0)=='-';

        if(!numResult && nowResult){
            return false;
        }
        if(numResult && !nowResult){
            return true;
        }

        String newNum=num;
        String newNow=now;
        boolean op= false;

        if(numResult && nowResult){
            // return시 !붙여주자
            newNum= num.substring(1);
            newNow= now.substring(1);
            op=true;
        }


        if(newNum.length()<newNow.length()){
            if(op){
                return false;
            }
            return true;
        }

        else if(newNum.length()>newNow.length()){
            if(op){
                return true;
            }
            return false;
        }

        for(int i=0;i<newNum.length();i++){
            char m =newNum.charAt(i);
            char n = newNow.charAt(i);
            if(m<n){
                if(op){
                    return false;
                }
                return true;
            }
            else if(m>n){
                if(op){
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    void deleteMax(){
        list.remove(list.size()-1);
    }

    void deleteMin(){
        list.remove(0);
    }
}