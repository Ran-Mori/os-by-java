package main;

import code.Memory;
import code.MemoryBlock;
import code.MemoryOperator;
import code.Task;

import java.util.*;

public class mainMethod {
    public static void main(String[] args) {
        List<Task> tasks=new ArrayList<Task>();
        Memory memory=new Memory();
        MemoryOperator operator=new MemoryOperator();
        Scanner scanner=new Scanner(System.in);

        loop:while (true){
            System.out.println("请选择你要进行的操作：1-申请内存空间，2-释放内存空间，3-退出");
            scanner=new Scanner(System.in);
            int inputNumber = scanner.nextInt();

            int input;
            switch (inputNumber){
                case 1:
                    System.out.println("请输入想申请的内存大小");
                    input=scanner.nextInt();
                    Task task=new Task(input);
                    tasks.add(task);
                    operator.addTask(task,memory);
                    operator.showMemoryDetails(memory);
                    System.out.println("______________________________________________________________________");
                    break;
                case 2:
                    System.out.println("请输入你想释放的内存区域的起始地址大小");
                    input=scanner.nextInt();
                    Task task1=null;
                    for (MemoryBlock item:memory.getList()) {
                        if(item.getStart()==input){
                            task1=item.getTask();
                            break;
                        }
                    }
                    operator.deleteTask(task1,memory);
                    operator.showMemoryDetails(memory);
                    System.out.println("______________________________________________________________________");
                    break;
                case 3:
                    break loop;
            }
        }
    }
}
