package com.zy.main;

import com.zy.code.CPU;
import com.zy.code.Utils;
import com.zy.code.Process;

import java.util.HashMap;
import java.util.Map;


public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        Map<Integer,Process> processes=new HashMap<Integer, Process>();

        for (int i = 1; i <=5 ; i++) {
            System.out.println("请输入第"+i+"个进程的名字，运行时间，优先度。以英文逗号隔开，回车结束");
            String inputString = Utils.getInputString();
            String[] processParam = Utils.getProcessParam(inputString);
            processes.put(i, Utils.getProcess(processParam));
        }

        CPU cpu=new CPU();
        for (int i = 1; i <=5 ; i++) {
            cpu.addProcess(processes.get(i));
        }

        System.out.println("初始就绪队列如下");
        cpu.showString();
        System.out.println("____________________________________________________________");
        Utils.printBlankLine(3);
        int count=0;
        while (cpu.getProcesses().size()!=0){
            Thread.sleep(5000);
            cpu.schedule();
            if (cpu.getProcesses().size()>0){
                System.out.println("正在进行第"+(++count)+"次调度");
                System.out.println("此时正在运行的进程如下：");
                cpu.getProcesses().get(0).printString();
            }
            if (cpu.getProcesses().size()>1){
                System.out.println("此时正在就绪队列的进程如下：");
                for (int i = 1; i <cpu.getProcesses().size() ; i++) {
                    cpu.getProcesses().get(i).printString();
                }
            }
            System.out.println("____________________________________________________________");
            Utils.printBlankLine(3);
        }
    }
}
