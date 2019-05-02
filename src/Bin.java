import java.util.ArrayList;

public class Bin {

    /*
    private final int maxsize;
    private int freeSpace;

    public Bin(int maxsize, int freeSpace) {
        this.maxsize = maxsize;
        this.freeSpace = freeSpace;

    }

    public int getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(int maxsize) {
        maxsize = 10;
    }

    public int getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(int freeSpace) {
        this.freeSpace = freeSpace;
    }
    */



    private static int MAXSIZE = 10;
    private int freeSpace;
    private ArrayList<Integer> elements = new ArrayList<Integer>();

    public Bin() {
        this.freeSpace = MAXSIZE;
    }

    public boolean addElement (int element){

        if (element <= this.getFreeSpace()){
            elements.add(element);
            this.updateFreeSpace();
            return true;
        }else {
            return false;
        }
    }

    public void updateFreeSpace(){

        int freeSpace = MAXSIZE;

        for (int element : elements) {
            freeSpace -= element;
        }

        this.setFreeSpace(freeSpace);
    }

    public int getFreeSpace() {
        return this.freeSpace;
    }

    private void setFreeSpace(int freeSpace){
        this.freeSpace = freeSpace;


    }
}
