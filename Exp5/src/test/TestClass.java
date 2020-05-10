package test;

import code.Utils;
import org.junit.Test;


public class TestClass {

    @Test
    public void testUtils(){
        System.out.println("测试一维数组");
        int[] a=new int[]{1,1,1};
        int[] b=new int[]{2,2,2};

        int[] add = Utils.add(a, b);
        Utils.printArray(add);

        System.out.println("测试二维数组");
        int[][] c=new int[][]{
                {1,1,1},
                {1,1,1},
                {1,1,1}
        };
        int[][] d=new int[][]{
                {2,2,2},
                {2,2,2},
                {2,2,2}
        };
        Utils.printArray(Utils.sub(d,c));
    }


}
