import java.util.ArrayList;

public class Bin {

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

    public ArrayList<Integer> getElements() {
        return this.elements;
    }
}