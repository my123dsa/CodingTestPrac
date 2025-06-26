class Solution {
    int N,M,X,Y,R,C,K;
    int[] dx = {1, 0, 0, -1}; // d, l, r, u
    int[] dy = {0, -1, 1, 0};
    String answer= "impossible";
    char[] ch = {'d','l','r','u'};
    boolean find =false;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N=n;M=m;X=x;Y=y;R=r;C=c;K=k;
        int check = Math.abs(x-r) + Math.abs(y-c);
        if(check>k || (k-check)%2!=0){
            return answer;
        }

        dfs(x,y,"",0);

        return answer;
    }

    void dfs(int x,int y,String path,int depth){
        if(find){
            return;
        }

        if(depth==K){
            if(x==R && y==C){
                answer= path;
                find = true;
            }
            return;
        }

        for(int i=0;i<4;i++){
            int nx= x+dx[i];
            int ny= y+dy[i];

            if(nx<1 || nx>N ||ny<1 ||ny>M)
                continue;

            int remind = K-(depth+1);
            int dis= Math.abs(nx-R)+Math.abs(ny-C);
            if(dis>remind)
                continue;

            dfs(nx,ny,path+ch[i],depth+1);
        }
    }
}