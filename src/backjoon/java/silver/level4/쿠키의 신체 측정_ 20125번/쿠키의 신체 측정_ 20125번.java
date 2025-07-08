import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static int x=0;
    static int y=0;
    static int N=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        boolean head = false;
        for(int i=0;i<N;i++){
            String str= br.readLine();
            char[] chArray= str.toCharArray();
            int count =0;
            int tj=0;
            for(int j=0;j<N;j++){
                int num=0;
                if(chArray[j]=='*'){
                    num=1;
                    count++;
                    tj=j;
                }
                arr[i][j]=num;
            }
            if(count==1 && !head){
                x = i+1;
                y = tj;
                head=true;
            }
        }
        int leftArm = getLeftArm();
        int rightArm = getRightArm();
        int body = getBody();
        int leftLeg =getLeftLeg();
        int rightLeg= getRightLeg();
        x++;
        y++;
        sb.append(x+" ").append(y).append('\n');
        sb.append(leftArm).append(' ').append(rightArm).append(' ').append(body).append(' ').append(leftLeg).append(' ').append(rightLeg);
        System.out.println(sb.toString());
    }
    static int getLeftArm(){
        int count =0;
        for(int i=0;i<y;i++){
            if(arr[x][i]==1){
                count++;
            }
        }
        return count;
    }
    static int getRightArm(){
        int count =0;
        for(int i=y+1;i<N;i++){
            if(arr[x][i]==1){
                count++;
            }
        }
        return count;
    }

    static int getBody(){
        int count =0;
        for(int i=x+1;i<N;i++){
            if(arr[i][y]==1){
                count++;
            }
        }
        return count;
    }
    static int getLeftLeg(){
        int count =0;
        for(int i=x+1;i<N;i++){
            if(arr[i][y-1]==1){
                count++;
            }
        }
        return count;
    }
    static int getRightLeg(){
        int count =0;
        for(int i=x+1;i<N;i++){
            if(arr[i][y+1]==1){
                count++;
            }
        }
        return count;
    }
}
