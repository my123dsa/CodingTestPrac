import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] ranks = new int[N][2];


        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()); //몸무게
            int y = Integer.parseInt(st.nextToken()); // 키

            //모두 크면 ++
            //각각 1개씩 있으면 동일
            ranks[i][0]= x;
            ranks[i][1]= y;
        }

        for (int i = 0; i < N; i++) {
            int rank = 1;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (ranks[j][0] > ranks[i][0] && ranks[j][1] > ranks[i][1]) {
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}
