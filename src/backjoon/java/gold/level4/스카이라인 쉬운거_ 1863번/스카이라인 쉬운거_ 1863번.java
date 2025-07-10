import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();
    static List<int[]> list=  new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int[] xy= {x,y};
            list.add(xy);
        }

        Collections.sort(list,(a,b)->{
            return b[0]-a[0];
        });

        Stack<int[]> stack = new Stack();
        int count =0;
        for(int i=0;i<list.size();i++){
            int[] now = list.get(i);
            while(!stack.isEmpty() && stack.peek()[1]> now[1]){
                count++;
                int[] pop = stack.pop();
                // System.out.println(Arrays.toString(pop));
            }
            if(!stack.isEmpty() && stack.peek()[1]==now[1]){
                continue;
            }
            stack.add(now);
        }
        while(!stack.isEmpty()){
            // count++;
            int[] pop =stack.pop();
            if(pop[1]!=0){
                count++;
            }
        }
        System.out.println(count);
    }
}
