package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Memory {
    private int capacity;
    private List<MemoryBlock> list=new ArrayList<MemoryBlock>();

    public Memory(){
        this.capacity=128;
        MemoryBlock initBlock=new MemoryBlock(0,128,false);
        list.add(initBlock);
    }

    public void sortList(){
        Collections.sort(list);
    }

    public List<MemoryBlock> getList() {
        return list;
    }
}
