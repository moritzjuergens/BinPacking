package DefaultPackage;

import java.util.ArrayList;

public class Bin {

    private static int MAXSIZE;
    private ArrayList<Integer> elements = new ArrayList<Integer>();

    public Bin() {
    	getMaxSize();
    }
    
    public static void setMaxSize (int maxSize) {
    	if (MAXSIZE > 0) {
    		throw new IllegalArgumentException("MaxSize was already initialized with value " + MAXSIZE);
    	}
    	if (maxSize < 1) {
			throw new IllegalArgumentException("Size must be bigger than zero");
		}
    	MAXSIZE = maxSize;
    }
    
    public static int getMaxSize() {
    	if (MAXSIZE < 1) {
    		throw new IllegalArgumentException("MaxSize of Bin may not be initialized");
    	}
    	return MAXSIZE;
    }
    
    public boolean addElement (int element) {
        if (element <= this.calculateFreeSpace()) {
            elements.add(element);
            return true;
        } else {
            return false;
        }
    }

    public int calculateFreeSpace() {
    	int freeSpace = getMaxSize();
    	for (int element : elements) {
            freeSpace -= element;
        }    	
    	return freeSpace;
    }

    public ArrayList<Integer> getElements() {
        return this.elements;
    }
    
    public static void validateElement(int element) {
    	if (element < 1) {
    		throw new IllegalArgumentException("Element can't be negative or zero");
    	}
    	if (element > getMaxSize()) {
    		throw new IllegalArgumentException("Element is too big. Maximum size is " + getMaxSize());
    	}
    }
}