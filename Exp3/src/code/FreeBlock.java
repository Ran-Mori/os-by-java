package code;

public class FreeBlock implements Comparable{
    private int start;
    private int length;
    public FreeBlock(){};
    public FreeBlock(int start,int length){
        this.start=start;
        this.length=length;
    }

    @Override
    public int compareTo(Object o) {
        FreeBlock object=(FreeBlock) o;
        if (this.start>object.start)
            return  1;
        else if(this.start<object.start)
            return  -1;
        else return 0;
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

    @Override
    public String toString() {
        return "FreeBlock{" +
                "start=" + start +
                ", length=" + length +
                '}';
    }
}
