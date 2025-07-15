import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken()); // 가희
        int b = Integer.parseInt(st.nextToken()); // 단비

        // 불가능한 경우
        if (a + b - 1 > N) {
            System.out.println(-1);
            return;
        }

        int[] ans = new int[N];
        //어짜피 사전순이면 모두 1로 시작
        for(int i=0;i<ans.length;i++){
            ans[i]=1;
        }

        // 1) 공통 최댓값의 높이와 위치
        int m = Math.max(a, b);
        int g = (a == 1) ? 0 : N - b;

        ans[g] = m;

        // 최대 높이 에서 -a 후 2부터 시작 (어짜피 1로 전부 초기화 했으니)
        for (int j = 2; j < a; j++) {
            ans[g - a + j] = j;
        }
        //뒤에서 부터 채우기 1,2...
        for (int j = 1; j < b; j++) {
            ans[N - j] = j;
        }

        StringBuilder sb = new StringBuilder();
        for (int h : ans) {
            sb.append(h).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}
