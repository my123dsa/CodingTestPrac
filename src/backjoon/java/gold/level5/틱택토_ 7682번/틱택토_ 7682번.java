import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder sb = new StringBuilder();

        while (!(line = br.readLine()).equals("end")) {
            char[][] b = new char[3][3];
            int countX = 0, countO = 0, countDot = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char c = line.charAt(i*3 + j);
                    b[i][j] = c;
                    if (c == 'X') countX++;
                    else if (c == 'O') countO++;
                    else countDot++;
                }
            }
            // 수 차 검사
            if (!(countX == countO || countX == countO + 1)) {
                sb.append("invalid\n");
                continue;
            }
            // 승리라인 카운트
            int winX = 0, winO = 0;
            // 3행
            for (int i = 0; i < 3; i++) {
                if (b[i][0] != '.' && b[i][0]==b[i][1] && b[i][1]==b[i][2]) {
                    if (b[i][0]=='X') winX++; else winO++;
                }
            }
            // 3열
            for (int j = 0; j < 3; j++) {
                if (b[0][j] != '.' && b[0][j]==b[1][j] && b[1][j]==b[2][j]) {
                    if (b[0][j]=='X') winX++; else winO++;
                }
            }
            // 왼 ↘ 대각선
            if (b[0][0] != '.' && b[0][0]==b[1][1] && b[1][1]==b[2][2]) {
                if (b[0][0]=='X') winX++; else winO++;
            }
            // 오 ↙ 대각선
            if (b[0][2] != '.' && b[0][2]==b[1][1] && b[1][1]==b[2][0]) {
                if (b[0][2]=='X') winX++; else winO++;
            }

            // 판정
            if (winX > 0 && winO > 0) {
                sb.append("invalid\n");
            } else if (winX > 0) {
                sb.append(countX == countO + 1 ? "valid\n" : "invalid\n");
            } else if (winO > 0) {
                sb.append(countX == countO     ? "valid\n" : "invalid\n");
            } else {
                sb.append(countDot == 0 && countX == countO + 1 ? "valid\n" : "invalid\n");
            }
        }

        System.out.print(sb);
    }
}
