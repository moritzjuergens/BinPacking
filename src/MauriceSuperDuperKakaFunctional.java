import java.util.ArrayList;
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


        elements.stream()
                .forEach(e -> bins
                        .stream()
                        .filter(b -> b.getFreeSpace() >= e)
                        .findFirst()
                        .orElseGet(() -> {
                            bins.add(new Bin());
                            return bins.get(bins.size()-1);
                        })
                        .addElement(e)
                );


        bins.stream().forEach(i -> System.out.println("Restplatz im Bin: " + i.getFreeSpace()));


    }
}
