package main;

import code.BankerAlgorithm;
import code.Utils;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        BankerAlgorithm bankerAlgorithm=new BankerAlgorithm();
        boolean isAllowed=false;

//        System.out.println("银行家算法示例开始");
//        Thread.sleep(2000);
//
//        System.out.println("To时刻max数组为：");
//        Utils.printArray(bankerAlgorithm.getMax());
//        Thread.sleep(2000);
//
//        System.out.println("To时刻allocation数组为：");
//        Utils.printArray(bankerAlgorithm.getAllocation());
//        Thread.sleep(2000);
//
//        System.out.println("To时刻need数组为：");
//        Utils.printArray(bankerAlgorithm.getNeed());
//        Thread.sleep(2000);

        System.out.println("请输入发出资源请求的进程id以及需要申请的资源数目。进程与资源间以冒号隔开，资源间以逗号隔开。如2:1,0,1");
        Utils.getInput();
        isAllowed = bankerAlgorithm.askForResources(Utils.getId(), Utils.getRequest());
        if(isAllowed)
            System.out.println("已分配本次请求");
        else
            System.out.println("已拒绝本次请求");
        Thread.sleep(3000);

        System.out.println("请输入发出资源请求的进程id以及需要申请的资源数目。进程与资源间以冒号隔开，资源间以逗号隔开。如1:1,0,1");
        Utils.getInput();
        isAllowed = bankerAlgorithm.askForResources(Utils.getId(), Utils.getRequest());
        if(isAllowed)
            System.out.println("已分配本次请求");
        else
            System.out.println("已拒绝本次请求");
        Thread.sleep(3000);

        System.out.println("请输入发出资源请求的进程id以及需要申请的资源数目。进程与资源间以冒号隔开，资源间以逗号隔开。如3:0,0,1");
        Utils.getInput();
        isAllowed = bankerAlgorithm.askForResources(Utils.getId(), Utils.getRequest());
        if(isAllowed)
            System.out.println("已分配本次请求");
        else
            System.out.println("已拒绝本次请求");
        Thread.sleep(3000);
    }
}
