package main;

import code.Disk;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Disk disk=new Disk();
        Scanner scanner=new Scanner(System.in);
        loop:while (true){
            System.out.println("请输入你要进行的操作。1-申请 2-释放 3-退出");
            int i=scanner.nextInt();
            switch (i){
                case 1:
                    System.out.println("请输入你想申请的内存空间大小。");
                    disk.askSpace(scanner.nextInt());
                    disk.printBitMap();
                    break;
                case 2:
                    System.out.println("请输入你想释放的文件序号");
                    disk.printMap();
                    disk.freeSpace(scanner.nextInt());
                    disk.printBitMap();
                    break;
                case 3:
                    break loop;
            }
        }
    }
}
