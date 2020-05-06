package code;

import java.util.List;

public class MemoryOperator {
    private List<MemoryBlock> list;
    private MemoryBlock block;

    public boolean addTask(Task task,Memory memory){
        this.list=memory.getList();

        for (int i=0;i<list.size();i++){
            if(list.get(i).isUsed()||list.get(i).getLength()<task.getMemorySize())
                continue;
            this.block=list.get(i);
            break;
        }

        if (this.block==null)
            return false;

        if(this.block.getLength()==task.getMemorySize()){
            this.block.setUsed(true);
            return true;
        }

        int newStart=block.getStart()+task.getMemorySize();
        int newLength=block.getLength()-task.getMemorySize();
        MemoryBlock newMemoryBlock=new MemoryBlock(newStart,newLength,false);

        block.setLength(task.getMemorySize());
        block.setUsed(true);
        block.setTask(task);
        block.setEnd();

        list.add(newMemoryBlock);
        memory.sortList();
        return true;
    }

    public boolean deleteTask(Task task,Memory memory){
        this.list=memory.getList();
        for (MemoryBlock memoryBlock:memory.getList()) {
            if (memoryBlock.getTask()==task){
                this.block=memoryBlock;
                break;
            }
        }

        if (block==null)
            return false;

        block.setUsed(false);
        int index=list.indexOf(block);
        try {
            memoryBolockMerge(block,list.get(index+1),memory);
        }catch (Exception e){}
        try {
            memoryBolockMerge(block,list.get(index-1),memory);
        }catch (Exception e){}
        return true;
    }

    public boolean memoryBolockMerge(MemoryBlock mainBlock,MemoryBlock mergeBlock,Memory memory){
        if(mergeBlock.isUsed()||mergeBlock==null)
            return false;
        else {
            if(mainBlock.getStart()>=mergeBlock.getStart())
                mainBlock.setStart(mainBlock.getStart()-mergeBlock.getLength());
            mainBlock.setLength(mainBlock.getLength()+mergeBlock.getLength());
            memory.getList().remove(mergeBlock);
            mainBlock.setEnd();
            return true;
        }
    }

    public void showMemoryDetails(Memory memory){
        for (MemoryBlock item:memory.getList()) {
            System.out.println(item);
        }
    }
}
