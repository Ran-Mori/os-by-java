package com.zy.test;

import com.zy.code.CPU;
import com.zy.code.Process;
import org.junit.Test;

public class TestClass {

    @Test
    public void CPUTest(){
        Process p1=new Process("P1",10,6);
        Process p2=new Process("P2",10,8);
        Process p3=new Process("P3",10,4);
        Process p4=new Process("P4",10,10);

        CPU cpu=new CPU();
        cpu.addProcess(p1);
        cpu.addProcess(p2);
        cpu.addProcess(p3);
        cpu.addProcess(p4);
        cpu.showString();

        cpu.deletProcess(p3);
        cpu.showString();
    }
    @Test
    public void testSchedule(){
        Process p1=new Process("P1",10,20);
        Process p2=new Process("P2",6,10);
        Process p3=new Process("P3",9,6);
        Process p4=new Process("P4",2,25);

        CPU cpu=new CPU();
        cpu.addProcess(p1);
        cpu.addProcess(p2);
        cpu.addProcess(p3);
        cpu.addProcess(p4);

        cpu.showString();
        while (cpu.getProcesses().size()!=0){
            System.out.println("____________________________________________________________");
            cpu.schedule();
            cpu.showString();
        }
    }

    @Test
    public void testInputUtils(){

    }


}
