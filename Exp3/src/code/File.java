package code;

public class File {
    private int length;
    private int byteNumber;
    private int magnetNumber;
    private int physicalNumber;
    private int startNumber;

    public File(){}
    public File(int length,int startNumber){
        this.startNumber=startNumber;
        this.length=length;
        this.byteNumber=startNumber/8;
        this.magnetNumber=startNumber%8/4;
        this.physicalNumber=startNumber%8%4/2;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getByteNumber() {
        return byteNumber;
    }

    public void setByteNumber(int byteNumber) {
        this.byteNumber = byteNumber;
    }

    public int getMagnetNumber() {
        return magnetNumber;
    }

    public void setMagnetNumber(int magnetNumber) {
        this.magnetNumber = magnetNumber;
    }

    public int getPhysicalNumber() {
        return physicalNumber;
    }

    public void setPhysicalNumber(int physicalNumber) {
        this.physicalNumber = physicalNumber;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(int startNumber) {
        this.startNumber = startNumber;
    }

    @Override
    public String toString() {
        return "File{" +
                "length=" + length +
                ", byteNumber=" + byteNumber +
                ", magnetNumber=" + magnetNumber +
                ", physicalNumber=" + physicalNumber +
                ", startNumber=" + startNumber +
                '}';
    }
}
