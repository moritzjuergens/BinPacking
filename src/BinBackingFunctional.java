import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinBackingFunctional {

    static List<Integer> elements = new ArrayList<Integer>();
    static List<BinUserInteraction> bins = new ArrayList<BinUserInteraction>();

    private int binSize, elementCount;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Wie groß soll ein Bin sein?");
        int binSize = s.nextInt();
        System.out.println("Wie viele Elemente wollen Sie einsortieren?");
        int elementCount = s.nextInt();
        int elementSize;

        for (int i = 0; i < elementCount; i++){
            System.out.println("Wie groß soll das " + (i+1) + ". Element sein?");
            elementSize = s.nextInt();
            elements.add(elementSize);
        }

        elements.stream()
                .forEach(e -> bins
                        .stream()
                        .filter(b -> b.getFreeSpace() >= e)
                        .findFirst()
                        .orElseGet(() -> {
                            bins.add(new BinUserInteraction(binSize));
                            return bins.get(bins.size()-1);
                        })
                        .addElement(e)
                );

        printResult();
    }

    public BinBackingFunctional(int binSize, int elementCount, List<Integer> elements, List<BinUserInteraction> bins) {
        this.binSize = binSize;
        this.elementCount = elementCount;
        this.elements = elements;
        this.bins = bins;


        int binSize2 = 0;
        int elementSize;


        elements.stream()
                .forEach(e -> bins
                        .stream()
                        .filter(b -> b.getFreeSpace() >= e)
                        .findFirst()
                        .orElseGet(() -> {
                            bins.add(new BinUserInteraction(binSize2));
                            return bins.get(bins.size()-1);
                        })
                        .addElement(e)
                );

        printResult();
    }

    private static void printResult(){
        System.out.println("Number of bins: " + bins.size());

        bins.stream()
                .forEach(i -> System.out.println("Freespace in " + i + " Bin: "  + i.getFreeSpace()));
    }
}
