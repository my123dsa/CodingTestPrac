import java.util.*;
class Solution {
    public int solution(int n) {
        int oneCount = countOnes(n);

        int next = n + 1;
        while (true) {
            if (countOnes(next) == oneCount) {
                return next;
            }
            next++;
        }
    }

    private int countOnes(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                count++;
            }
            num /= 2;
        }
        return count;
    }
}