package test;

import code.Disk;
import code.File;
import code.FreeBlock;
import com.sun.xml.internal.fastinfoset.tools.FI_DOM_Or_XML_DOM_SAX_SAXEvent;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestClass {
    @Test
    public void testPrintBitMap(){
        Disk disk=new Disk();
        disk.changeBitmap(3,50,true);
        disk.printBitMap();
    }

    @Test
    public void sortList(){
        FreeBlock file1=new FreeBlock(30,10);
        FreeBlock file2=new FreeBlock(10,5);
        List<FreeBlock> files=new ArrayList<FreeBlock>();
        files.add(file1);
        files.add(file2);
        for (int i=0;i<files.size();i++)
            System.out.println(files.get(i));

        Collections.sort(files);

        for (int i=0;i<files.size();i++)
            System.out.println(files.get(i));
    }
}
