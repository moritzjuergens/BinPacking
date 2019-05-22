package DefaultPackage;

import java.util.ArrayList;

public class Bin {

    private static int MAXSIZE;
    private ArrayList<Integer> elements = new ArrayList<Integer>();

    public Bin() {
        //Should the MaxSize not be initialized, this will throw an exception and the constructor won't create a bin
        //This is quite impossible to happen but safety first ;)
    	getMaxSize();
    }

    //Method to set the MaxSize of all Bins
    //MaxSize is static so that every Bin is the same size
    public static void setMaxSize (int maxSize) {
        //test if Maxsize has already been already initialized
    	if (MAXSIZE > 0) {
    	    //if so: throw an exception
    		throw new IllegalArgumentException("MaxSize was already initialized with value " + MAXSIZE);
    	}
    	//test whether Maxsize is zero or negative
    	if (maxSize < 1) {
			throw new IllegalArgumentException("Size must be bigger than zero");
		}
		//Now we can safely set our maxsize
    	MAXSIZE = maxSize;
    }

    //Does what a typical getter would do
    //But tests if it has already been already initialized -> see constructor
    public static int getMaxSize() {
    	if (MAXSIZE < 1) {
    		throw new IllegalArgumentException("MaxSize of Bin may not be initialized");
    	}
    	return MAXSIZE;
    }

    //Method to add an element to the bin
    //This is a boolean so that the worker knows if it is added or not
    public boolean addElement (int element) {
        //Tests if the given element fits into the bin
        if (element <= this.calculateFreeSpace()) {
            elements.add(element);
            return true;
        } else {
            return false;
        }
    }

    //Method to calculate the free space the Bin has
    public int calculateFreeSpace() {
        //Declare an integer to count the free space
        //Initialize it with out MaxSize
    	int freeSpace = getMaxSize();
    	//Loop over our list of elements
    	for (int element : elements) {
    	    //for every element we subtract the elements size
            freeSpace -= element;
        }    	
    	return freeSpace;
    }

    //Method to return the list of elements
    public ArrayList<Integer> getElements() {
        return this.elements;
    }

    //Tests if the given element is able to fit into any Bin
    public static void validateElement(int element) {
        //Tests whether the element is zero or negative
    	if (element < 1) {
    		throw new IllegalArgumentException("Element can't be negative or zero");
    	}
    	//Tests if the element is bigger than our maxsize
    	if (element > getMaxSize()) {
    		throw new IllegalArgumentException("Element is too big. Maximum size is " + getMaxSize());
    	}
    }
}