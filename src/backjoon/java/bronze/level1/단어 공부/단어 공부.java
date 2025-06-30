import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 코드를 작성해주세요
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        // System.out.println(str);
        // str = str.toLowercase(str);
        // System.out.println(str);
        int[] counts = new int[26];
        int max =0;
        int count=0;
        StringBuilder sb = new StringBuilder();
        for(char c : str.toCharArray()){
            // System.out.println(c);
            if(c>='a'){
                int k =c-'a';
                // System.out.println(k);
                counts[k]++;
                max=Math.max(max,counts[k]);
            }
            else{
                int k =c-'A';
                // System.out.println(k);
                counts[k]++;
                max=Math.max(max,counts[k]);
            }
        }
        for(int i=0;i<counts.length;i++){
            if(max==counts[i]){
                sb.append((char)('A'+i));
                count++;
            }
        }
        // System.out.println(Arrays.toString(counts));
        System.out.println(count==1? sb.toString() : '?');
    }
}
