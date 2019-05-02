import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MauriceSuperDuperKaka {

    public static void main(String[] args) {

        List<Integer> elements = new ArrayList<Integer>();
        List<Bin> bins = new ArrayList<Bin>();

        elements.add(3);
        elements.add(2);
        elements.add(3);
        elements.add(4);
        elements.add(9);
        elements.add(5);
        elements.add(7);
        elements.add(2);
        elements.add(3);
        elements.add(8);
        elements.add(3);
        elements.add(1);
        elements.add(2);

        Collections.sort(elements);



        for (int element : elements){

            boolean worked = false;

            for (Bin bin : bins){

                if (bin.addElement(element)){
                    worked = true;
                    break;
                }

            }

            if (!worked) {
                bins.add(new Bin());
                bins.get(bins.size()-1).addElement(element);
            }
        }

        for (Bin bin : bins){
            System.out.println("Restplatz im Bin: " + bin.getFreeSpace());
        }

        System.out.println("Anzahl bins: " + bins.size());
    }
}
