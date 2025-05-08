import java.util.*;
class Solution {
    char[] ch= {'*','+','-'};
    String ex;
    List<String> list;
    long Max_value = 0;
    public long solution(String expression) {
        list = new ArrayList<>();
        int index=0;
        String text= "";
        while(index<expression.length()){
            char a= expression.charAt(index);
            if(a>='0' && a<='9'){
                text+=a;
            }
            else{
                list.add(text);
                list.add(a+"");
                text="";
            }
            index++;
        }
        list.add(text);

        ex =expression;
        // System.out.println(list);
        boolean[] b = new boolean[3];
        dfs(new char[3],0,b);
        long answer = 0;
        return Max_value;
    }
    public void dfs(char[] chs,int level,boolean[] b){
        if(level==3){
            function(chs);
            return;
        }
        for(int i=0;i<ch.length;i++){
            if(!b[i]){
                chs[level]=ch[i];
                b[i]=true;
                dfs(chs,level+1,b);
                b[i]= false;
            }
        }
    }
    public void function(char[] chs){

        Deque<String> deque  = new ArrayDeque<>();

        for(int i=0;i<list.size();i++){
            deque.add(list.get(i));
        }

        int size =deque.size();

        for(int i=0;i<chs.length;i++){
            String check = chs[i]+"";
            int index=0;
            while(index<size){
                String now =deque.poll();
                if(!now.equals(check)){
                    deque.add(now);
                }
                else{
                    String s1= deque.pollLast();
                    String s2= deque.poll();
                    long be=  Long.parseLong(s2);
                    long fr = Long.parseLong(s1);
                    long result =calu(check,be,fr);
                    deque.add(String.valueOf(result));
                    size-=2;
                    index--;

                }
                index++;
            }
        }

        long value = Long.parseLong(deque.poll());
        System.out.println(value);
        if(value<0){
            value *=-1;
        }
        Max_value = Math.max(Max_value,value);
    }

    public long calu(String check, long be,long fr){
        if(check.equals("*")){
            return be* fr;
        }
        if(check.equals("+")){
            return be+fr;
        }
        return fr-be;
    }
}