class Solution {
    int count=0;
    int width= 0;

    public int solution(int n, int[] stations, int w) {
        // 검사해야하는 수가 2억이다.
        // 오름차순으로 정렬
        //
        // 너비는 1+ 2*w
        width = w*2+1;

        init(stations[0]-w);

        for(int i=1;i<stations.length;i++){
            int before= stations[i-1]+w;
            int station = stations[i];
            //여기서 +-w
            //각각 커버하는 최소, 최대
            int minStation= station-w;
            int maxStation = station+w;

            // System.out.println("체크"+minStation+" "+maxStation);
            //이전의 커버하는 최소값 - 최대값

            if(before>=minStation || minStation==before+1){
                continue;

            }
            // System.out.println((before+1)+" "+minStation);

            int need= (minStation-before-1)/width;
            int skajwl=(minStation-before-1)%width;

            count+=need;
            if(skajwl!=0){
                count++;
            }
        }

        last(n,stations[stations.length-1]+w);

        return count;
    }

    public void init(int min){
        if(1<min){
            int need= (min-1)/width;
            int skajwl=(min-1)%width;

            count+=need;
            if(skajwl!=0){
                count++;
            }
        }
    }

    public void last(int n,int last){

        if(n<=last)
            return;
        // System.out.println(last+" "+n);

        int need= (n-last)/width;
        int skajwl=(n-last)%width;

        count+=need;
        if(skajwl!=0){
            count++;
        }
    }
}