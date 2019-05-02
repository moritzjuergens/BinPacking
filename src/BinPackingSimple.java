import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinPackingSimple {

    public static void main(String[] args) {

        int intNumberOfObject, intSizeOfObject, intObjectArray[], intCurrentBin, binSize, intBinCounter;


        List<Integer> intObjectList = new ArrayList<Integer>();

        intObjectList.add(8);
        intObjectList.add(7);
        intObjectList.add(6);
        intObjectList.add(5);
        intObjectList.add(4);
        intObjectList.add(3);
        intObjectList.add(2);
        intObjectList.add(1);

        Iterator<Integer> i = intObjectList.iterator();

        binSize = 10;

        intBinCounter = 1;

        intCurrentBin = 0;

       // intObjectList.stream().forEach(z -);





        /*
        while (i.hasNext()){

            if (binSize < (i.next() + intCurrentBin)) {

                intBinCounter++;
            }else{

               ;

            }
            System.out.println(intBinCounter);
        }
        */




    }

}
