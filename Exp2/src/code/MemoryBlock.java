package code;

public class MemoryBlock implements Comparable{
    private int start;
    private int end;
    private int length;
    private Task task;
    private boolean isUsed;

    public MemoryBlock(int start, int length, boolean isUsed) {
        this.start = start;
        this.length = length;
        this.end=start+length-1;
        this.isUsed = isUsed;
    }

    public MemoryBlock() {
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd() {
        this.end = this.start+this.length-1;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public int compareTo(Object o) {
        MemoryBlock memoryBlock=(MemoryBlock)o;
        if (this.start>memoryBlock.start)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        if(this.isUsed)
            return "MemoryBlock{" +
                    "start=" + start +
                    ", end=" + end +
                    ", length=" + length +
                    ", status=" + "占用" +
                    '}';
        else
            return "MemoryBlock{" +
                    "start=" + start +
                    ", end=" + end +
                    ", length=" + length +
                    ", status=" + "空闲" +
                    '}';
    }
}
