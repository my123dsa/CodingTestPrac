import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static char[] array;
    static Map<Integer,List<Integer>> map = new HashMap<>();
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // K 거리에 있는거 까지 먹을 수 있음
        // 대신 모두가 N이 먹어야해
        String str = br.readLine();
        Set<Integer> set= new HashSet<>();
        int len  = str.length();

        for(int i=0;i<len;i++){
            if(str.charAt(i)=='P'){
                for(int j=i-K;j<=i+K;j++){
                    if(j<0 || j>=len){
                        continue;
                    }
                    char ch =str.charAt(j);
                    if(ch=='H' && !set.contains(j)){
                        set.add(j);
                        max++;
                        break;
                    }
                }
            }

        }

        System.out.println(max);
    }
}
