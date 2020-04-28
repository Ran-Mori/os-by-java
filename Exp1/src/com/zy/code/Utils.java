package com.zy.code;

import java.util.Scanner;

public class Utils {
    private static Scanner scanner=new Scanner(System.in);

    public static String getInputString(){
        String next = scanner.next();
        return next;
    }

    public static String[] getProcessParam(String inputString){
        return inputString.split(",");
    }

    public static Process getProcess(String[] strings){
        String name=strings[0];
        int runningTime=Integer.valueOf(strings[1]);
        int priority=Integer.valueOf(strings[2]);
        return new Process(name,runningTime,priority);
    }

    public static void printBlankLine(int i){
        for (int j = 1; j <=i ; j++) {
            System.out.println();
        }
    }
}
