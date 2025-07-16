import java.util.*;
import java.io.*;

public class Main {
    static int N,K,max;
    static StringBuilder sb = new StringBuilder();
    static int[] totalValues;
    static List<int[]> products = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //물품 개수
        K = Integer.parseInt(st.nextToken()); //버틸 수 있는 무게
        totalValues = new int[K+1];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken()); // 물품 무게
            int V = Integer.parseInt(st.nextToken()); // 물품 가치

            for(int w=K;w>=W;w--){
                totalValues[w]= Math.max(totalValues[w],totalValues[w-W]+V);
            }
        }
        System.out.println(totalValues[K]);
    }
}
