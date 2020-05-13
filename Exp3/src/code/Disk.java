package code;


import java.util.*;

public class Disk {
    public int count=0;
    private int[][] bitMap=new int[8][8];
    private Map<Integer,File> files=new HashMap<Integer, File>();
    private List<FreeBlock> freeBlocks=new ArrayList<FreeBlock>();

    public Disk(){
        changeBitmap(0,63,false);

        freeBlocks.add(new FreeBlock(0,64));
    }

    public void changeBitmap(int start,int end,boolean isUsed){
        int temp=0;
        if (isUsed)
            temp=1;

        if((end/8-start/8+1)==1){
            for (int i=start%8;i<=end%8;i++)
                this.bitMap[start/8][i]=temp;
        }
        else if((end/8-start/8+1)==2){
            for (int i=start%8;i<8;i++)
                this.bitMap[start/8][i]=temp;
            for (int i=0;i<=end%8;i++)
                this.bitMap[end/8][i]=temp;
        }else {
            for (int i=start%8;i<8;i++)
                this.bitMap[start/8][i]=temp;
            for (int i=start/8+1;i<=end/8-1;i++){
                for (int j=0;j<8;j++)
                    this.bitMap[i][j]=temp;
            }
            for (int i=0;i<=end%8;i++)
                this.bitMap[end/8][i]=temp;

        }
    }

    public boolean askSpace(int length){
        int freeBlockNumber=-1;
        for (int i=0;i<freeBlocks.size();i++)
            if (freeBlocks.get(i).getLength()>=length){
                freeBlockNumber=i;
                break;
            }

        if (freeBlockNumber==-1)
            return false;

        File currentFile=new File(length,freeBlocks.get(freeBlockNumber).getStart());
        if (freeBlocks.get(freeBlockNumber).getLength()==length)
            this.freeBlocks.remove(freeBlockNumber);
        else {
            freeBlocks.get(freeBlockNumber).setStart(freeBlocks.get(freeBlockNumber).getStart()+length);
            freeBlocks.get(freeBlockNumber).setLength(freeBlocks.get(freeBlockNumber).getLength()-length);
        }
        files.put(++count,currentFile);
        changeBitmap(currentFile.getStartNumber(),currentFile.getStartNumber()+currentFile.getLength()-1,true);
        return true;
    }

    public boolean freeSpace(int fileNumber){
        if (fileNumber>count)
            return false;

        File currentFile=files.get(fileNumber);
        changeBitmap(currentFile.getStartNumber(),currentFile.getStartNumber()+currentFile.getLength()-1,false);
        FreeBlock currentBlock=new FreeBlock(currentFile.getStartNumber(),currentFile.getLength());
        files.remove(fileNumber);
        freeBlocks.add(currentBlock);
        Collections.sort(freeBlocks);
        int currentIndex=freeBlocks.indexOf(currentBlock);
        try {
            FreeBlock formerBlock=freeBlocks.get(currentIndex-1);
            blockMerge(currentBlock,formerBlock);
        }catch (Exception e){}
        try {
            FreeBlock latterBlock=freeBlocks.get(currentIndex+1);
            blockMerge(currentBlock,latterBlock);
        }catch (Exception e){}
        return true;
    }

    public void blockMerge(FreeBlock mainBlock,FreeBlock byBlock){
        if (mainBlock.getStart()==byBlock.getStart()+byBlock.getLength()){
            mainBlock.setStart(mainBlock.getStart()-byBlock.getLength());
            mainBlock.setLength(mainBlock.getLength()+byBlock.getLength());
            freeBlocks.remove(byBlock);
        }
        if (mainBlock.getStart()+mainBlock.getLength()==byBlock.getStart()){
            mainBlock.setLength(mainBlock.getLength()+byBlock.getLength());
            freeBlocks.remove(byBlock);
        }
    }

    public void printBitMap(){
        System.out.println("磁盘当前位示图如下");
        for (int i=0;i<bitMap.length;i++){
            for (int j=0;j<bitMap[0].length;j++){
                if (j==bitMap[0].length-1)
                    System.out.print(bitMap[i][j]);
                else
                    System.out.print(bitMap[i][j]+",");
            }
            System.out.println();
        }

        System.out.println();
    }

    public void printMap(){
        Set<Integer> integers = files.keySet();
        for (Integer integer:integers) {
            System.out.println("文件序列号--"+integer+",文件大小--"+files.get(integer).getLength());
        }
    }
}
