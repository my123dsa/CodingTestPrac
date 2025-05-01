class Solution {
    int[] dx= {0,0,1,-1};
    int[] dy={1,-1,0,0};
    int[] adx= {1,1,-1,-1};
    int[] ady= {1,-1,1,-1};
    int[] answer = new int[5];
    public int[] solution(String[][] places) {
        //기본 정보 방 5개 각 방은 5*5;
        // 앉은 자리 = P, 빈 자리 = O, 파티션 = X

        //조건 거리2 초과해야함
        //조건 파티션으로 막혀 있으면 노상관
        //직선이면 파티션 1개
        // 대각선이면 파티션 2개
        //즉 P에서 가로세로 2칸내에 p가 또 있는지? -> if(X)는 오케이
        //대각선에서는 +-1,+-1 인 자리에 P가 있는지 대신 if파티션
        for(int i=0;i<5;i++){
            String[] place = places[i];
            char[][] placeArray= new char[5][5];
            for(int j=0;j<5;j++){
                placeArray[j]= place[j].toCharArray();
            }
            answer[i]= func(placeArray)? 1:0;
        }
        return answer;
    }
    public boolean func(char[][] placeArray){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(placeArray[i][j]=='P'){
                    //이게 괜찮은 건지?
                    if(!check(placeArray,i,j)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean check(char[][] placeArray,int x,int y){
        for(int i=0;i<4;i++){
            if(!checkStraight(placeArray,x,y,i)){
                return false;
            }
            if(!checkAcross(placeArray,x,y,i)){
                return false;
            }
            placeArray[x][y]= 'O';
        }
        return true;
    }
    public boolean checkStraight(char[][] placeArray,int x,int y,int i){
        for(int k=1;k<=2;k++){
            int nx=x+dx[i]*k;
            int ny= y+dy[i]*k;
            if(nx>=0 && ny>=0 && nx<5 && ny<5 && placeArray[nx][ny]=='P'){
                if(k==1 || placeArray[x+dx[i]][y+dy[i]]!='X')
                    return false;
            }
        }
        return true;
    }
    public boolean checkAcross(char[][] placeArray,int x,int y,int i){
        int ax= x+adx[i];
        int ay= y+ady[i];
        if(ax>=0 && ay>=0 && ax<5 && ay<5 && placeArray[ax][ay]=='P'){
            if(placeArray[x+adx[i]][y]!='X' || placeArray[x][y+ady[i]] !='X'){
                return false;
            }
        }
        return true;
    }
}