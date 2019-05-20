package DefaultPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class WorkerNormal implements Worker {

	private static List<Bin> bins = new ArrayList<Bin>();

	//Method to insert an Element into the bins
	public void insertElement(int element) {
	    //validate the Element (must be bigger than zero and smaller than maxsize of the bins)
    	Bin.validateElement(element);
    	//declarate a boolean
        //and initialize it with false
        boolean success = false;
        //Loop through all bins
        for (Bin bin : bins) {
            //Test if the current Bin can add the given Element
            if (bin.addElement(element)) {
                //if so: set our boolean to true and break the loop
                success = true;
                break;
            }
        }
        //tests if the given Element was added somewhere
        //Isn't there any bin this will call too
        if (!success) {
            //So now we add a new bin and directly place our Element into the new Bin
            bins.add(new Bin());
            bins.get(bins.size()-1).addElement(element);
        }
    }

    //Method to return all the Data for later Display
    public String[][] getDisplayData() {
	    //Declarate a String array with two dimensions
        //The first dimensions is the as big as many bins we have
        //The second dimensions only has two places; one for the number the current bin is and the second one for all the elements
        String[][] data = new String[bins.size()][2];

        //Loop through all bins to add them into the array
        for (int i = 0; i < bins.size(); i++) {
            //Add the number the current Bin is
            data[i][0] = String.valueOf(i + 1);
            //Add all the Elements the current Bin has as String -> see the Method itself
            data[i][1] = getElements(bins.get(i));
        }
        //return the array
    	return data;
    }

    //Method to get a String with all Elements
	private static String getElements(Bin bin) {
	    //Declarate a StringJoiner
        //This StringJoiner will stick all Strings we give him together and he will seperate them with ", "
		StringJoiner stringJoiner = new StringJoiner(", ");

		//Loop through all Elements and add them
        for (int element: bin.getElements()) {
        	stringJoiner.add(String.valueOf(element));
        }

		return stringJoiner.toString();
	}
	
}
