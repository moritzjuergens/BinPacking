package DefaultPackage;

import java.util.ArrayList;

public class Bin {

    private static int MAXSIZE;
    private ArrayList<Integer> elements = new ArrayList<Integer>();

    public Bin() {
        //Should the MaxSize not be initialized, this will throw an Exception and the constructor won't create a bin
        //This is quite impossible to happen but safety first ;)
    	getMaxSize();
    }

    //Method to set the Maxsize of all Bins
    //This id static so every Bin is the same size
    public static void setMaxSize (int maxSize) {
        //test if Maxsize is already initialized
    	if (MAXSIZE > 0) {
    	    //if so: throw an Exeption
    		throw new IllegalArgumentException("MaxSize was already initialized with value " + MAXSIZE);
    	}
    	//test if Maxsize is zero or negetaive
    	if (maxSize < 1) {
			throw new IllegalArgumentException("Size must be bigger than zero");
		}
		//Now we can safely set our maxsize
    	MAXSIZE = maxSize;
    }

    //Does what a typical getter would do
    //But tests if it's already initialized -> see Constructor
    public static int getMaxSize() {
    	if (MAXSIZE < 1) {
    		throw new IllegalArgumentException("MaxSize of Bin may not be initialized");
    	}
    	return MAXSIZE;
    }

    //Method to add an Element to the bin
    //This is a Boolean so that the Worker knows if it is added or not
    public boolean addElement (int element) {
        //Tests if the given Element fits into the bin
        if (element <= this.calculateFreeSpace()) {
            elements.add(element);
            return true;
        } else {
            return false;
        }
    }

    //Method to calculate the free Space the Bin has
    public int calculateFreeSpace() {
        //Decelerate an Integer to count out free Space
        //Initialize it with out Maxsize
    	int freeSpace = getMaxSize();
    	//Loop over our List of elements
    	for (int element : elements) {
    	    //for every Element we substract the elements size
            freeSpace -= element;
        }    	
    	return freeSpace;
    }

    //Method to return the List of elements
    public ArrayList<Integer> getElements() {
        return this.elements;
    }

    //Tests if the given Element is able to fit into any Bin
    public static void validateElement(int element) {
        //Tests if the Element is zero or negetaiv
    	if (element < 1) {
    		throw new IllegalArgumentException("Element can't be negative or zero");
    	}
    	//Tests if the Element is bigger than our maxsize
    	if (element > getMaxSize()) {
    		throw new IllegalArgumentException("Element is too big. Maximum size is " + getMaxSize());
    	}
    }
}