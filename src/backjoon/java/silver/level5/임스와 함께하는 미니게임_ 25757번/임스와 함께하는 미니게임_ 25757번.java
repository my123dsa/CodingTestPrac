import java.util.*;
import java.io.*;

public class Main {
    static Map<Character, Integer> np = new HashMap<>();
    static Set<String> people = new HashSet<>();


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        np.put('Y', 2);
        np.put('F', 3);
        np.put('O', 4);
        // Y=2 윷 , F=3 같은 그림 찾 , O=4 원카드
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char game = st.nextToken().charAt(0);
        int gp= np.get(game)-1;

        for(int i=0;i<N;i++){
            String person = br.readLine();
            people.add(person);
        }
        int size = people.size();
        System.out.println(size/gp);
    }

}
