import java.util.*;
class Solution {
    class Item{
        int num;
        int index;
        public Item(int num,int index){
            this.num=num;
            this.index=index;
        }
    }
    public String solution(String number, int k) {
        StringBuffer sb = new StringBuffer();
        Stack<Item> stack = new Stack<>();
        Item first= new Item(number.charAt(0)-'0',0);
        Map<Integer,Integer> map = new HashMap<>();
        // stack.push(first);
        int index=0;
        boolean flag=true;
        while(flag && index<number.length()){
            int num = number.charAt(index) -'0';

            while(flag &&!stack.isEmpty()){
                if(num>stack.peek().num){
                    Item si =stack.pop();
                    // list.add(si);
                    map.put(si.index,1);
                    k--;
                    if(k==0){
                        flag= false;
                        break;
                    }
                }
                else{
                    break;
                }
            }
            Item newItem = new Item(num,index);
            index++;
            stack.push(newItem);
        }
        if(flag){
            map.put(number.length()-1,1);
        }

        for(int i=0;i<number.length();i++){
            if(map.containsKey(i)){
                continue;
            }
            sb.append(number.charAt(i));
        }
        return sb.toString();
    }
}
