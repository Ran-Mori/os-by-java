package code;

public class BankerAlgorithm {
    private int[] available=new int[]{1,1,2};
    int[][] max=new int[][]{
            {3,2,2},
            {6,1,3},
            {3,1,4},
            {4,2,2}
    };
    private int[][] allocation=new int[][]{
            {1,0,0},
            {5,1,1},
            {2,1,1},
            {0,0,2}
    };
    private int[][] need=new int[][]{
            {2,2,2},
            {1,0,2},
            {1,0,3},
            {4,2,0}
    };
    private int[] work=new int[3];
    boolean[] finish=new boolean[4];

    public BankerAlgorithm(){}

    public boolean askForResources(int id, int[] request){
        for (int i=0;i<3;i++){
            if (request[i]>need[id-1][i]){
                System.out.println("进程"+id+"所需要资源数目超过它所宣布的最大值");
                return false;
            }
        }


        for(int i=0;i<3;i++){
            if (request[i]>available[i]){
                System.out.println("系统中尚无足够的资源满足进程"+id+"的申请，进程"+id+"必须等待");
                return false;
            }
        }

        available=Utils.sub(available,request);
        allocation[id-1]=Utils.add(allocation[id-1],request);
        need[id-1]=Utils.sub(need[id-1],request);

        if (isSafe())
            return true;
        else {
            available=Utils.add(available,request);
            available=Utils.add(available,request);
            allocation[id-1]=Utils.sub(allocation[id-1],request);
            allocation[id-1]=Utils.sub(allocation[id-1],request);
            need[id-1]=Utils.add(need[id-1],request);
            need[id-1]=Utils.add(need[id-1],request);
            return false;
        }
    }

    public boolean isSafe(){
        for(int i=0;i<3;i++){
            work[i]=available[i];
        }
        for (int i=0;i<4;i++){
            finish[i]=false;
        }

        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){
                if (!finish[j]&&Utils.isEnough(work,need[j])){
                    work=Utils.add(work,allocation[j]);
                    finish[j]=true;
                }
            }
        }

        boolean flag=true;
        for (int i=0;i<4;i++)
            flag=flag&&finish[i];
        return flag;
    }

    public int[] getAvailable() {
        return available;
    }

    public int[][] getMax() {
        return max;
    }

    public int[][] getAllocation() {
        return allocation;
    }

    public int[][] getNeed() {
        return need;
    }
}
