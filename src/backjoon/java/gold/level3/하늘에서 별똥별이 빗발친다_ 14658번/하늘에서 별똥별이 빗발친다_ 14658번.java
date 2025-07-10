import java.util.*;
import java.io.*;

public class Main {
    static int N,M,L,K;
    static List<int[]> ss= new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] dx={L,L,-L,-L};
        int[] dy = {L,-L,L,-L};
        int result=Integer.MAX_VALUE;

        for(int k=0; k<K; k++){
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int[] nx= {x,y};
            ss.add(nx);
        }

        int maxCaught = 0;
        for (int i = 0; i < K; i++) {
            int sx = ss.get(i)[0];
            for (int j = 0; j < K; j++) {
                int sy = ss.get(j)[1];
                int cnt = 0;
                for (int[] star : ss) {
                    int x = star[0], y = star[1];
                    if (sx <= x && x <= sx + L &&
                            sy <= y && y <= sy + L) {
                        cnt++;
                    }
                }
                maxCaught = Math.max(maxCaught, cnt);
            }
        }

        System.out.println(K - maxCaught);

    }
}
