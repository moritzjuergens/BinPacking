import java.util.ArrayList;

public class BinUserInteraction {


    private int maxsize;
    private int freeSpace;

    public BinUserInteraction(int maxsize) {
        this.maxsize = maxsize;
        this.freeSpace = maxsize;

    }

    public int getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(int maxsize) {
        this.maxsize = maxsize;
    }

    public int getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(int freeSpace) {
        this.freeSpace = freeSpace;
    }



    /*
    private static int MAXSIZE = 10;
    private int freeSpace;
    */

    private ArrayList<Integer> elements = new ArrayList<Integer>();

    /*
    public BinUserInteraction() {
        this.freeSpace = MAXSIZE;
    }
    */

    public boolean addElement(int element) {

        if (element <= this.getFreeSpace()) {
            elements.add(element);
            this.updateFreeSpace();
            return true;
        } else {
            return false;
        }
    }

    public void updateFreeSpace() {

        int freeSpace = this.getMaxsize();

        for (int element : elements) {
            freeSpace -= element;
        }

        this.setFreeSpace(freeSpace);
    }

    /*

    public int getFreeSpace() {
        return this.freeSpace;
    }

    private void setFreeSpace(int freeSpace){
        this.freeSpace = freeSpace;


     */

}

