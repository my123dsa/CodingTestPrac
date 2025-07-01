import java.util.*;
import java.io.*;

public class Main {
    static Set<Integer> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();

        int M = Integer.parseInt(br.readLine());


        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if("empty".equals(op)){
                empty();
            }
            else if("all".equals(op)){
                all();
            }
            else if("add".equals(op)){
                add(Integer.parseInt(st.nextToken()));
            }
            else if("remove".equals(op)){
                remove(Integer.parseInt(st.nextToken()));
            }
            else if("check".equals(op)){
                check(Integer.parseInt(st.nextToken()));
            }
            else if("toggle".equals(op)){
                toggle(Integer.parseInt(st.nextToken()));
            }

        }
        System.out.println(sb.toString());
    }

    static void add(int num){
        if(!set.contains(num)){
            set.add(num);
        }
    }

    static void remove(int num){
        if(set.contains(num)){
            set.remove(num);
        }
    }

    static void check(int num){
        if(set.contains(num)){
            sb.append(1).append('\n');
            return;
        }
        sb.append(0).append('\n');
    }

    static void toggle(int num){
        if(set.contains(num)){
            set.remove(num);
            return;
        }
        set.add(num);
    }

    static void all(){
        for(int i=1;i<=20;i++){
            set.add(i);
        }
    }

    static void empty(){
        set= new HashSet<>();
    }
}
