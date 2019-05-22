package DefaultPackage;

import java.util.ArrayList;

//Interface to help implement our workers
public interface Worker {
	public void insertElement(int element);
	public String getNumberOfElements();
	public String[][] getDisplayData();
	public ArrayList<Integer> getBinIndexOfFullBins();
}