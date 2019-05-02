import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MauriceSuperDuperKakaFunctional {

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


        bins.add(new Bin());



        elements.stream()
                .forEach(i -> bins.stream()
                        .filter(j -> j.getFreeSpace() >= i)
                        .findFirst()
                        .map(k -> {
                            if (!k.addElement(i)){
                                bins.add(new Bin());
                                bins.get(bins.size()-1).addElement(i);
                            }
                            return false;
                        })
                );

        bins.stream().forEach(i -> System.out.println("Restplatz im Bin: " + i.getFreeSpace()));

/*


        for (int element : elements){

            boolean worked = false;

            for (Bin bin : bins){

                if (bin.addElement(element)){
                    worked = true;
                    break;
                }

            }

            bins.stream().map(i -> i.addElement(element));
            //bins.stream().forEach(i -> i.);

            if (!worked) {
                bins.add(new Bin());
                bins.get(bins.size()-1).addElement(element);
            }
        }

        bins.stream().forEach(i -> System.out.println("Restplatz im Bin: " + i.getFreeSpace()));


        System.out.println("Anzahl bins: " + bins.size());
    }

 */
    }
}
