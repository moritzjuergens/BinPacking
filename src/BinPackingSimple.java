import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinPackingSimple {

    public static void main(String[] args) {

        int intNumberOfObject, intSizeOfObject,intObjectArray[],intCurrentBin,intSizeOfBin,intBinCounter;

        List<Integer> intObjectList = new ArrayList<Integer>();

        intObjectList.add(8);
        intObjectList.add(7);
        intObjectList.add(6);
        intObjectList.add(5);
        intObjectList.add(4);
        intObjectList.add(3);
        intObjectList.add(2);
        intObjectList.add(1);

        intCurrentBin = 0;

        intBinCounter = 1;
        intSizeOfBin = 10;

        Iterator<Integer> i = intObjectList.iterator();

        while(i.hasNext()){

            if(i.next()+intCurrentBin<intSizeOfBin) {
                intCurrentBin = i.next()+intCurrentBin;
                System.out.println(i);
                System.out.println(intCurrentBin);
            }

        }

    }

}
