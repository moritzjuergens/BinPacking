package DefaultPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class WorkerNormal implements Worker {

	private static List<Bin> bins = new ArrayList<Bin>();

	//Method to insert an Element into the bins
	public void insertElement(int element) {
	    //validate the element -> must be bigger than zero and smaller than maxsize of the bins)
    	Bin.validateElement(element);
    	//declare a boolean and initialize it with false
        boolean success = false;
        //Loop through all of the bins
        for (Bin bin : bins) {
            //Test if given element can be added to current bin
            if (bin.addElement(element)) {
                //if so: set our boolean to true and break the loop
                success = true;
                break;
            }
        }
        //tests if the given element was added somewhere
        //If there isn't any bin, this will be called to
        if (!success) {
            //So now we add a new bin and directly place our Element into the new bin
            bins.add(new Bin());
            bins.get(bins.size()-1).addElement(element);
        }
    }

    //Method to return all the data to display later
    public String[][] getDisplayData() {
	    //Declare a String array with two dimensions
        //The first dimensions is as big as the number of bins
        //The second dimensions only has two places; one for the number of the current bin and the second one for all of the elements
        String[][] data = new String[bins.size()][2];

        //Loop through all bins to add them into the array
        for (int i = 0; i < bins.size(); i++) {
            //Add the number of the current bin
            data[i][0] = String.valueOf(i + 1);
            //Add all the elements the current bin has as String -> see the Method itself
            data[i][1] = getElements(bins.get(i));
        }
        //return the array
    	return data;
    }

    //Method to get a string with all elements
	private static String getElements(Bin bin) {
	    //Declare a StringJoiner
        //This StringJoiner will stick all Strings we give him together and he will separate them with ", "
		StringJoiner stringJoiner = new StringJoiner(", ");

		//Loop through all Elements and add them
        for (int element: bin.getElements()) {
        	stringJoiner.add(String.valueOf(element));
        }

		return stringJoiner.toString();
	}
	
}
