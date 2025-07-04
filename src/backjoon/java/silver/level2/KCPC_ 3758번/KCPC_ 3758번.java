import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb= new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int x=0;x<T;x++){
            //1 = 2 ,2 = 꼴찌, 3 1등
            StringTokenizer st= new StringTokenizer(br.readLine());
            int n =  Integer.parseInt(st.nextToken()); //팀의 개수
            int k =  Integer.parseInt(st.nextToken()); //문제 개수
            int t =  Integer.parseInt(st.nextToken()); //팀 id
            int m =  Integer.parseInt(st.nextToken()); //로그 엔트리 개수

            int[][] teamScore = new int[n+1][k+1];
            //0에 총합 넣자
            int[][] sends = new int[n+1][2];


            for(int y=0;y<m;y++){
                st= new StringTokenizer(br.readLine());
                int i =  Integer.parseInt(st.nextToken()); //팀 id
                int j =  Integer.parseInt(st.nextToken()); //문제 번호
                int s =  Integer.parseInt(st.nextToken()); //획득 점수

                sends[i][1]= y;
                sends[i][0]++;

                if(teamScore[i][j]<s){
                    teamScore[i][0]+= s-teamScore[i][j];
                    teamScore[i][j]=s;
                }

            }
            List<int[]> list = new ArrayList<>();
            int[] nx ={1,teamScore[1][0]};
            list.add(nx);
            for(int q=2;q<=n;q++){
                int idx =q;
                int ts = teamScore[q][0];
                int[] nx2= {q,ts};
                list.add(nx2);
            }
            Collections.sort(list,(a,b)->{
                if(b[1]==a[1]){
                    if(sends[b[0]][0]==sends[a[0]][0]){
                        return sends[a[0]][1]-sends[b[0]][1];
                    }
                    return sends[a[0]][0]-sends[b[0]][0];
                }
                return b[1]-a[1];
            });

            for(int q=0;q<list.size();q++){
                if(list.get(q)[0]==t){
                    sb.append(q+1).append('\n');
                    break;
                }
            }

        }
        System.out.println(sb.toString().trim());
    }
}
