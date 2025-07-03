import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 금>은>동
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 찾고픈 값
        List<Country> ranks = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze =  Integer.parseInt(st.nextToken());
            Country  cou = new Country(number,gold,silver,bronze);
            ranks.add(cou);
        }


        Collections.sort(ranks,(a,b)->{
            if(b.gold==a.gold){
                if(b.silver==a.silver){
                    return b.bronze-a.bronze;
                }
                return b.silver-a.silver;
            }
            return b.gold-a.gold;
        });

        // for(int i=0;i<N;i++){
        // Country c = ranks.get(i);
        // System.out.println( c.number+" "+c.gold+" "+c.silver+" "+c.bronze);
        // }

        int rank =1;
        int equal= 0;
        Country before = ranks.get(0);
        before.rank =rank;

        if(before.number == K){
            System.out.println(before.rank);
            return;
        }

        for(int i=1;i<N;i++){
            Country now =ranks.get(i);
            boolean flag= false;
            if(now.gold == before.gold && now.silver== before.silver && now.bronze == before.bronze){
                equal++;
                now.rank= rank;
                flag= true;
            }

            if(!flag){
                rank =  rank+1+equal;
                now.rank = rank;
                equal =0;
                before=now;
            }
            // System.out.println("랭크"+" "+rank);

            if(now.number==K){
                System.out.println(now.rank);
                break;
            }
        }

    }

    static class Country{
        int number;
        int gold;
        int silver;
        int bronze;
        int rank;
        Country(int number,int gold,int silver,int bronze){
            this.number = number;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
}
