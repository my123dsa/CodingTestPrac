class Solution {
    public int solution(int n, long l, long r) {
        return (int)(countOnes(n, l - 1, r - 1, 0, (long)Math.pow(5, n)));
    }

    // 재귀적으로 구간 [l, r] 내 1의 개수를 센다
    public long countOnes(int depth, long l, long r, long start, long end) {
        if (r < start || l >= end) return 0; // 범위 벗어남
        if (depth == 0) return 1; // 레벨 0이면 항상 1
        long size = (end - start) / 5;
        long result = 0;
        for (int i = 0; i < 5; i++) {
            long segStart = start + i * size; //0
            long segEnd = segStart + size;   //5
            if (i == 2) continue; // 가운데는 항상 0
            result += countOnes(depth - 1, l, r, segStart, segEnd);
        }
        return result;
    }
}