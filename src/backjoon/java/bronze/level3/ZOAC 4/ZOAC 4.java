import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H= Integer.parseInt(st.nextToken());
        int W= Integer.parseInt(st.nextToken());
        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());
        int row =(int)Math.ceil((double)W/(1+M));
        int col =(int)Math.ceil((double)H/(1+N));
        System.out.println(row*col);

    }
}
