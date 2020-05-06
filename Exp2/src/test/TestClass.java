package test;

import code.Memory;
import code.MemoryBlock;
import code.MemoryOperator;
import code.Task;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestClass {

    @Test
    public void sortTest(){
        MemoryBlock memoryBlock1=new MemoryBlock(0,10,false);
        MemoryBlock memoryBlock2=new MemoryBlock(40,50,false);
        MemoryBlock memoryBlock3=new MemoryBlock(10,30,false);

        List<MemoryBlock> list=new ArrayList<MemoryBlock>();
        list.add(memoryBlock1);
        list.add(memoryBlock2);
        list.add(memoryBlock3);
        for (MemoryBlock item: list) {
            System.out.println(item);
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");

        Collections.sort(list);
        for (MemoryBlock item: list) {
            System.out.println(item);
        }
    }

    @Test
    public void addTest(){
        Memory memory=new Memory();
        MemoryOperator operator=new MemoryOperator();
        Task task1=new Task(30);
        Task task2=new Task(50);
        Task task3=new Task(5);

        operator.addTask(task1,memory);
        operator.addTask(task2,memory);
        operator.addTask(task3,memory);
        operator.showMemoryDetails(memory);

        operator.deleteTask(task2,memory);
        System.out.println("+++++++++++++++++++++");
        operator.showMemoryDetails(memory);

        operator.deleteTask(task3,memory);
        System.out.println("+++++++++++++++++++++");
        operator.showMemoryDetails(memory);

        operator.deleteTask(task1,memory);
        System.out.println("+++++++++++++++++++++");
        operator.showMemoryDetails(memory);
    }
}
