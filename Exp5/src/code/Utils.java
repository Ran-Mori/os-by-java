package code;

import java.util.Scanner;

public class Utils {

    private static Scanner scanner=new Scanner(System.in);
    private static String input;

    private static int[][] twoDimensionResult;
    private static int[] oneDimensionrResult;
    private static int oneDimensionLength;
    private static int twoDimensionLength;

    public static int[][] add(int[][] a,int [][] b){
        oneDimensionLength=a.length;
        twoDimensionLength=a[0].length;
        twoDimensionResult=new int[oneDimensionLength][oneDimensionLength];

        for(int i=0;i<oneDimensionLength;i++)
            for (int j=0;j<twoDimensionLength;j++)
                twoDimensionResult[i][j]=a[i][j]+b[i][j];
        return twoDimensionResult;
    }

    public static int[][] sub(int[][] a,int [][] b){
        oneDimensionLength=a.length;
        twoDimensionLength=a[0].length;
        twoDimensionResult=new int[oneDimensionLength][oneDimensionLength];

        for(int i=0;i<oneDimensionLength;i++)
            for (int j=0;j<twoDimensionLength;j++)
                twoDimensionResult[i][j]=a[i][j]-b[i][j];
        return twoDimensionResult;
    }

    public static int[] add(int[] a,int [] b){
        oneDimensionLength=a.length;
        oneDimensionrResult=new int[oneDimensionLength];
        for(int i=0;i<oneDimensionLength;i++)
            oneDimensionrResult[i]=a[i]+b[i];
        return oneDimensionrResult;
    }

    public static int[] sub(int[] a,int [] b){
        oneDimensionLength=a.length;
        oneDimensionrResult=new int[oneDimensionLength];
        for(int i=0;i<oneDimensionLength;i++)
            oneDimensionrResult[i]=a[i]-b[i];
        return oneDimensionrResult;
    }

    public static void printArray(int[] a){
        System.out.print("{");
        for (int i=0;i<a.length;i++){
            if (i==a.length-1)
                System.out.print(a[i]);
            else
                System.out.print(a[i]+",");
        }

        System.out.print("}");
        System.out.println();
    }

    public static boolean isEnough(int[] a, int[] b){
        for (int i=0;i<a.length;i++){
            if (a[i]-b[i]<0)
                return false;
        }
        return true;
    }

    public static void printArray(int[][] a){
        oneDimensionLength=a.length;
        twoDimensionLength=a[0].length;

        for (int i=0;i<oneDimensionLength;i++){
            for (int j=0;j<twoDimensionLength;j++){
                if (j==twoDimensionLength-1)
                    System.out.print(a[i][j]);
                else
                    System.out.print(a[i][j]+",");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void getInput(){
        input = scanner.next();
    }

    public static int getId(){
        return Integer.parseInt(input.split(":")[0]);
    }
    public static int[] getRequest(){
        int request1 = Integer.parseInt(input.split(":")[1].split(",")[0]);
        int request2 = Integer.parseInt(input.split(":")[1].split(",")[1]);
        int request3 = Integer.parseInt(input.split(":")[1].split(",")[2]);

        return new int[]{request1,request2,request3};
    }
}
